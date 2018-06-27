package cn.hua.netty.nio_example;

import cn.hua.netty.nio_example.test1.FileTest;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);
            FileTest fileTest = (FileTest) unsafe.allocateInstance(FileTest.class);
            System.out.println(fileTest.getClass());
            fileTest.test();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
