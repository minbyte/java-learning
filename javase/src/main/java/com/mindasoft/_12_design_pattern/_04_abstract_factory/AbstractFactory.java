package com.mindasoft._12_design_pattern._04_abstract_factory;

/**
 * 抽象工厂模式是一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。
 *
 * 抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品。
 *
 * 使用抽象工厂模式一般要满足以下条件。
 * 系统中有多个产品族，每个具体工厂创建同一族但属于不同等级结构的产品。
 * 系统一次只可能消费其中某一族产品，即同族的产品一起使用。
 *
 * 抽象工厂模式除了具有工厂方法模式的优点外，其他主要优点如下。
 * 可以在类的内部对产品族中相关联的多等级产品共同管理，而不必专门引入多个新的类来进行管理。
 * 当增加一个新的产品族时不需要修改原代码，满足开闭原则。
 *
 * 其缺点是：当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改。
 * @author: min
 * @date: 2019/4/2 14:35
 * @version: 1.0.0
 */
public class AbstractFactory {

    public static void main(String[]args){
        //创建装机工程师对象
        ComputerEngineer cf = new ComputerEngineer();
        //客户选择并创建需要使用的产品对象
        ComputeFactory af = new IntelFactory();
        //告诉装机工程师自己选择的产品，让装机工程师组装电脑
        cf.makeComputer(af);
    }
}
