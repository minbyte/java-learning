package com.mindasoft._01_data_type;

import org.junit.Test;

/**
 * String StringBuffer StringBuilder
 * Created by huangmin on 2017/9/19 22:13.
 */
public class _04_StringStart {

    @Test
    public void string01(){
        String s1 = "aaa";
        String s2 = "aaa";
        System.out.println(s1.equals(s2));  // true
        System.out.println(s1 == s2); // true

        String s3 = new String("aaa");
        String s4 = new String("aaa");
        System.out.println(s3.equals(s4)); // true
        System.out.println(s3 == s4 );  // false

    }
}
