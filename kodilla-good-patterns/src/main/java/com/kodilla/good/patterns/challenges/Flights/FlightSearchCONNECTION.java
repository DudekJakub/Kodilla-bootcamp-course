package com.kodilla.good.patterns.challenges.Flights;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlightSearchCONNECTION {

    List<String> cities = new ArrayList<>();
    List<String> cities1 = new ArrayList<>();
    List<String> cities2 = new ArrayList<>();
    private static final String error = "INCORRECT DATA";

    public List<String> FlightSearchConnectionProcess(HashMap<Integer, Flight> flightsCityList, FlightOrder flightOrder) {

        flightsCityList.values().stream()
                .map(Flight::getArrivalAirport)
                .forEach(cities1::add);

        flightsCityList.values().stream()
                .map(Flight::getDepartureAirport)
                .forEach(cities2::add);

        if(flightOrder.getDepartureAirport().equals(flightOrder.getArrivalAirport())) {
            System.out.println("Proszę wybrać różne miasta!");
            cities.add(error);
        } else if (!cities1.contains(flightOrder.getArrivalAirport())) {
            System.out.println("Miasto docelowe nie znajduję się w zakresie Naszych lotów!");
            cities.add(error);
            return cities;
        } else if (!cities2.contains(flightOrder.getDepartureAirport())) {
            System.out.println("Miasto wylotowe nie znajduję się w zakresie Naszych lotów!");
            cities.add(error);
            return cities;
        } else {
            flightsCityList.values().stream()
                    .filter(e -> e.getArrivalAirport().equals(flightOrder.getArrivalAirport()))
                    .map(Flight::getDepartureAirport)
                    .forEach(cities::add);

            cities.remove(flightOrder.getDepartureAirport());
        }
        return cities;
    }
}
