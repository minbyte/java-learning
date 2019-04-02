package com.mindasoft._12_design_pattern._07_proxy;

/**
 * 追求者
 * @author: min
 * @date: 2019/4/2 16:35
 * @version: 1.0.0
 */
public class Pursuit implements GiveGift{

    Girl girl;

    public Pursuit(Girl girl) {
        this.girl = girl;
    }

    @Override
    public void giveDoll() {
        System.out.println("送娃娃");
    }

    @Override
    public void giveFlowers() {
        System.out.println("送花");
    }
}
