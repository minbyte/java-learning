package com.mindasoft.rabbitmq._02_springboot.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author: min
 * @date: 2018/10/11 13:59
 * @version: 1.0.0
 */
@Component
@RabbitListener(queues = "hello.topic.queue")
public class TopicConsumer {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }

}