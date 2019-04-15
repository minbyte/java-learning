package com.mindasoft._12_design_pattern._08_adapter;

import com.sun.corba.se.spi.oa.ObjectAdapter;

/**
 * @author: min
 * @date: 2019/4/15 11:38
 * @version: 1.0.0
 */
public class ObjectAdapterLearning implements Target
{
    private Adaptee adaptee;
    public ObjectAdapterLearning(Adaptee adaptee)
    {
        this.adaptee=adaptee;
    }
    public void request()
    {
        adaptee.specificRequest();
    }

    public static void main(String[] args)
    {
        System.out.println("对象适配器模式测试：");
        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapterLearning(adaptee);
        target.request();
    }
}