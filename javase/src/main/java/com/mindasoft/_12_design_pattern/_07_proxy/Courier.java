package com.mindasoft._12_design_pattern._07_proxy;

/**
 * 快递员，代理者
 * @author: min
 * @date: 2019/4/2 16:33
 * @version: 1.0.0
 */
public class Courier implements GiveGift {

    Pursuit pursuit;

    public Courier(Girl girl) {
        this.pursuit = new Pursuit(girl);
    }

    @Override
    public void giveDoll() {
        System.out.println("买到娃娃了，送娃娃去咯");
        pursuit.giveDoll();
    }

    @Override
    public void giveFlowers() {
        System.out.println("买到花了，送花去咯");
        pursuit.giveFlowers();
    }
}
