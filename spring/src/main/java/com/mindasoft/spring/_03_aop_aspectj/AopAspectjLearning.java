package com.mindasoft.spring._03_aop_aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: min
 * @date: 2018/9/29 16:15
 * @version: 1.0.0
 */
public class AopAspectjLearning {

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("AopAspect.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("AopAspectXML.xml");
        System.out.println("一共加载了bean个数:" + context.getBeanDefinitionCount());

        BusinessService service = (BusinessService) context.getBean("businessService");
        service.save("min");
        service.update("min1", 22);
    }
}
