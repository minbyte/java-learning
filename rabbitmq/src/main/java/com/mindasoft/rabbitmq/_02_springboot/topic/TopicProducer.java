package com.mindasoft.rabbitmq._02_springboot.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: min
 * @date: 2018/10/11 13:58
 * @version: 1.0.0
 */
@Component
public class TopicProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        this.rabbitTemplate.convertAndSend("hello.topic.exchange", "hello.routing.key", "hello world");
    }

}
