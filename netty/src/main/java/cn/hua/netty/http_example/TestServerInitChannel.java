package cn.hua.netty.http_example;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/** 初始化器
 * @author
 * @create 2018-05-28 8:50
 **/
public class TestServerInitChannel extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //channel管道
        ChannelPipeline pipeline = ch.pipeline();
        //编码解码
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        //自定义处理器
        pipeline.addLast("testHttpServerHandler", new TestHttpServerHandler());
    }
}
