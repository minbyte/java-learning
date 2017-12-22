package com.mindasoft._08_net._01_io;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * 几个需要注意的地方
 1、UDP套接字和TCP套接字的一个微小但重要的差别：UDP协议保留了消息的边界信息。

 DatagramSocket的每一次receive()调用最多只能接收调用一次send()方法所发送的数据，而且，不同的receive()方法调用绝对不会返回同一个send()方法所发送的额数据。

 当在TCP套接字的输出流上调用write（）方法返回后，所有调用者都知道数据已经被复制到一个传输缓存区中，实际上此时数据可能已经被发送，也有可能还没有被传送，而UDP协议没有提供从网络错误中恢复的机制，因此，并不对可能需要重传的数据进行缓存。这就意味着，当send（）方法调用返回时，消息已经被发送到了底层的传输信道中。


 2、UDP数据报文所能负载的最多数据，亦及一次传送的最大数据为65507个字节

 当消息从网络中到达后，其所包含的数据被TCP的read（）方法或UDP的receive（）方法返回前，数据存储在一个先进先出的接收数据队列中。对于已经建立连接的TCP套接字来说，所有已接受但还未传送的字节都看作是一个连续的字节序列。然而，对于UDP套接字来说，接收到的数据可能来自不同的发送者，一个UDP套接字所接受的数据存放在一个消息队列中，每个消息都关联了其源地址信息，每次receive（）调用只返回一条消息。如果receive（）方法在一个缓存区大小为n的DatagramPacket实例中调用，而接受队里中的第一条消息的长度大于n，则receive（）方法只返回这条消息的钱n个字节，超出部分会被自动放弃，而且对接收程序没有任何消息丢失的提示！

 出于这个原因，接受者应该提供一个有足够大的缓存空间的DatagramPacket实例，以完整地存放调用receive（）方法时应用程序协议所允许的最大长度的消息。一个DatagramPacket实例中所允许传输的最大数据量为65507个字节，也即是UDP数据报文所能负载的最多数据。因此，可以用一个65600字节左右的缓存数组来接受数据。



 3、DatagramPacket的内部消息长度值在接收数据后会发生改变，变为实际接收到的数据的长度值。

 每一个DatagramPacket实例都包含一个内部消息长度值，其初始值为byte缓存数组的长度值，而该实例一旦接受到消息，这个长度值便会变为接收到的消息的实际长度值，这一点可以用DatagramPacket类的getLength（）方法来测试。如果一个应用程序使用同一个DatagramPacket实例多次调用receive（）方法，每次调用前就必须显式地将其内部消息长度重置为缓存区的实际长度，以免接受的数据发生丢失（见上面客户端代码第53行，服务端代码第29行）。

 以上面的程序为例，若在服务端的receiver（）后加入如下代码：System.out.println(dp_receive.getLength());则得到的输出结果为：15，即接收到的字符串数据“Hello UDPserver”的长度。



 4、DatagramPacket的getData（）方法总是返回缓冲区的原始大小，忽略了实际数据的内部偏移量和长度信息。

 由于DatagramPacket的getData（）方法总是返回缓冲数组的原始大小，即刚开始创建缓冲数组时指定的大小，在上面程序中，该长度为1024，因此如果我们要获取接收到的数据，就必须截取getData（）方法返回的数组中只含接收到的数据的那一部分。

 在Java1.6之后，我们可以使用Arrays.copyOfRange（）方法来实现，只需一步便可实现以上功能：

 byte[] destbuf = Arrays.copyOfRange(dp_receive.getData(),dp_receive.getOffset(),

 dp_receive.getOffset() + dp_receive.getLength());

 当然，如果要将接收到的字节数组转换为字符串的话，也可以采用本程序中直接new一个String对象的方法（见上面客户端代码第48行，服务端代码第21行）：

 new String(dp_receive.getData(),dp_receive.getOffset(),

 dp_receive.getOffset() + dp_receive.getLength());
 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/18 9:35
 */
public class UDPServer {

    public static void main(String[] args)throws IOException {
        String str_send = "Hello UDPclient";
        byte[] buf = new byte[1024];
        //服务端在3000端口监听接收到的数据
        DatagramSocket ds = new DatagramSocket(3000);
        //接收从客户端发送过来的数据
        DatagramPacket dp_receive = new DatagramPacket(buf, 1024);
        System.out.println("server is on，waiting for client to send data......");
        boolean f = true;
        while(f){
            //服务器端接收来自客户端的数据
            ds.receive(dp_receive);
            System.out.println("server received data from client：");
            String str_receive = new String(dp_receive.getData(),0,dp_receive.getLength()) +
                    " from " + dp_receive.getAddress().getHostAddress() + ":" + dp_receive.getPort();
            System.out.println(str_receive);
            //数据发动到客户端的3000端口
            DatagramPacket dp_send= new DatagramPacket(str_send.getBytes(),str_send.length(),dp_receive.getAddress(),9000);
            ds.send(dp_send);
            //由于dp_receive在接收了数据之后，其内部消息长度值会变为实际接收的消息的字节数，
            //所以这里要将dp_receive的内部消息长度重新置为1024
            dp_receive.setLength(1024);
        }
        ds.close();
    }
}
