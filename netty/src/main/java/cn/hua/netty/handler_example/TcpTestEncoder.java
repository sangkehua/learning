package cn.hua.netty.handler_example;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class TcpTestEncoder extends MessageToByteEncoder<TcpProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, TcpProtocol msg, ByteBuf out) throws Exception {
        System.out.println("TcpTestEncoder Invoked");

        out.writeInt(msg.getLength());
        out.writeBytes(msg.getContent());
    }
}
