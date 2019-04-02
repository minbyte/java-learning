package com.mindasoft._12_design_pattern._02_sample_factory;

/**
 * 建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
 * 简单工厂模式的实质是由一个工厂类根据传入的参数，动态决定应该创建哪一个产品类（这些产品类继承自一个父类或接口）的实例。
 *
 * 简单工厂模式它不属于 GoF 的 23 种经典设计模式，它的缺点是增加新产品时会违背“开闭原则”。
 *
 * @author: min
 * @date: 2019/4/2 14:12
 * @version: 1.0.0
 */
public class SampleFactory {

    public static Human makeHuman(String type){
        if(type.equals("man")){
            Human man = new Man();
            return man;
        }else if(type.equals("womman")){
            Human woman = new Woman();
            return woman;
        }else{
            System.out.println("生产不出来");
            return null;
        }
    }
}