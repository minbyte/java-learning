package com.mindasoft._12_design_pattern._04_abstract_factory;

/**
 * @author: min
 * @date: 2019/4/2 14:32
 * @version: 1.0.0
 */
public class AmdMainboard implements Mainboard {

    /**
     * CPU插槽的孔数
     */
    private int cpuHoles = 0;
    /**
     * 构造方法，传入CPU插槽的孔数
     * @param cpuHoles
     */
    public AmdMainboard(int cpuHoles){
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        // TODO Auto-generated method stub
        System.out.println("AMD主板的CPU插槽孔数是：" + cpuHoles);
    }
}
