package cn.hua.netty.protobuf_example;

import com.google.protobuf.InvalidProtocolBufferException;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

public class ProtobufTest {
    public static void main(String[] args) {
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("张三").setAge(20).setAddress("杭州").build();
        byte[] studentByte = student.toByteArray();

        try {
            DataInfo.Student student1 = DataInfo.Student.parseFrom(studentByte);
            System.out.println(student1.getName());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
