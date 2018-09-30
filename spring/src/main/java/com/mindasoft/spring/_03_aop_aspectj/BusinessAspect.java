package com.mindasoft.spring._03_aop_aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author: min
 * @date: 2018/9/30 10:52
 * @version: 1.0.0
 */
@Aspect
public class BusinessAspect {


    //第一个* 说明方法的类型<br>
    // 第二个* 说明包下的所有的类  如果是包下类和自包中的类* com.cn..*.save*(..))<br>
    // (..)方法中的参数<br>
    @Pointcut("execution(* com.mindasoft.spring._03_AOP.*.save*(..))")
    private void anyMethod() {

    }
    // 定义一个切入点
    @Pointcut("execution(* com.mindasoft.spring._03_AOP.*.update*(..))")
    private void doMethod() {

    }

    /*
     *   Advice 包括 Before Around AfterReturning After AfterThrowing 等
     *
     * */

    @Before("anyMethod()&&args(name)")
    public void doAccessCheck(String name) {
        System.out.println(name);
        System.out.println("前置通知");
    }

    @AfterReturning("anyMethod()")
    public void doAfter() {
        System.out.println("后置通知");
    }

    @After("anyMethod()")
    public void after() {
        System.out.println("最终通知");
    }

    @AfterThrowing("anyMethod()")
    public void doAfterThrow() {
        System.out.println("例外通知");
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入环绕通知");
        Object object = pjp.proceed();// 执行该方法
        System.out.println("退出方法");
        return object;
    }

    @Around("doMethod()")
    public Object doBasic(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入环绕通知...");
        Object object = pjp.proceed();// 执行该方法
        System.out.println("退出方法...");
        return object;
    }
}
