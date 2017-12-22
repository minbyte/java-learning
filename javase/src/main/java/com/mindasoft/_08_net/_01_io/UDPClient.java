package com.mindasoft._08_net._01_io;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * UDP的通信建立的步骤
 UDP客户端首先向被动等待联系的服务器发送一个数据报文。一个典型的UDP客户端要经过下面三步操作：

 1、创建一个DatagramSocket实例，可以有选择地对本地地址和端口号进行设置，如果设置了端口号，则客户端会在该端口号上监听从服务器端发送来的数据；

 2、使用DatagramSocket实例的send（）和receive（）方法来发送和接收DatagramPacket实例，进行通信；

 3、通信完成后，调用DatagramSocket实例的close（）方法来关闭该套接字。



 由于UDP是无连接的，因此UDP服务端不需要等待客户端的请求以建立连接。另外，UDP服务器为所有通信使用同一套接字，这点与TCP服务器不同，TCP服务器则为每个成功返回的accept()方法创建一个新的套接字。一个典型的UDP服务端要经过下面三步操作：

 1、创建一个DatagramSocket实例，指定本地端口号，并可以有选择地指定本地地址，此时，服务器已经准备好从任何客户端接收数据报文；

 2、使用DatagramSocket实例的receive（）方法接收一个DatagramPacket实例，当receive（）方法返回时，数据报文就包含了客户端的地址，这样就知道了回复信息应该发送到什么地方；

 3、使用DatagramSocket实例的send（）方法向服务器端返回DatagramPacket实例。

 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/18 9:36
 */
public class UDPClient {

    private static final int TIMEOUT = 5000;  //设置接收数据的超时时间
    private static final int MAXNUM = 5;      //设置重发数据的最多次数
    public static void main(String args[])throws IOException {
        String str_send = "Hello UDPserver";
        byte[] buf = new byte[1024];
        //客户端在9000端口监听接收到的数据
        DatagramSocket ds = new DatagramSocket(9000);
        InetAddress loc = InetAddress.getLocalHost();
        //定义用来发送数据的DatagramPacket实例
        DatagramPacket dp_send= new DatagramPacket(str_send.getBytes(),str_send.length(),loc,3000);
        //定义用来接收数据的DatagramPacket实例
        DatagramPacket dp_receive = new DatagramPacket(buf, 1024);
        //数据发向本地3000端口
        ds.setSoTimeout(TIMEOUT);              //设置接收数据时阻塞的最长时间
        int tries = 0;                         //重发数据的次数
        boolean receivedResponse = false;     //是否接收到数据的标志位
        //直到接收到数据，或者重发次数达到预定值，则退出循环
        while(!receivedResponse && tries<MAXNUM){
            //发送数据
            ds.send(dp_send);
            try{
                //接收从服务端发送回来的数据
                ds.receive(dp_receive);
                //如果接收到的数据不是来自目标地址，则抛出异常
                if(!dp_receive.getAddress().equals(loc)){
                    throw new IOException("Received packet from an umknown source");
                }
                //如果接收到数据。则将receivedResponse标志位改为true，从而退出循环
                receivedResponse = true;
            }catch(InterruptedIOException e){
                //如果接收数据时阻塞超时，重发并减少一次重发的次数
                tries += 1;
                System.out.println("Time out," + (MAXNUM - tries) + " more tries..." );
            }
        }
        if(receivedResponse){
            //如果收到数据，则打印出来
            System.out.println("client received data from server：");
            String str_receive = new String(dp_receive.getData(),0,dp_receive.getLength()) +
                    " from " + dp_receive.getAddress().getHostAddress() + ":" + dp_receive.getPort();
            System.out.println(str_receive);
            //由于dp_receive在接收了数据之后，其内部消息长度值会变为实际接收的消息的字节数，
            //所以这里要将dp_receive的内部消息长度重新置为1024
            dp_receive.setLength(1024);
        }else{
            //如果重发MAXNUM次数据后，仍未获得服务器发送回来的数据，则打印如下信息
            System.out.println("No response -- give up.");
        }
        ds.close();
    }
}
