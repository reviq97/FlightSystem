package com.flightnation.flightnation.model;

import com.flightnation.flightnation.entity.BaggageAndCargoAbs;

public class Baggage extends BaggageAndCargoAbs {

    public Baggage(Integer id, Integer weight, WeightUnit weightUnit, Integer pieces) {
        super(id, weight, weightUnit, pieces);
    }
}
