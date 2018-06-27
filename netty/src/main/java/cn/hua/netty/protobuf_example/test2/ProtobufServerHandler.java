package cn.hua.netty.protobuf_example.test2;

import cn.hua.netty.protobuf_example.test2.MyMessage.Message;
import cn.hua.netty.protobuf_example.test2.MyMessage.Message.Type;
import cn.hua.netty.protobuf_example.test2.MyMessage.Person;
import cn.hua.netty.protobuf_example.test2.MyMessage.Dog;
import cn.hua.netty.protobuf_example.test2.MyMessage.Cat;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtobufServerHandler extends SimpleChannelInboundHandler<Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        Type type = msg.getType();
        switch (type) {
            case PersonType:
                Person person = msg.getPerson();
                System.out.println(person.getName());
                System.out.println(person.getAge());
                System.out.println(person.getAddress());
                break;
            case DogType:
                Dog dog = msg.getDog();
                System.out.println(dog.getName());
                System.out.println(dog.getAge());
                break;
            case CatType:
                Cat cat = msg.getCat();
                System.out.println(cat.getName());
                System.out.println(cat.getAddress());
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.channel().close();
    }
}
