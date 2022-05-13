package com.flightnation.flightnation.controller;

import com.flightnation.flightnation.service.exceptions.FlightNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class ExceptionControllerAdvice {

    @ExceptionHandler
    public ResponseEntity onFlightNotFound(FlightNotFoundException ex){

        return ResponseEntity.notFound().build();
    }

}
