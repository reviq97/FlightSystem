package com.flightnation.flightnation.entity;

import com.flightnation.flightnation.model.IATACode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Flight {

    private Integer flightId;
    private Integer flightNumber;
    private IATACode DEPARTURE_IATA_CODE;
    private IATACode ARRIVAL_IATA_CODE;
    private String departureDate;

}
