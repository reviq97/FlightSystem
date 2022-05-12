package com.flightnation.flightnation.entity;

import com.flightnation.flightnation.model.WeightUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class BaggageAndCargoAbs {

    private Integer id;
    private Integer weight;
    private WeightUnit weightUnit;
    private Integer pieces;

}
