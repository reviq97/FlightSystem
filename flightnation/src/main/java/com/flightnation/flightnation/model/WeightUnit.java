package com.flightnation.flightnation.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum WeightUnit {
    KG("kg"),
    LB("lb");

    private String weight;
    WeightUnit(String weight){
        this.weight = weight;
    }

    @Override
    public String toString() {
        return weight;
    }

    @JsonCreator
    public static WeightUnit create(String value){
        if(value == null){
            throw new IllegalArgumentException();
        }
        for(WeightUnit w : values()){
            if(value.equals(w.weight)){
                return w;
            }
        }
        throw new IllegalArgumentException();
    }
}
