package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class SearchFlights {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> flightMap = new HashMap<>();
            flightMap.put("Poznań", true);
            flightMap.put("Kraków", true);
            flightMap.put("Berlin", false);
            flightMap.put("Praga", true);

            if (flightMap.get(flight.getArrivalAirport()).equals(flightMap.containsKey(flight.getArrivalAirport()))) {
                return true;
            } else {
                System.out.println("Flight: " + flight.getArrivalAirport() + ", flightMap(key): " + flightMap.get(flight.getArrivalAirport()) + " -> equals: " + flight.getArrivalAirport().equals(flightMap.containsKey(flight.getArrivalAirport())));
                throw new RouteNotFoundException();
            }
    }

    public static void main (String[] args) {
        Flight flight1 = new Flight("Berlin", "Poznań");
        Flight flight2 = new Flight("Kraków", "Berlin");
        Flight flight3 = new Flight("Praga", "Bratysława");
        SearchFlights searchFlights = new SearchFlights();

        try {
            System.out.println(searchFlights.findFlight(flight1));
            System.out.println(searchFlights.findFlight(flight2));
            System.out.println(searchFlights.findFlight(flight3));
        } catch (RouteNotFoundException e) {
            System.out.println("Exception has been found! Arrival airport doesn't exist!");
        }
    }
}
