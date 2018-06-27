package cn.hua.netty.thrift_example.test;

import cn.hua.netty.thrift_example.Person;
import cn.hua.netty.thrift_example.PersonService;
import org.apache.thrift.TApplicationException;
import org.apache.thrift.TException;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.io.IOException;

public class ThriftClient {
    public static final String SERVER_IP = "localhost";

    public static final int SERVER_PORT = 8090;

    public static final int SERVER_PORT1 = 8091;

    public static final int SERVER_PORT2 = 8092;

    public static final int SERVER_PORT3 = 8093;

    public static final int SERVER_PORT4 = 8094;

    public static final int TIMEOUT = 30000;

    private static void testClient2() {
        TTransport transport = new TFramedTransport(new TSocket(SERVER_IP, SERVER_PORT4, TIMEOUT));
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {
            transport.open();
            Person person = client.getPersonByUsername("张三");
            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());

            Person person1 = new Person();
            person1.setUsername("李四");
            person1.setAge(55);
            person1.setMarried(true);
            client.savePerson(person1);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if( transport != null){
                transport.close();
            }
        }
    }

    private static void testClient1() {
        TTransport transport = null;
        try {
            transport = new TSocket(SERVER_IP, SERVER_PORT1, TIMEOUT);
            // 协议要和服务端一致
            TProtocol protocol = new TCompactProtocol(transport);
            // TProtocol protocol = new TCompactProtocol(transport);
            // TProtocol protocol = new TJSONProtocol(transport);
            PersonService.Client client = new PersonService.Client(protocol);
            transport.open();
            Person person = client.getPersonByUsername("张三");
            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());

            Person person1 = new Person();
            person1.setUsername("李四");
            person1.setAge(55);
            person1.setMarried(true);
            client.savePerson(person1);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            //处理服务端返回值为null问题

            if (e instanceof TApplicationException

                    && ((TApplicationException) e).getType() ==

                    TApplicationException.MISSING_RESULT) {

                System.out.println("The result of lg_userinfo_getUserNameById function is NULL");

            }
        } finally {
            if (transport != null) {
                transport.close();
            }
        }
    }
    //异步客户端
    private void testClientAsync(){

        try {
            TAsyncClientManager manager = new TAsyncClientManager();
            TNonblockingTransport transport = new TNonblockingSocket(SERVER_IP,SERVER_PORT4,TIMEOUT);
            TProtocolFactory protocolFactory = new TCompactProtocol.Factory();
            PersonService.AsyncClient asyncClient = new PersonService.AsyncClient(protocolFactory,manager,transport);
            MethodCallback methodCallBack = new MethodCallback();
//            Person person1 = new Person();
//            person1.setUsername("李四");
//            person1.setAge(55);
//            person1.setMarried(true);
            asyncClient.getPersonByUsername("李四",methodCallBack);
            while (true) {
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
//        testClient1();
//        testClient2();
        ThriftClient client = new ThriftClient();
        client.testClientAsync();
    }
}
