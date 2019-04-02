package com.mindasoft._12_design_pattern._03_factory_method;

/**
 * 定义一个创建产品对象的工厂接口，将产品对象的实际创建工作推迟到具体子工厂类当中。这满足创建型模式中所要求的“创建与使用相分离”的特点。
 *
 * 工厂方法模式的主要优点有：
 * 用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程；
 * 在系统增加新的产品时只需要添加具体产品类和对应的具体工厂类，无须对原工厂进行任何修改，满足开闭原则；
 *
 * 其缺点是：每增加一个产品就要增加一个具体产品类和一个对应的具体工厂类，这增加了系统的复杂度。
 *
 * 如果要创建的产品不多，只要一个工厂类就可以完成，这种模式叫“简单工厂模式”
 *
 * @author: min
 * @date: 2019/4/2 14:23
 * @version: 1.0.0
 */
public class FactoryMethod {

    public static void main(String[] args) {
        // 创建一个售货员
        Salesman salesman = new Salesman();
        // 客户告诉售货员要amd的产品,售货员去ADM工厂生产拿货给客户。
        salesman.getCpu("amd").calculate();
    }
}
