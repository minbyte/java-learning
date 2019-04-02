package com.mindasoft._12_design_pattern._07_proxy;

/**
 * @author: min
 * @date: 2019/4/2 16:36
 * @version: 1.0.0
 */
public class ProxyLearning {

    public static void main(String[] args) {
        Girl girl = new Girl("丽丽");
        Courier courier = new Courier(girl);

        courier.giveDoll();
        courier.giveFlowers();


    }
}
