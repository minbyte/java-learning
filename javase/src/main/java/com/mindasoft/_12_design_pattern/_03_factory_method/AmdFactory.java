package com.mindasoft._12_design_pattern._03_factory_method;

/**
 * @author: min
 * @date: 2019/4/2 14:22
 * @version: 1.0.0
 */
public class AmdFactory implements CpuFactory {
    @Override
    public Cpu produce() {
        return new AmdCpu(938);
    }
}
