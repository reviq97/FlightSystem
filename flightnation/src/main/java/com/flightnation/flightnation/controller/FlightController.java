package com.flightnation.flightnation.controller;

import com.flightnation.flightnation.entity.Cargos;
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

    FlightService flighService;

    @Autowired
    public FlightController(FlightService flighService){
        this.flighService = flighService;
    }


    /*//excercise 2
    @GetMapping("/flights")
    public ResponseEntity<FlightsDetailsDTO> getFlightsDetails(@RequestParam(name = "iataCode") String iata,
                                                               @RequestParam(name = "departureDate") String date){

        var response = flighService.getFlightDetails(iata, date);
    }*/

    //excercise 1
    @GetMapping("/flights")
    public ResponseEntity<CargoDetailsDTO> getCargoDetails(@RequestParam(name = "flightNumber") Integer flightNumber,
                                                           @RequestParam(name = "departureDate") String date){

        var response = flighService.getCargoByNumAndDate(flightNumber, date);

        return new ResponseEntity<CargoDetailsDTO>(response, HttpStatus.OK);
    }


    //post to fill repository with test values
    @PostMapping("/flights")
    public ResponseEntity<Cargos> postFlights(@RequestBody List<Cargos> cargos){

        var response = flighService.postCargoData(cargos);

        if(!response){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
