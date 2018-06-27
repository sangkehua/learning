package cn.hua.netty.nio_example.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FileTest {

    private FileTest() {
    }


    public  void test() throws Exception {
        FileInputStream inputStream = new FileInputStream("src/file/a.png");
        FileOutputStream outputStream = new FileOutputStream("src/file/b.png");

        FileChannel inChannel = inputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        outChannel.close();
        inChannel.close();
        outputStream.close();
        inputStream.close();
    }


    private static void test1() throws Exception {
        FileChannel inChannel = FileChannel.open(Paths.get("src/file/a.png"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("src/file/c.png"), StandardOpenOption.READ, StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);

        MappedByteBuffer inBuffer = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outBuffer = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());

        byte[] dst = new byte[inBuffer.limit()];
        inBuffer.get(dst);
        outBuffer.put(dst);
        outChannel.close();
        inChannel.close();
    }


    private static void test2() throws Exception {
        FileChannel inChannel = FileChannel.open(Paths.get("src/file/a.png"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("src/file/d.png"), StandardOpenOption.READ, StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);

        inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.close();
        inChannel.close();
    }


    private static void test3() throws Exception {

        RandomAccessFile randomAccessFile = new RandomAccessFile("src/file/1.txt", "rw");

        FileChannel channel = randomAccessFile.getChannel();

        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        ByteBuffer[] buffers = {buf1, buf2};
        channel.read(buffers);

        for (ByteBuffer byteBuffer : buffers) {
            byteBuffer.flip();
        }

        System.out.println(new String(buffers[0].array(), 0, buffers[0].limit()));
        System.out.println("-------------------------------------------");
        System.out.println(new String(buf1.array(), 0, buf1.limit()));
        System.out.println("-------------------------------------------");
        System.out.println(new String(buffers[1].array(), 0, buffers[1].limit()));
        System.out.println("-------------------------------------------");
        System.out.println(new String(buf2.array(), 0, buf2.limit()));

        RandomAccessFile randomAccessFile2 = new RandomAccessFile("src/file/2.txt", "rw");
        FileChannel fileChannel = randomAccessFile2.getChannel();
        fileChannel.write(buffers);
        fileChannel.close();
        randomAccessFile.close();
    }


    private void test4() {
        Map<String, Charset> map = Charset.availableCharsets();

        Set<Entry<String, Charset>> set = map.entrySet();

        for (Entry<String, Charset> entry : set) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }


    private static void test5() throws IOException {
        Charset charset = Charset.forName("GBK");
//
//		CharsetEncoder encoder = charset.newEncoder();
//		CharsetDecoder decoder = charset.newDecoder();

        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("李亚明SB");
        charBuffer.flip();

        ByteBuffer buffer = charset.encode(charBuffer);
        for (int i = 0; i < buffer.limit(); i++) {
            System.out.println(buffer.get());
        }
        buffer.flip();
        CharBuffer charBuffer2 = charset.decode(buffer);
        System.out.println(charBuffer2.toString());
    }

    public static void main(String[] args) {
        try {
//            test();
//            test1();
//            test2();
//            test3();
            test5();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
