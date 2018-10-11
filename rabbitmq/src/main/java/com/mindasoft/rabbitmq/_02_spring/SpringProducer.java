package com.mindasoft.rabbitmq._02_spring;

import org.springframework.amqp.core.AmqpTemplate;

/**
 * @author: min
 * @date: 2018/10/11 10:53
 * @version: 1.0.0
 */
public class SpringProducer{

    private AmqpTemplate amqpTemplate;

    public void send(){
        amqpTemplate.convertAndSend("hello.direct.exchange", "hello.routing.key", "hello world");
    }

    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }
}
