package com.flightnation.flightnation.entity;

import com.flightnation.flightnation.model.Baggage;
import com.flightnation.flightnation.model.Cargo;
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
