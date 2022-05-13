package com.flightnation.flightnation.repository;

import com.flightnation.flightnation.entity.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FlightRepository {

    public List<Cargos> listOfCargos = new ArrayList<>();
    public List<Flight> listOfFlights = new ArrayList<>();
}
