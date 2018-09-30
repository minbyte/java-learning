package com.mindasoft.spring._04_aop_spring;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * @author: min
 * @date: 2018/9/30 11:39
 * @version: 1.0.0
 */
public class AopSpringLearning {

    public static void main(String[] args) {
        BusinessService businessService = new BusinessServiceImpl();
        // ===================================================
        // 1，声明“切入点”，表示要拦截哪些方法
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("save*");
        pointcut.addMethodName("delete*");
        // 2，声明一个“通知”，表示拦截到之后要做什么事
        LogAdvice logAdvice = new LogAdvice();
        // 3，组装为一个切面（切面=切入点+通知）
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, logAdvice);
        // 4，为原对象生成一个代理对象
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor); // 添加一个切面
        proxyFactory.setTarget(businessService); // 指定目标对象
        businessService = (BusinessService) proxyFactory.getProxy(); // 获取代理对象
        // ===================================================
        // 使用的是代理对象
        businessService.save("min");
        System.out.println();
        businessService.update("min",12);
        System.out.println();
        businessService.getName(12);
        System.out.println();

    }
}
