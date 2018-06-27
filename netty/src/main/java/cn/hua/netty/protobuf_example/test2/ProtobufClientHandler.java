package cn.hua.netty.protobuf_example.test2;

import cn.hua.netty.protobuf_example.test2.MyMessage.Message;
import cn.hua.netty.protobuf_example.test2.MyMessage.Person;
import cn.hua.netty.protobuf_example.test2.MyMessage.Dog;
import cn.hua.netty.protobuf_example.test2.MyMessage.Cat;
import cn.hua.netty.protobuf_example.test2.MyMessage.Message.Type;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class ProtobufClientHandler extends SimpleChannelInboundHandler<Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int randomInt = new Random().nextInt(3);

        Message message = null;
        switch (randomInt) {
            case 0:
                message =
                        Message.newBuilder()
                                .setType(Type.PersonType)
                                .setPerson(
                                        Person.newBuilder()
                                                .setName("张三")
                                                .setAge(20)
                                                .setAddress("北京")
                                                .build())
                                .build();
                break;
            case 1:
                message =
                        Message.newBuilder()
                                .setType(Type.DogType)
                                .setDog(
                                        Dog.newBuilder()
                                                .setName("旺财")
                                                .setAge(5)
                                                .build())
                                .build();
                break;
            case 2:
                message =
                        Message.newBuilder()
                                .setType(Type.CatType)
                                .setCat(
                                        Cat.newBuilder()
                                                .setName("李亚明")
                                                .setAddress("杭州")
                                                .build())
                                .build();
                break;
        }

        ctx.channel().writeAndFlush(message);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.channel().close();
    }
}
