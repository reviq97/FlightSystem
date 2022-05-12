package com.flightnation.flightnation.service;

import com.flightnation.flightnation.entity.BaggageAndCargoAbs;
import com.flightnation.flightnation.entity.Cargos;
import com.flightnation.flightnation.entity.Flight;
import com.flightnation.flightnation.model.CargoDetailsDTO;
import com.flightnation.flightnation.model.FlightsDetailsDTO;
import com.flightnation.flightnation.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService  {

    FlightRepository flightRepository;

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


        Integer cargoWeight = 0;
        Integer baggageWeight = 0;

        for(var w : cargosInfo.getCargo().stream().map(BaggageAndCargoAbs::getWeight).toList()){
            cargoWeight += w;
        }
        for(var w : cargosInfo.getBaggage().stream().map(BaggageAndCargoAbs::getWeight).toList()){
            baggageWeight += w;
        }

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

        flightRepository.listOfCargos.addAll(cargos);

        if(flightRepository.listOfCargos == null){
            return false;
        }

        return true;
    }


    /*public FlightsDetailsDTO getFlightDetails(String iata, String date) {


    }*/
}
