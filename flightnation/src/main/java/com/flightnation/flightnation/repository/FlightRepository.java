package com.flightnation.flightnation.repository;

import com.flightnation.flightnation.entity.*;
import com.flightnation.flightnation.model.IATACode;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class FlightRepository {

    public List<Flight> listOfFlights = new ArrayList<>(Arrays.asList(
            new Flight(0, 7840, IATACode.valueOf("YYT"), IATACode.valueOf("GDN"), "2019-02-11T09:37:18 -01:00"),
            new Flight(1, 4914, IATACode.valueOf("LAX"), IATACode.valueOf("KRK"), "2016-09-11T06:25:43 -02:00"),
            new Flight(2, 8597, IATACode.valueOf("LAX"), IATACode.valueOf("PPX"), "2020-01-30T12:12:40 -01:00"),
            new Flight(4, 6323, IATACode.valueOf("ANC"), IATACode.valueOf("KRK"), "2017-08-09T07:09:51 -02:00"),
            new Flight(5, 1788, IATACode.valueOf("ANC"), IATACode.valueOf("KRK"), "2019-01-01T03:36:18 -01:00")
    ));

    public List<Cargos> listOfCargos = new ArrayList<>();

}
