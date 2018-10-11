package com.mindasoft.rabbitmq._01_hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: min
 * @date: 2018/10/10 10:24
 * @version: 1.0.0
 */
public class TopicProducer {

    public static void main(String[] args) throws IOException, TimeoutException {
        //1、建立到代理服务器到连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("test");
        factory.setPassword("test");
        factory.setHost("10.200.12.50");
        Connection conn = factory.newConnection();
        //2、从连接获得信道
        Channel channel = conn.createChannel();
        //3、声明交换器
        String exchangeName = "hello.topic.exchange";
        channel.exchangeDeclare(exchangeName, "topic", true);

        String routingKey = "hello.topic.routingKey";
        //4、发布消息
        byte[] messageBodyBytes = "quit".getBytes();
        channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);

        channel.close();
        conn.close();
    }
}
