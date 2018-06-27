package cn.hua.netty.grpc_example.test;

import cn.hua.netty.grpc_example.AnimalRequest;
import cn.hua.netty.grpc_example.AnimalResponse;
import cn.hua.netty.grpc_example.AnimalResponseList;
import cn.hua.netty.grpc_example.AnimalServiceGrpc;
import cn.hua.netty.grpc_example.AnimalServiceGrpc.AnimalServiceImplBase;
import cn.hua.netty.grpc_example.MyRequest;
import cn.hua.netty.grpc_example.MyResponse;
import cn.hua.netty.grpc_example.StreamRequest;
import cn.hua.netty.grpc_example.StreamResponse;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

public class AnimalServiceImpl extends AnimalServiceImplBase {
    @Override
    public void getRealNameByUserName(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接收到客户端信息：" + request.getUsername());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("王五").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getAnimalsByAge(AnimalRequest request, StreamObserver<AnimalResponse> responseObserver) {
        System.out.println("接收到客户端信息：" + request.getAge());
        responseObserver.onNext(AnimalResponse.newBuilder().setName("张三").setAge(20).setCity("杭州").build());
        responseObserver.onNext(AnimalResponse.newBuilder().setAge(20).setCity("北京").build());
        responseObserver.onNext(AnimalResponse.newBuilder().setName("王五").setCity("上海").build());
        responseObserver.onNext(AnimalResponse.newBuilder().setName("赵六").setAge(20).build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<AnimalRequest> getAnimalResponseListByAges(StreamObserver<AnimalResponseList> responseObserver) {
//        AnimalServiceGrpc.
        return new StreamObserver<AnimalRequest>() {

            @Override
            public void onNext(AnimalRequest value) {
                System.out.println("onNext: " + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                AnimalResponse animalResponse = AnimalResponse.newBuilder().setName("张三").setAge(20).setCity("杭州").build();
                AnimalResponse animalResponse1 = AnimalResponse.newBuilder().setName("李四").setAge(8).setCity("杭州").build();
                AnimalResponseList animalResponseList = AnimalResponseList.newBuilder().addAnimalResponse(animalResponse).addAnimalResponse(animalResponse1).build();
                responseObserver.onNext(animalResponseList);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println(value.getRequestInfo());
                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
