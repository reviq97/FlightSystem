package com.flightnation.flightnation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FlightsDetailsDTO {

    private Long fromAirportFlights;
    private Long toAirportFlights;
    private Integer totalPiecesOfBaggageArriv;
    private Integer totalPiecesOfBaggageDepart;

}
