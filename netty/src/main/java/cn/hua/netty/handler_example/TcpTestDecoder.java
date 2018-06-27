package cn.hua.netty.handler_example;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class TcpTestDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("TcpTestDecoder Invoked");

        int length = in.readInt();
        byte[] content = new byte[length];
        in.readBytes(content);
        TcpProtocol tcpProtocol = new TcpProtocol();
        tcpProtocol.setLength(length);
        tcpProtocol.setContent(content);
        out.add(tcpProtocol);
    }
}
