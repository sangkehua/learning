package cn.hua.netty.http_example;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author
 * @create 2018-05-25 16:28
 **/
public class TestServer {

    public static void main(String[] args) throws Exception {
        //事件循环组，死循环
        //接收客户端连接，将业务处理交给workerGroup
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //处理业务
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //服务端启动类（辅助封装类，简化netty相关配置）
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //第一个参数负责接收链接，第二个参数负责处理业务
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) //定义通道
                    .childHandler(new TestServerInitChannel());//定义子处理器
            ChannelFuture future = serverBootstrap.bind(8899).sync();
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
