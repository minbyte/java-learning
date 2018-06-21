package com.mindasoft._01_data_type;

import org.junit.Test;

/**
 * Company：MGTV
 * User: huangmin
 * DateTime: 2018/3/29 9:33
 */
public class _05_DataType {

    @Test
    public void test1(){
        Integer a = 1000,b=1000;
        Integer c = 100,d=100;
        System.out.println(a==b);
        System.out.println(c==d);
    }

    @Test
    public void test2(){
        Integer a = new Integer(1000);
        int b = 1000;
        Integer c = new Integer(10);
        Integer d = new Integer(10);
        System.out.println(a == b);
        System.out.println(c == d);
    }

    @Test
    public void test3(){
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
