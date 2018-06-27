package cn.hua.netty.grpc_example.test;

import cn.hua.netty.grpc_example.AnimalRequest;
import cn.hua.netty.grpc_example.AnimalResponse;
import cn.hua.netty.grpc_example.AnimalResponseList;
import cn.hua.netty.grpc_example.AnimalServiceGrpc;
import cn.hua.netty.grpc_example.MyRequest;
import cn.hua.netty.grpc_example.MyResponse;
import cn.hua.netty.grpc_example.StreamRequest;
import cn.hua.netty.grpc_example.StreamResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class GrpcClient {

    private final ManagedChannel channel;
    private final AnimalServiceGrpc.AnimalServiceBlockingStub blockingStub;
    private final AnimalServiceGrpc.AnimalServiceFutureStub futureStubStub;
    private final AnimalServiceGrpc.AnimalServiceStub stub;

    public GrpcClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
    }

    GrpcClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = AnimalServiceGrpc.newBlockingStub(channel);
        futureStubStub = AnimalServiceGrpc.newFutureStub(channel);
        stub = AnimalServiceGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void getResult(String name) {
        MyRequest request = MyRequest.newBuilder().setUsername(name).build();
        MyResponse response;
        try {
            response = blockingStub.getRealNameByUserName(request);
        } catch (StatusRuntimeException e) {
            System.out.println(e.getStatus());
            return;
        }
        System.out.println("获取到的信息：" + response.getRealname());
    }

    public void getAnimalResponse() {
        Iterator<AnimalResponse> itr = blockingStub.getAnimalsByAge(AnimalRequest.newBuilder().setAge(20).build());
        while (itr.hasNext()) {
            AnimalResponse response = itr.next();
            System.out.println(response.getName() + "," + response.getAge() + "," + response.getCity());
        }
    }

    public void getAnimalResponseList() {
        StreamObserver<AnimalResponseList> animalResponseListStreamObserver = new StreamObserver<AnimalResponseList>() {

            @Override
            public void onNext(AnimalResponseList value) {
                value.getAnimalResponseList().forEach(response -> {
                    System.out.println(response.getName() + " _ " + response.getAge() + " _ " + response.getCity());
                });
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        };
        StreamObserver<AnimalRequest> animalRequestStreamObserver = stub.getAnimalResponseListByAges(animalResponseListStreamObserver);
        animalRequestStreamObserver.onNext(AnimalRequest.newBuilder().setAge(20).build());
        animalRequestStreamObserver.onNext(AnimalRequest.newBuilder().setAge(18).build());
        animalRequestStreamObserver.onCompleted();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getStreamResponse(){
        StreamObserver<StreamRequest> streamRequestStreamObserver = stub.biTalk(new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                System.out.println(value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        });
        for (int i = 0 ; i < 5 ; i++){
            streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo(i + "->").build());
        }
        streamRequestStreamObserver.onCompleted();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GrpcClient client = new GrpcClient("localhost", 8899);
        try {
            String name = "张三";
            if (args.length > 0) {
                name = args[0];
                System.out.println(args.toString());
                System.out.println(name);
            }
            System.out.println();
            System.out.println("简单rpc\n" +
                    "这就是一般的rpc调用，一个请求对象对应一个返回对象");
            client.getResult(name);
            System.out.println();
            System.out.println("服务端流式rpc\n" +
                    "一个请求对象，服务端可以传回多个结果对象");
            client.getAnimalResponse();
            System.out.println();
            System.out.println("客户端流式rpc\n" +
                    "客户端传入多个请求对象，服务端返回一个响应结果");
            client.getAnimalResponseList();
            System.out.println();
            System.out.println("双向流式rpc\n" +
                    "结合客户端流式rpc和服务端流式rpc，可以传入多个对象，返回多个响应对象");
            client.getStreamResponse();
        } finally {
            client.shutdown();
        }
    }
}
