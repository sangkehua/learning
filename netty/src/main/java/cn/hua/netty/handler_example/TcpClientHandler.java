package cn.hua.netty.handler_example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

public class TcpClientHandler extends SimpleChannelInboundHandler<TcpProtocol> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TcpProtocol msg) throws Exception {
        int length = msg.getLength();
        byte[] content = msg.getContent();

        System.out.println("客户端接收到消息：" + (++count));
        System.out.println("长度：" + length);
        System.out.println("内容：" + new String(content, Charset.forName("utf-8")));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            String message = "sent from client";
            int length = message.getBytes("utf-8").length;
            byte[] content = message.getBytes("utf-8");

            TcpProtocol tcpProtocol = new TcpProtocol();
            tcpProtocol.setLength(length);
            tcpProtocol.setContent(content);
            ctx.writeAndFlush(tcpProtocol);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.close();
    }
}
