package cn.hua.netty.grpc_example.test;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GrpcServer {

    private Server server;

    private static final int PORT = 8899;

    private void start() throws IOException {
        server = ServerBuilder.forPort(PORT)
                .addService(new AnimalServiceImpl())
                .build()
                .start();
        System.out.println("服务启动，端口为： " + PORT);
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("在jvm关闭之前关闭grpc服务");
            GrpcServer.this.stop();
            System.out.println("服务关闭");
        }));
    }

    private void stop() {
        if (server != null)
            server.shutdown();
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null)
            server.awaitTermination();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        GrpcServer server = new GrpcServer();
        server.start();
        server.blockUntilShutdown();
    }
}
