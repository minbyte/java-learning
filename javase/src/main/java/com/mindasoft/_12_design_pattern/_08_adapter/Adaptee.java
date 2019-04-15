package com.mindasoft._12_design_pattern._08_adapter;

/**
 * //适配者接口
 * @author: min
 * @date: 2019/4/15 11:36
 * @version: 1.0.0
 */
public class Adaptee {

    public void specificRequest()
    {
        System.out.println("适配者中的业务代码被调用！");
    }
}
