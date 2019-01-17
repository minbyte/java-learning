package com.mindasoft._13_javase8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 常用的函数式接口主要有四种类型，是通过其输入和输出的参数来进行区分的。定义了编码过程中主要的使用场景。
 * @author: min
 * @date: 2019/1/17 16:03
 * @version: 1.0.0
 */
public class FunctionalInterfaceMain {

    public static void main(String[] args) {
        /**
         * Function<T,R>  接收一个T类型的参数，返回一个R类型的结果
         */
        Function<String,String> function1 = item -> item +"返回值";
        System.out.println(function1.apply("11"));

        /**
         * Predicate<T>接收一个T类型的参数，返回一个boolean类型的结果
         */
        Predicate<String> function3 = iterm -> "".equals(iterm);

        /**
         * Consumer<T>接收一个T类型的参数，不返回值
         */
        Consumer<String> function2 = iterm -> {System.out.println(iterm);};//lambda语句，使用大括号，没有return关键字，表示没有返回值

        /**
         * Supplier<T>不接受参数，返回一个T类型的结果
         */
        Supplier<String> function4 = () -> new String("");


        /**
         * 再看看怎么使用
         * demo释义：
         * 1、创建一个String类型的集合
         * 2、将集合中的所有元素的末尾追加字符串'1'
         * 3、选出长度大于2的字符串
         * 4、遍历输出所有元素
         */
        List<String> list = Arrays.asList("zhangsan","lisi","wangwu","xiaoming","zhaoliu");

        list.stream()
                .map(value -> value + "1") //传入的是一个Function函数式接口
                .filter(value -> value.length() > 2) //传入的是一个Predicate函数式接口
                .forEach(value -> System.out.println(value)); //传入的是一个Consumer函数式接口
    }
}
