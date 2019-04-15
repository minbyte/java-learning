package com.mindasoft._12_design_pattern._08_adapter;

/**
 * @author: min
 * @date: 2019/4/15 11:38
 * @version: 1.0.0
 */
public class ClassAdapterLearning extends Adaptee implements Target
{
    public void request()
    {
        specificRequest();
    }

    public static void main(String[] args)
    {
        System.out.println("类适配器模式测试：");
        Target target = new ClassAdapterLearning();
        target.request();
    }
}