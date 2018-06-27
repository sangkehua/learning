package cn.hua.netty.handler_example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

public class TcpServerHandler extends SimpleChannelInboundHandler<TcpProtocol> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TcpProtocol msg) throws Exception {
        int length = msg.getLength();
        byte[] content = msg.getContent();

        System.out.println("服务端接收到消息：" + (++count));
        System.out.println("长度：" + length);
        System.out.println("内容：" + new String(content, Charset.forName("utf-8")));

        String responseMessage = UUID.randomUUID().toString();
        int responseLength = responseMessage.getBytes("utf-8").length;
        byte[] responseContent = responseMessage.getBytes("utf-8");
        TcpProtocol tcpProtocol = new TcpProtocol();
        tcpProtocol.setLength(responseLength);
        tcpProtocol.setContent(responseContent);

        ctx.writeAndFlush(tcpProtocol);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
