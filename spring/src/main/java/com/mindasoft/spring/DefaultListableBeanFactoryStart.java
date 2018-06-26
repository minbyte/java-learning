package com.mindasoft.spring;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @author: huangmin
 * @email: huangmin@mgtv.com
 * @date: 2018/6/25 17:31
 * @version: 1.0.0
 */
public class DefaultListableBeanFactoryStart {

    public static void main(String[] args) {
        // 1、指定 bean 定义的xml
        ClassPathResource resouce = new ClassPathResource("xml file");

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(resouce);

        factory.getBean("");
    }
}
