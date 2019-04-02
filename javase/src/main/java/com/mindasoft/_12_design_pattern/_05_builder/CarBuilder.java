package com.mindasoft._12_design_pattern._05_builder;

import java.util.ArrayList;

/**
 * @author: min
 * @date: 2019/4/2 15:50
 * @version: 1.0.0
 */
public abstract class CarBuilder {

    //建造一个模型，你要给我一个顺序要，就是组装顺序
    public abstract void setSequence(ArrayList<String> sequence);

    //设置完毕顺序后，就可以直接拿到这个车辆模型
    public abstract CarModel getCarModel();

}
