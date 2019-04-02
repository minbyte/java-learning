package com.mindasoft._12_design_pattern._07_proxy;

/**
 * 女孩
 * @author: min
 * @date: 2019/4/2 16:30
 * @version: 1.0.0
 */
public class Girl {
    private String name;

    public Girl(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
