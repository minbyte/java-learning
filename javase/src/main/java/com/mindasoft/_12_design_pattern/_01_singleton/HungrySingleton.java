package com.mindasoft._12_design_pattern._01_singleton;

/**
 * 饿汉式单例 的特点是类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了。
 *
 * 饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以是线程安全的，可以直接用于多线程而不会出现问题。
 *
 * @author: min
 * @date: 2019/4/2 13:03
 * @version: 1.0.0
 */
public class HungrySingleton {

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
