package com.flightnation.flightnation.model;

import com.flightnation.flightnation.entity.BaggageAndCargoAbs;


public class Cargo extends BaggageAndCargoAbs {

    public Cargo(Integer id, Integer weight, WeightUnit weightUnit, Integer pieces) {
        super(id, weight, weightUnit, pieces);
    }
}
