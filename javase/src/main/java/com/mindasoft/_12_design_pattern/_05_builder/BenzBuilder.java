package com.mindasoft._12_design_pattern._05_builder;

import java.util.ArrayList;

/**
 * @author: min
 * @date: 2019/4/2 15:50
 * @version: 1.0.0
 */
public class BenzBuilder extends CarBuilder {

    private BenzModel benz = new BenzModel();

    public CarModel getCarModel() {
        return this.benz;
    }

    public void setSequence(ArrayList<String> sequence) {

        this.benz.setSequence(sequence);

    }

}