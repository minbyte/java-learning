package com.mindasoft.rabbitmq._02_springboot.direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: min
 * @date: 2018/10/11 13:44
 * @version: 1.0.0
 */
@Configuration
public class DirectRabbitConfig {

    /**
     * 队列
     * @return
     */
    @Bean
    public Queue helloQueue() {
        return new Queue("hello.queue");
    }

    /**
     * 交换器
     * @return
     */
    @Bean
    DirectExchange helloExchange() {
        return new DirectExchange("hello.direct.exchange");
    }

    /**
     * 绑定
     * @param helloQueue
     * @param helloExchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue helloQueue, DirectExchange helloExchange) {
        return BindingBuilder.bind(helloQueue).to(helloExchange).with("hello.routing.key");
    }

}
