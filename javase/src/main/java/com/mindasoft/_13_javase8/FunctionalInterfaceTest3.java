package com.mindasoft._13_javase8;

import java.util.function.Function;

/**
 * 关于多个参数值的使用，无论实在Function接口中，还是在BI类型的接口都提供了类似的操作。
 * （注:java8中，接口的方法是可以有实现的，但需要default关键字修饰，这是其他版本的jdk没有的特性）
 *
 * Compose方法：方法接收一个Function类型的参数，返回一个值。这也是一个标准的Function类型的定义。
 * 在compose方法内部也有一个apply方法。在执行compose方法中的apply方法之前，它先执行了before接口的apply方法，
 * 也是compose方法的输入参数。然后将before方法执行的返回值作为compose中apply方法的输入参数。实际上是形成了一种链式组合。
 *
 * andThen方法：该方法与compose方法很类似。不同之处在于，andThen是先执行自身的apply方法，
 * 将apply的返回值作为after接口的输入值。相对于compose方法，只是方向的不同
 * @author: min
 * @date: 2019/1/17 16:50
 * @version: 1.0.0
 */
public class FunctionalInterfaceTest3 {

    public static void main(String[] args) {

        String str1 = getLength1("hello", value -> "hello的长度："+value, value -> value.length()); //输出:hello的长度：5
        System.out.println(str1);

        Integer result = getLength2("hello", value -> value, value -> value.length()); //输出：5
        System.out.println(result);

    }

    public  static String getLength1(String str1,Function<Integer, String> function1,Function<String,Integer> function2){
        /**
         * 这里一定要注意，function1和function2的参数类型。
         * function2的输出类型与function1的输入类型一定要一致，
         * 否则编译不会通过
         */
        return function1.compose(function2).apply(str1);
    }

    public  static Integer getLength2(String str1, Function<String, String> function1, Function<String,Integer> function2) {
        /**
         * 这里一定要注意，function1和function2的参数类型。
         * function1的输出类型与function2的输入类型一定要一致，(方向相反)
         * 否则编译不会通过
         */
        return function1.andThen(function2).apply(str1);
    }
}
