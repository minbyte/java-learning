package com.mindasoft.spring._04_aop_spring;

/**
 * @author: min
 * @date: 2018/9/30 10:51
 * @version: 1.0.0
 */
public class BusinessServiceImpl  implements BusinessService {
    @Override
    public String getName(Integer id) {
        // TODO Auto-generated method stub
        System.out.println("我是save()方法");
        return "myname";
    }
    @Override
    public void save(String name) {
        // TODO Auto-generated method stub
        System.out.println("我是save()方法");
    }
    @Override
    public void update(String name, Integer id) {
        // TODO Auto-generated method stub
        System.out.println("我是update()方法");
    }

}