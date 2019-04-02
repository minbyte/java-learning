package com.mindasoft._12_design_pattern._04_abstract_factory;

/**
 * @author: min
 * @date: 2019/4/2 14:29
 * @version: 1.0.0
 */
public interface ComputeFactory {

    /**
     * 创建CPU对象
     * @return CPU对象
     */
    public Cpu createCpu();
    /**
     * 创建主板对象
     * @return 主板对象
     */
    public Mainboard createMainboard();
}
