package com.mindasoft._12_design_pattern._03_factory_method;

/**
 * @author: min
 * @date: 2019/4/2 14:44
 * @version: 1.0.0
 */
public class Salesman {

    public Cpu getCpu(String comp){
        if("amd".equals(comp)){
            CpuFactory cpuFactory = new AmdFactory();
            return cpuFactory.produce();
        }else if("intel".equals(comp)){
            CpuFactory cpuFactory2 = new IntelFactory();
            return cpuFactory2.produce();
        }else{
            System.out.println("没有这个公司");
            return null;
        }
    }
}
