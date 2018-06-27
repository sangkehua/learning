package cn.hua.netty.protobuf_example.test1;

import cn.hua.netty.protobuf_example.DataInfo.Student;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtobufServerHandler extends SimpleChannelInboundHandler<Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Student msg) throws Exception {
        System.out.println(msg.getName());
    }
}
