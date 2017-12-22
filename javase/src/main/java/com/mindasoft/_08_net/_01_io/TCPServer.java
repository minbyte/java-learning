package com.mindasoft._08_net._01_io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 *
 * TCP的Java支持
 * 协议相当于相互通信的程序间达成的一种约定，它规定了分组报文的结构、交换方式、包含的意义以及怎样对报文所包含的信息进行解析，
 * TCP/IP协议族有IP协议、TCP协议和UDP协议。现在TCP/IP协议族中的主要socket类型为流套接字（使用TCP协议）和数据报套接字（使用UDP协议）。
 *
 * TCP协议提供面向连接的服务，通过它建立的是可靠地连接。Java为TCP协议提供了两个类：Socket类和ServerSocket类。
 * 一个Socket实例代表了TCP连接的一个客户端，而一个ServerSocket实例代表了TCP连接的一个服务器端，一般在TCP Socket编程中，
 * 客户端有多个，而服务器端只有一个，客户端TCP向服务器端TCP发送连接请求，服务器端的ServerSocket实例则监听来自客户端的TCP连接请求，
 * 并为每个请求创建新的Socket实例，由于服务端在调用accept（）等待客户端的连接请求时会阻塞，直到收到客户端发送的连接请求才会继续往下执行代码，
 * 因此要为每个Socket连接开启一个线程。服务器端要同时处理ServerSocket实例和Socket实例，而客户端只需要使用Socket实例。
 * 另外，每个Socket实例会关联一个InputStream和OutputStream对象，我们通过将字节写入套接字的OutputStream来发送数据，并通过从InputStream来接收数据。
 *
 * 服务端的工作是建立一个通信终端，并被动地等待客户端的连接。典型的TCP服务端执行如下两步操作：
 *
 * 1、创建一个ServerSocket实例并指定本地端口，用来监听客户端在该端口发送的TCP连接请求；
 * 2、重复执行：
 * 1）调用ServerSocket的accept（）方法以获取客户端连接，并通过其返回值创建一个Socket实例；
 * 2）为返回的Socket实例开启新的线程，并使用返回的Socket实例的I/O流与客户端通信；
 * 3）通信完成后，使用Socket类的close（）方法关闭该客户端的套接字连接。
 *
 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/18 9:35
 */
public class TCPServer {

    public static void main(String[] args) throws Exception{
        //服务端在20006端口监听客户端请求的TCP连接
        ServerSocket server = new ServerSocket(20006);
        Socket client = null;
        boolean f = true;
        while(f){
            //等待客户端的连接，如果没有获取连接
            client = server.accept();
            System.out.println("与客户端连接成功！");
            //为每个客户端连接开启一个线程
            new Thread(new ServerThread(client)).start();
        }
        server.close();
    }
}


class ServerThread implements Runnable {

    private Socket client = null;
    public ServerThread(Socket client){
        this.client = client;
    }

    @Override
    public void run() {
        try{
            //获取Socket的输出流，用来向客户端发送数据
            PrintStream out = new PrintStream(client.getOutputStream());
            //获取Socket的输入流，用来接收从客户端发送过来的数据
            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag =true;
            while(flag){
                //接收从客户端发送过来的数据
                String str =  buf.readLine();
                if(str == null || "".equals(str)){
                    flag = false;
                }else{
                    if("bye".equals(str)){
                        flag = false;
                    }else{
                        //将接收到的字符串前面加上echo，发送到对应的客户端
                        out.println("echo:" + str);
                    }
                }
            }
            out.close();
            client.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}