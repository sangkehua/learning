package cn.hua.netty.nio_example;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * 服务端
 */
public class NioServer {

    private static Map<String, SocketChannel> clientMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println(selector);
        while (true) {
            try {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(selectionKey -> {
                    final SocketChannel client;
                    try {
                        if (selectionKey.isAcceptable()) {
                            ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                            client = server.accept();
                            client.configureBlocking(false);
                            client.register(selector, SelectionKey.OP_READ);

                            clientMap.put(UUID.randomUUID().toString(), client);
                        } else if (selectionKey.isReadable()) {
                            client = (SocketChannel) selectionKey.channel();
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                            String message = "";
                            String sender = "";
                            for (Map.Entry<String, SocketChannel> map : clientMap.entrySet()) {
                                if (client == map.getValue()) {
                                    sender = map.getKey();
                                    break;
                                }
                            }
                            if (client.read(readBuffer) > 0) {
                                readBuffer.flip();
                                message = String.valueOf(Charset.forName("utf-8").decode(readBuffer).array());
                                System.out.println(sender + " : " + message);
                            }

                            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                            for (Map.Entry<String, SocketChannel> map : clientMap.entrySet()) {
                                SocketChannel channel = map.getValue();
                                writeBuffer.put((sender + " : " + message).getBytes());
                                writeBuffer.flip();
                                channel.write(writeBuffer);
                                writeBuffer.clear();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });
                selectionKeys.clear();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }
}
