package com.mindasoft._08_net._02_nio;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/23 15:01
 */
public class NIOClient {

    public static int PORT_NUMBER = 1234;

    public static void main(String[] argv) throws Exception {
        new NIOClient().go(argv);
    }

    public void go(String[] argv) throws Exception {
        int port = PORT_NUMBER;
        if (argv.length > 0) { // 覆盖默认的监听端口
            port = Integer.parseInt(argv[0]);
        }
        System.out.println("Listening on port " + port);

        // 1、打开Channel 并设置为非阻塞形式
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        // 2、TCP参数
        Socket socket = socketChannel.socket();
        socket.setSendBufferSize(1024);
        socket.setReceiveBufferSize(1024);

        // 3、链接服务器
        boolean connected = socketChannel.connect( new InetSocketAddress(port));

        // 4、创建一个多路复用器Selector供下面使用
        Selector selector = Selector.open();
        if(connected){
            socketChannel.register(selector, SelectionKey.OP_READ);
            doWriter(socketChannel);
        }else {
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    private ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

    private void doWriter(SocketChannel socketChannel) throws Exception{
        buffer.clear();
        buffer.put("Hi there Client!\r\n".getBytes());
        buffer.flip();
        socketChannel.write(buffer);
    }
}
