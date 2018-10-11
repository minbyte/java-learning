package com.mindasoft.rabbitmq._02_springboot.topic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: min
 * @date: 2018/10/11 13:44
 * @version: 1.0.0
 */
@Configuration
public class TopicRabbitConfig {

    /**
     * 队列
     * @return
     */
    @Bean
    public Queue helloQueue() {
        return new Queue("hello.topic.queue");
    }

    /**
     * 交换器
     * @return
     */
    @Bean
    TopicExchange helloExchange() {
        return new TopicExchange("hello.topic.exchange");
    }

    /**
     * 绑定
     * @param helloQueue
     * @param helloExchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue helloQueue, TopicExchange helloExchange) {
        return BindingBuilder.bind(helloQueue).to(helloExchange).with("hello.routing.key");
    }

}
