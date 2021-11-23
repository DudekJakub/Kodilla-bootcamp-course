package com.kodilla.good.patterns.challenges.Flights;

import java.util.HashMap;

public class FlightsCityList {

    public HashMap<Integer, Flight> flightsList() {
        HashMap<Integer, Flight> listOfFlights = new HashMap<>();
        listOfFlights.put(0, new Flight("Poznań", "Gdańsk"));
        listOfFlights.put(1, new Flight("Poznań", "Warszawa"));
        listOfFlights.put(2, new Flight("Gdańsk", "Warszawa"));
        listOfFlights.put(3, new Flight("Warszawa", "Berlin"));
        listOfFlights.put(4, new Flight("Gdańsk", "Berlin"));
        listOfFlights.put(5, new Flight("Berlin", "Poznań"));
        listOfFlights.put(6, new Flight("Berlin", "Warszawa"));
        listOfFlights.put(7, new Flight("Berlin", "Kraków"));

        return listOfFlights;
    }
}
