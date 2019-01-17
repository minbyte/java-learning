package com.mindasoft._13_javase8;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

/**
 * 在实际使用中，我们往往会输入多个参数，而不是一个参数。针对于多个参数的计算，最终都可以拆分两个参数的运算，然后将两个参数的运算结合起来。
 * 如：1+2+3+4 = 10，可以拆分为1+2 = 3,   3+3=6;   6+4 = 10 三个步骤完成(在java中，是不允许一次返回多个值的)。
 * 因此对于多个参数的操作也是如此。Java8中对于接收两个参数的场景提供了相关的函数式接口。如下：
 * @author: min
 * @date: 2019/1/17 16:16
 * @version: 1.0.0
 */
public class FunctionalInterfaceTest2 {

    public static void main(String[] args) {

        /**
         * Bi类型的接口创建
         */
        /**
         * BiFunction<T, U, R>   接收T类型和U类型的两个参数，返回一个R类型的结果
         */
        BiFunction<String, String, Integer> biFunction = (str1, str2) -> str1.length()+str2.length();

        /**
         * BiConsumer<T , U> 接收T类型和U类型的两个参数，不返回值
         */
        BiConsumer<String, String> biConsumer = (str1, str2) -> System.out.println(str1+str2);

        /**
         * BiPredicate<T, U> 接收T类型和U类型的两个参数，返回一个boolean类型的结果
         */
        BiPredicate<String, String> biPredicate = (str1, str2) -> str1.length() > str2.length();


        /**
         * Bi类型的接口使用
         */
        int length = getLength("hello", "world", (str1,str2) -> str1.length() + str2.length()); //输出10
        boolean boolean1 = getBoolean("hello", "world", (str1,str2) -> str1.length() > str2.length()); //输出false

        System.out.println(length);
        System.out.println(boolean1);

        noResult("hello", "world", (str1,str2) -> System.out.println(str1+" "+str2)); //没有输出


    }

    public  static int getLength(String str1,String str2,BiFunction<String, String, Integer> function){
        return function.apply(str1, str2);
    }

    public static void noResult(String str1,String str2,BiConsumer<String, String> biConcumer){
        biConcumer.accept(str1, str2);
    }

    public static boolean getBoolean(String str1,String str2,BiPredicate<String, String> biPredicate){
        return biPredicate.test(str1, str2);
    }
}
