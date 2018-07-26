package com.mindasoft.spring._01_bean_factory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * 在Spring当中有几个主要的类。
 * Bean最基本的容器
 * @see org.springframework.beans.factory.BeanFactory
 * Resource 描述需要加载的Bean
 * @see org.springframework.core.io.Resource
 * BeanDefinition 定义Bean的基本数据结构
 * @see org.springframework.beans.factory.config.BeanDefinition
 * 从Resource 中读取定义的bean，并解析为BeanDefinition,主要的方法loadBeanDefinitions
 * @see org.springframework.beans.factory.support.BeanDefinitionReader
 *
 * @author: huangmin
 * @email: huangmin@mgtv.com
 * @date: 2018/6/25 17:31
 * @version: 1.0.0
 */
public class DefaultListableBeanFactoryStart {

    public static void main(String[] args) {
        // 1、指定 bean 定义的xml Resource
        ClassPathResource resouce = new ClassPathResource("xml file");

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(resouce);

        factory.getBean("");
    }
}
