package com.mindasoft._12_design_pattern._05_builder;

import java.util.ArrayList;

/**
 * @author: min
 * @date: 2019/4/2 15:50
 * @version: 1.0.0
 */
public class BMWBuilder extends CarBuilder {

    private BMWModel bmw = new BMWModel();

    public CarModel getCarModel() {

        return this.bmw;

    }

    public void setSequence(ArrayList<String> sequence) {

        this.bmw.setSequence(sequence);

    }

}