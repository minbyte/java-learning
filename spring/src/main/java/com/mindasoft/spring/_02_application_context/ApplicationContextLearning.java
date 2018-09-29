package com.mindasoft.spring._02_application_context;

import com.mindasoft.spring.LearningBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: min
 * @date: 2018/9/29 16:02
 * @version: 1.0.0
 */
public class ApplicationContextLearning {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("一共加载了bean个数:" + context.getBeanDefinitionCount());

        LearningBean bean = (LearningBean) context.getBean("mybean");
        System.out.println(bean.getName());
    }
}
