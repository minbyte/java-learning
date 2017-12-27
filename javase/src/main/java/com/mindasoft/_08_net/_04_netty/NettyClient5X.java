package com.mindasoft._08_net._04_netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/25 18:30
 */
public class NettyClient5X {

    public static int PORT_NUMBER = 1234;
    public static String HOST = "1234";

    public static void main(String[] args) throws Exception {
        int port = PORT_NUMBER;
        if (args.length > 0) { // 覆盖默认的监听端口
            port = Integer.parseInt(args[0]);
        }
        System.out.println("Listening on port " + port);

        new NettyClient5X().bind(port);
    }

    private void bind(int port) throws Exception {
        EventLoopGroup clientGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(clientGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new MyChannelInitializer())
                    .option(ChannelOption.SO_BACKLOG, 1024);

            // 绑定端口，同步等待成功
            ChannelFuture future = bootstrap.connect(HOST, port).sync();

            // 等待服务端监听端口关闭
            future.channel().closeFuture().sync();
        } finally {
            clientGroup.shutdownGracefully();
        }
    }

    private class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new ChannelHandler());
        }
    }

    private class ChannelHandler extends ChannelHandlerAdapter {
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            super.exceptionCaught(ctx, cause);
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            super.channelActive(ctx);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            super.channelRead(ctx, msg);
        }
    }


}
