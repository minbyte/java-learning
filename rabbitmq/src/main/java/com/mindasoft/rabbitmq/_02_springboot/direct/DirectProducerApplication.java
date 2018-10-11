package com.mindasoft.rabbitmq._02_springboot.direct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: min
 * @date: 2018/10/11 12:52
 * @version: 1.0.0
 */
@SpringBootApplication()
public class DirectProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DirectProducerApplication.class, args);
        System.out.println("一共加载了bean个数:" + SpringContextUtils.applicationContext.getBeanDefinitionCount());


        DirectProducer producer = SpringContextUtils.getBean(DirectProducer.class);
        producer.send();

    }

}
