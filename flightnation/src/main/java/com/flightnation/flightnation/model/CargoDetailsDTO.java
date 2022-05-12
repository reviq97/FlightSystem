package com.flightnation.flightnation.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CargoDetailsDTO {

    private Integer cargoWeight;
    private Integer baggageWeight;
    private Integer totalWeight;
}
