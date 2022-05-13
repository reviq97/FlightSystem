package com.flightnation.flightnation.entity;

import com.flightnation.flightnation.entity.BaggageAndCargoAbs;
import com.flightnation.flightnation.model.WeightUnit;

public class Baggage extends BaggageAndCargoAbs {

    public Baggage(Integer id, Integer weight, WeightUnit weightUnit, Integer pieces) {
        super(id, weight, weightUnit, pieces);
    }
}
