package cn.hua.netty.thrift_example.test;

import cn.hua.netty.thrift_example.PersonService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * thrift服务端
 */
public class ThriftServer {

    public static final int SERVER_PORT = 8090;

    public static final int SERVER_PORT1 = 8091;

    public static final int SERVER_PORT2 = 8092;

    public static final int SERVER_PORT3 = 8093;

    public static final int SERVER_PORT4 = 8094;

    // 简单的单线程服务模型，一般用于测试
    private static void testTSimpleServer() throws TTransportException {
        System.out.println("ThriftServer————TSimpleServer Start");
        TServerSocket socket = new TServerSocket(SERVER_PORT);
        TServer.Args args = new TServer.Args(socket);
        TProcessor processor = new PersonService.Processor<>(new PersonServiceImpl());
        args.processor(processor);
        args.protocolFactory(new TCompactProtocol.Factory());
        TServer server = new TSimpleServer(args);
        server.serve();
    }

    //线程池服务模型，使用标准的阻塞式IO，预先创建一组线程处理请求。
    private static void testTThreadPoolServer() throws TTransportException {
        System.out.println("ThriftServer————TThreadPoolServer Start");
        TServerSocket socket = new TServerSocket(SERVER_PORT1);
        TThreadPoolServer.Args args = new TThreadPoolServer.Args(socket);
        TProcessor processor = new PersonService.Processor<>(new PersonServiceImpl());
        args.processor(processor);
        args.protocolFactory(new TCompactProtocol.Factory());
        TServer server = new TThreadPoolServer(args);
        server.serve();
    }
    // 非阻塞式IO
    private static void testTNonblockingServer() throws TTransportException {
        System.out.println("ThriftServer————TNonblockingServer Started");
        TNonblockingServerSocket socket = new TNonblockingServerSocket(SERVER_PORT2);
        TNonblockingServer.Args args = new TNonblockingServer.Args(socket);
        TProcessor processor = new PersonService.Processor<>(new PersonServiceImpl());

        args.protocolFactory(new TCompactProtocol.Factory());
        // 使用非阻塞式IO，服务端和客户端需要指定TFramedTransport数据传输的方式
        args.transportFactory(new TFramedTransport.Factory());
        args.processorFactory(new TProcessorFactory(processor));
        TServer server = new TNonblockingServer(args);
        server.serve();
    }

    //半同步半异步的服务端模型，需要指定为： TFramedTransport 数据传输的方式。
    private static void testTHsHaServer() throws TTransportException {
        System.out.println("ThriftServer————THsHaServer Started");
        TNonblockingServerSocket socket = new TNonblockingServerSocket(SERVER_PORT3);
        THsHaServer.Args args = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        TProcessor processor = new PersonService.Processor<>(new PersonServiceImpl());

        args.protocolFactory(new TCompactProtocol.Factory());
        // 使用非阻塞式IO，服务端和客户端需要指定TFramedTransport数据传输的方式
        args.transportFactory(new TFramedTransport.Factory());
        args.processorFactory(new TProcessorFactory(processor));
        TServer server = new THsHaServer(args);
        server.serve();
    }

    /**
     * 多线程Half-sync/Half-async的服务模型.
     * 需要指定为： TFramedTransport 数据传输的方式。
     */
    private static void testTThreadedSelectorServer() throws TTransportException {
        System.out.println("ThriftServer————THsHaServer Started");
        // 非阻塞式的，配合TFramedTransport使用
        TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(SERVER_PORT4);
        // 关联处理器与Service服务的实现
        TProcessor processor = new PersonService.Processor<>(new PersonServiceImpl());
        // 目前Thrift提供的最高级的模式，可并发处理客户端请求
        TThreadedSelectorServer.Args args = new TThreadedSelectorServer.Args(serverTransport);
        // 设置协议工厂，高效率的、密集的二进制编码格式进行数据传输协议
        args.protocolFactory(new TCompactProtocol.Factory());
        // 设置传输工厂，使用非阻塞方式，按块的大小进行传输，类似于Java中的NIO
        args.transportFactory(new TFramedTransport.Factory());
        // 设置处理器工厂,只返回一个单例实例
        args.processorFactory(new TProcessorFactory(processor));
        // 多个线程，主要负责客户端的IO处理
        args.selectorThreads(2);
        // 工作线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);
        args.executorService(pool);
        TThreadedSelectorServer server = new TThreadedSelectorServer(args);
        server.serve();
    }


    public static void main(String[] args) throws TTransportException {
//        testTSimpleServer();
//        testTThreadPoolServer();
//        testTNonblockingServer();
//        testTHsHaServer();
        testTThreadedSelectorServer();


    }
}
