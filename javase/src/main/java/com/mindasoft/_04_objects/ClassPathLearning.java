package com.mindasoft._04_objects;

import org.junit.Test;

import java.net.URISyntaxException;

/**
 * Created by huangmin on 2017/9/21 15:30.
 */
public class ClassPathLearning {

    @Test
    public void t1(){

        System.out.println(ClassPathLearning.class.getResource(""));
        System.out.println(ClassPathLearning.class.getResource("/"));
        try {
            System.out.println(Thread.currentThread().getContextClassLoader().getResource("").toURI().toString()); //获取根目录 推荐使用
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
