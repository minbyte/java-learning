package com.mindasoft._12_design_pattern._03_factory_method;

/**
 * @author: min
 * @date: 2019/4/2 14:18
 * @version: 1.0.0
 */
public class AmdCpu implements Cpu {
    /**
     * CPU的针脚数
     */
    private int pins = 0;
    public  AmdCpu(int pins){
        this.pins = pins;
    }
    @Override
    public void calculate() {
        // TODO Auto-generated method stub
        System.out.println("AMD CPU的针脚数：" + pins);
    }
}
