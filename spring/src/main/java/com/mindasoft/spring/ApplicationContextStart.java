package com.mindasoft.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: huangmin
 * @email: huangmin@mgtv.com
 * @date: 2018/6/25 17:29
 * @version: 1.0.0
 */
public class ApplicationContextStart {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("");
        System.out.println("一共加载了bean个数:" + context.getBeanDefinitionCount());

        context.getBean("personServier");
    }
}
