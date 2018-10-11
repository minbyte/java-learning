package com.mindasoft.rabbitmq._02_spring;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author: min
 * @date: 2018/10/11 10:50
 * @version: 1.0.0
 */
public class SpringConsumer implements MessageListener {
    static {
        System.out.println("#########在监听中了");
    }

    @Override
    public void onMessage(Message message) {
        String msg = new String (message.getBody());
        System.out.println("消费掉了:"+msg+"------->>>>>");
    }
}
