package com.mindasoft._12_design_pattern._02_sample_factory;

/**
 * @author: min
 * @date: 2019/4/2 14:12
 * @version: 1.0.0
 */
public class God {

    public static Human makeHuman(String type){
        if(type.equals("man")){
            Human man = new Man();
            return man;
        }else if(type.equals("womman")){
            Human woman = new Woman();
            return woman;
        }else{
            System.out.println("生产不出来");
            return null;
        }
    }
}