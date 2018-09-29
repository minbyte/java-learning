package com.mindasoft.spring._01_bean_factory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 在Spring当中有几个主要的类。
 * Bean最基本的容器接口
 * @see org.springframework.beans.factory.BeanFactory
 * @see org.springframework.beans.factory.support.DefaultListableBeanFactory
 *
 * Resource 描述需要加载Bean的资源描述文件
 * @see org.springframework.core.io.Resource
 * @see org.springframework.core.io.ClassPathResource
 * @see org.springframework.core.io.FileSystemResource
 *
 * XML文件加载器，从Resource中加载指定的文件，解析成Document
 * @see org.springframework.beans.factory.xml.DocumentLoader
 * @see org.springframework.beans.factory.xml.DefaultDocumentLoader
 *
 * 由DocumentLoader得到的Document中解析为 BeanDefinition,
 * 并通过DefaultBeanDefinitionDocumentReader注册为Bean，registerBeanDefinitions
 * @see org.springframework.beans.factory.support.BeanDefinitionReader
 * @see org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader
 * BeanDefinition的解析代理类，用于解析Element，得到BeanDefinitionHolder
 * @see org.springframework.beans.factory.xml.BeanDefinitionParserDelegate
 *
 * XmlReaderContext
 * BeanDefinitionRegistry
 *
 * BeanDefinition 定义Bean的基本数据结构
 * @see org.springframework.beans.factory.config.BeanDefinition
 *
 *
 *
 *
 * @author: huangmin
 * @email: huangmin@mgtv.com
 * @date: 2018/6/25 17:31
 * @version: 1.0.0
 */
public class DefaultListableBeanFactoryStart {

    public static void main(String[] args) {
        // 1、指定 bean 定义的xml Resource
        Resource resouce = new ClassPathResource("xml file");

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        // 载入和注册
        reader.loadBeanDefinitions(resouce);

        factory.getBean("");
    }
}
