package com.mindasoft.spring._04_aop_spring;

/**
 * @author: min
 * @date: 2018/9/30 10:50
 * @version: 1.0.0
 */
public interface BusinessService {

    public void save(String name);

    public void update(String name, Integer id);

    public String getName(Integer id);
}
