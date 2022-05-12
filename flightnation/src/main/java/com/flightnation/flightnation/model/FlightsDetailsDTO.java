package com.flightnation.flightnation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FlightsDetailsDTO {

    private Integer fromAirportFlights;
    private Integer toAirportFlights;
    private Integer totalPiecesOfBaggageArriv;
    private Integer totalPiecesOfBaggageDepart;

}
