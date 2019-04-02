package com.mindasoft._12_design_pattern._04_abstract_factory;

/**
 * @author: min
 * @date: 2019/4/2 14:31
 * @version: 1.0.0
 */
public class IntelMainboard implements Mainboard {
    /**
     * CPU插槽的孔数
     */
    private int cpuHoles = 0;
    /**
     * 构造方法，传入CPU插槽的孔数
     * @param cpuHoles
     */
    public IntelMainboard(int cpuHoles){
        this.cpuHoles = cpuHoles;
    }
    @Override
    public void installCPU() {
        // TODO Auto-generated method stub
        System.out.println("Intel主板的CPU插槽孔数是：" + cpuHoles);
    }
}
