package com.kodilla.good.patterns.challenges.Flights;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlightSearchFROM {

    List<String> cities = new ArrayList<>();
    List<String> notFound = new ArrayList<>();
    private static final String noFlights = "FLIGHTS NOT FOUND";
    private static final String noCitySelected = "CITY NOT SELECTED";

    public List<String> FlightSearchFromProcess(HashMap<Integer, Flight> flightsCityList, FlightOrder flightOrder) {
            flightsCityList.values().stream()
                    .filter(e -> e.getDepartureAirport().equals(flightOrder.getDepartureAirport()))
                    .map(Flight::getArrivalAirport)
                    .forEach(cities::add);

            if(flightOrder.getDepartureAirport().isEmpty()) {
                System.out.println("Proszę wpisać miasto wylotowe!");
                notFound.add(noCitySelected);
                return notFound;
            } else if(cities.isEmpty()) {
                System.out.println("Z wybranego miasta nie kursują żadne z Naszych lotów!");
                notFound.add(noFlights);
                return notFound;
            } else {
                return cities;
        }
    }
}
