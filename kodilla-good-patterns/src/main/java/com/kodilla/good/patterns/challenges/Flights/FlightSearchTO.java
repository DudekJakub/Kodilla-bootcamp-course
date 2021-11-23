package com.kodilla.good.patterns.challenges.Flights;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlightSearchTO {

    List<String> cities = new ArrayList<>();
    List<String> notFound = new ArrayList<>();
    private static final String noFlights = "FLIGHTS NOT FOUND";
    private static final String noCitySelected = "CITY NOT SELECTED";

    public List<String> FlightSearchToProcess(HashMap<Integer, Flight> flightsCityList, FlightOrder flightOrder) {
            flightsCityList.values().stream()
                    .filter(e -> e.getArrivalAirport().equals(flightOrder.getArrivalAirport()))
                    .map(Flight::getDepartureAirport)
                    .forEach(cities::add);

            if(flightOrder.getArrivalAirport().equals("")) {
                System.out.println("Proszę wpisać miasto docelowe!");
                notFound.add(noCitySelected);
                return notFound;
            } else if(cities.isEmpty()) {
                System.out.println("Do wybranego miasta nie kursują żadne z Naszych lotów!");
                notFound.add(noFlights);
                return notFound;
            } else {
                return cities;
        }
    }
}
