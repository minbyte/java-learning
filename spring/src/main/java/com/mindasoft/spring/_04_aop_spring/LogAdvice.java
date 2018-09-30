package com.mindasoft.spring._04_aop_spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author: min
 * @date: 2018/9/30 11:40
 * @version: 1.0.0
 */
public class LogAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("== 开始执行操作 ==");
        Object result = methodInvocation.proceed(); // 执行原方法
        System.out.println("== 操作执行完毕 ==");
        return result;
    }
}
