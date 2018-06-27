package cn.hua.netty.nio_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioClient {
    public static void main(String[] args) throws IOException {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("localhost", 8899));
            System.out.println(selector);
            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(selectionKey -> {
                    try {
                        if (selectionKey.isConnectable()) {
                            SocketChannel client = (SocketChannel) selectionKey.channel();
                            if (client.isConnectionPending()) {
                                client.finishConnect();
                                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                                writeBuffer.put((LocalDateTime.now() + " 连接成功").getBytes());
                                writeBuffer.flip();
                                client.write(writeBuffer);
                                client.register(selector,SelectionKey.OP_READ);
                                ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                                executorService.submit(()->{
                                    while (true) {
                                        writeBuffer.clear();
                                        InputStreamReader in = new InputStreamReader(System.in);
                                        BufferedReader br = new BufferedReader(in);
                                        String sendMessage = br.readLine();
                                        writeBuffer.put(sendMessage.getBytes());
                                        writeBuffer.flip();
                                        client.write(writeBuffer);
                                        writeBuffer.clear();
                                    }
                                });
                            }
                        } else if (selectionKey.isReadable()){
                            SocketChannel client = (SocketChannel) selectionKey.channel();
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                            client.read(readBuffer);
                            readBuffer.flip();
                            System.out.println(String.valueOf(Charset.forName("utf-8").decode(readBuffer).array()));
                        }
                    }catch ( IOException e) {
                        e.printStackTrace();
                    }
                });
                selectionKeys.clear();
            }

        } catch (Exception e) {

        }
    }
}
