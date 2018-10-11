package com.mindasoft.rabbitmq._02_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: min
 * @date: 2018/10/11 10:51
 * @version: 1.0.0
 */
public class SpringConsumerApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-consumer.xml");
        System.out.println("一共加载了bean个数:" + context.getBeanDefinitionCount());
    }
}
