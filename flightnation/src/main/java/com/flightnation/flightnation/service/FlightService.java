package com.flightnation.flightnation.service;

import com.flightnation.flightnation.entity.Baggage;
import com.flightnation.flightnation.entity.BaggageAndCargoAbs;
import com.flightnation.flightnation.entity.Cargos;
import com.flightnation.flightnation.entity.Flight;
import com.flightnation.flightnation.model.CargoDetailsDTO;
import com.flightnation.flightnation.model.FlightsDetailsDTO;
import com.flightnation.flightnation.repository.FlightRepository;
import com.flightnation.flightnation.service.exceptions.FlightNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FlightService  {

    FlightRepository flightRepository;
    private List<Flight> arrivedObjects;

    @Autowired
    public FlightService(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }


    public CargoDetailsDTO getCargoByNumAndDate(Integer flightNumber, String date) {

        Flight response = flightRepository.listOfFlights.stream()
                .filter(f -> f.getFlightNumber().equals(flightNumber))
                .filter(p -> p.getDepartureDate().equals(date))
                .findAny()
                .orElse(null);

        Cargos cargosInfo = flightRepository.listOfCargos.stream()
                .filter(f -> f.getFlightId().equals(response.getFlightId()))
                .findAny().orElse(null);


        Integer cargoWeight = cargosInfo.getCargo().stream()
                .map(BaggageAndCargoAbs::getWeight)
                .reduce(Integer::sum).get();

        Integer baggageWeight = cargosInfo.getBaggage().stream()
                .map(BaggageAndCargoAbs::getWeight)
                .reduce(Integer::sum).get();

        Integer totalWeight = cargoWeight + baggageWeight;

        if(totalWeight == 0){
            return null;
        }

        return new CargoDetailsDTO(
                cargoWeight,
                baggageWeight,
                totalWeight
        );
    }


    public Boolean postCargoData(List<Cargos> cargos){

        if(flightRepository.listOfCargos == null){
            return false;
        }

        flightRepository.listOfCargos.addAll(cargos);

        return true;
    }


    public FlightsDetailsDTO getFlightDetails(String iata, String date) {

        //num of departing flights
        var numberOfDepartingFlights = flightRepository.listOfFlights.stream()
                .filter(p -> p.getDepartureAirportIATACode().toString().equals(iata))
                .filter(d -> d.getDepartureDate().substring(0,10).equals(date.substring(0,10)))
                .count();


        //num of arrived flights
        var numberOfArrivedFlights = flightRepository.listOfFlights.stream()
                .filter(p -> p.getArrivalAirportIATACode().toString().equals(iata))
                .count();

        Flight departingFlightIataAndDate = flightRepository.listOfFlights.stream()
                .filter(f -> f.getDepartureAirportIATACode().toString().equals(iata))
                .filter(f -> f.getDepartureDate().substring(0,10).equals(date.substring(0,10)))
                .findAny()
                .orElseThrow(FlightNotFoundException::new);

        Flight arrivalFlightIata = flightRepository.listOfFlights.stream()
                .filter(p -> p.getDepartureAirportIATACode().toString().equals(iata))
                .findAny()
                .orElseThrow(FlightNotFoundException::new);


        var arrivingAirportPieces = flightRepository.listOfCargos.stream()
                .filter(f -> f.getFlightId().equals(arrivalFlightIata.getFlightId()))
                .map(Cargos::getBaggage)
                .findFirst()
                .get()
                .stream()
                .map(p->p.getPieces())
                .reduce(Integer::sum)
                .get();

        var departingAirportPieces = flightRepository.listOfCargos.stream()
                .filter(f -> f.getFlightId().equals(departingFlightIataAndDate.getFlightId()))
                .map(Cargos::getBaggage)
                .findFirst()
                .get()
                .stream()
                .map(p->p.getPieces())
                .reduce(Integer::sum)
                .get();



        return new FlightsDetailsDTO(numberOfDepartingFlights,numberOfArrivedFlights,arrivingAirportPieces,departingAirportPieces);
    }

    public Boolean postFlightData(List<Flight> flights) {

        if(flightRepository.listOfFlights ==null){
            return false;
        }
        flightRepository.listOfFlights.addAll(flights);

        return true;
    }
}
