package com.mindasoft.rabbitmq._01_hello;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: min
 * @date: 2018/10/10 10:26
 * @version: 1.0.0
 */
public class TopicConsumer1 {

    public static void main(String[] args) throws IOException, TimeoutException {
        //1、建立到代理服务器到连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("test");
        factory.setPassword("test");
        factory.setHost("10.200.12.50");
        Connection conn = factory.newConnection();
        //2、从连接获得信道
        final Channel channel = conn.createChannel();
        //3、声明交换器
        String exchangeName = "hello.topic.exchange";
        channel.exchangeDeclare(exchangeName, "topic", true);
        //4、声明队列
        String queueName = channel.queueDeclare().getQueue();
        String routingKey = "hello.#";
        //5、绑定队列，通过键 routingKey 将队列和交换器绑定起来
        channel.queueBind(queueName, exchangeName, routingKey);

        while(true) {
            //6、消费消息
            boolean autoAck = false;
            String consumerTag = "";
            channel.basicConsume(queueName, autoAck, consumerTag, new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag,
                                           Envelope envelope,
                                           AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {
                    String routingKey = envelope.getRoutingKey();
                    String contentType = properties.getContentType();
                    System.out.println("TopicConsumer1消费的路由键：" + routingKey);
                    System.out.println("TopicConsumer1消费的内容类型：" + contentType);
                    long deliveryTag = envelope.getDeliveryTag();
                    //确认消息
                    channel.basicAck(deliveryTag, false);
                    System.out.println("TopicConsumer1消费的消息体内容：");
                    String bodyStr = new String(body, "UTF-8");
                    System.out.println(bodyStr);

                }
            });
        }
    }
}
