package com.flightnation.flightnation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Cargos {

    private Integer flightId;
    private List<Baggage> baggage;
    private List<Cargo> cargo;
}
