package com.mindasoft._04_objects;

/**
 *
 * 对象初始化顺序： 父类静态代码块-->子类静态代码块-->父类代码块-->父类构造方法 -->子类代码块 -->子类构造方法
 * Company：MGTV
 * User: huangmin
 * DateTime: 2017/12/7 16:27
 */
public class InitOrderLearning extends Parent {

    static String str = "000000000";

    static {
        str = "2222222222";
        System.out.println(str);
    }

    {
        str = "3333555555533";
        System.out.println(str);
    }

    public InitOrderLearning(){
        str = "6666666";
        System.out.println(str);
    }

    public static void hello(){
        str = "33333333";
        System.out.println(str);
    }

    public static void main(String[] args) {
        new InitOrderLearning();
    }
}

class Parent{
    static String str="000000000";

    static{
        str = "Parent1111111111";
        System.out.println(str);
    }

    {
        str = "Parent333333";
        System.out.println(str);
    }

    public Parent(){
        str = "Parent4444444";
        System.out.println(str);
    }
}
