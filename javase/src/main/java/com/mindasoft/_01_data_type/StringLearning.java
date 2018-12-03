package com.mindasoft._01_data_type;

/**
 * @author: min
 * @date: 2018/11/23 14:20
 * @version: 1.0.0
 */
public class StringLearning {
    public static void main(String[] args) {
        String s1 = "abc";
        String s4 = "abc";
        System.out.println(s1);
        String s2 = new String("abc");
        String s3 = new String("abc");
        System.out.println(s2);

        System.out.println(s2.equals(s3));
        System.out.println(s1.equals(s4));
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1 == s4);
    }
}
