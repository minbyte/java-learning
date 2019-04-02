package com.mindasoft._12_design_pattern._05_builder;

/**
 * @author: min
 * @date: 2019/4/2 15:49
 * @version: 1.0.0
 */
public class BMWModel extends CarModel {

    protected void alarm() {

        System.out.println("宝马车的喇叭声音是这个样子的...");

    }

    protected void engineBoom() {

        System.out.println("宝马车的引擎室这个声音的...");

    }

    protected void start() {

        System.out.println("宝马车跑起来是这个样子的...");

    }

    protected void stop() {

        System.out.println("宝马车应该这样停车...");

    }

}
