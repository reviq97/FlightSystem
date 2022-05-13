package com.flightnation.flightnation.controller;

import com.flightnation.flightnation.entity.Cargos;
import com.flightnation.flightnation.entity.Flight;
import com.flightnation.flightnation.model.CargoDetailsDTO;
import com.flightnation.flightnation.model.FlightsDetailsDTO;
import com.flightnation.flightnation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    FlightService flightService;
    private Flight flight;

    @Autowired
    public FlightController(FlightService flighService){
        this.flightService = flighService;
    }


    //exercise 2
    @GetMapping("/flight/flight_details")
    public ResponseEntity<FlightsDetailsDTO> getFlightsDetails(@RequestParam(name = "iataCode") String iata,
                                                               @RequestParam(name = "departureDate") String date){

        var response = flightService.getFlightDetails(iata, date);

        return new ResponseEntity<FlightsDetailsDTO>(response, HttpStatus.OK);
    }

    //exercise 1
    @GetMapping("/flight/cargo_details")
    public ResponseEntity<CargoDetailsDTO> getCargoDetails(@RequestParam(name = "flightnumber") Integer flightNumber,
                                                           @RequestParam(name = "departuredate") String date){

        var response = flightService.getCargoByNumAndDate(flightNumber, date);

        return new ResponseEntity<CargoDetailsDTO>(response, HttpStatus.OK);
    }


    //post to fill repository with test values
    @PostMapping("/flight/cargos")
    public ResponseEntity<Cargos> postCargos(@RequestBody List<Cargos> cargos){


        if(cargos.get(1).getCargo() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var response = flightService.postCargoData(cargos);

        if(!response){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/flight/flights")
    public ResponseEntity<Flight> postFlights(@RequestBody List<Flight> flights){

        if(flights.get(1).getFlightNumber()==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        flightService.postFlightData(flights);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
