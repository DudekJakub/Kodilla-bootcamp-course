package com.kodilla.good.patterns.challenges.Flights;

import java.util.HashMap;
import java.util.List;

public class FlightFinderApp {

    public static void main(String[] args) {
        Client JakubDudek = new Client("Jakub", "Dudek", 1, 783963499);
        Client MartynaBykowska = new Client("Martyna", "Bykowska", 2, 782998102);

        FlightOrder JakubDudekOrder1 = new FlightOrder(JakubDudek, "", "Warszawa");
        FlightOrder MartynaBykowskaOrder1 = new FlightOrder(MartynaBykowska, "Gdańsk", "");
        FlightOrder JakubDudekOrder2 = new FlightOrder(JakubDudek, "Dublin", "Poznań");

        FlightsCityList flightsCityList = new FlightsCityList();
        HashMap<Integer, Flight> allFlightList = flightsCityList.flightsList();

        FlightSearchFROM flightSearchFROM = new FlightSearchFROM();
        FlightSearchTO flightSearchTO = new FlightSearchTO();
        FlightSearchCONNECTION flightSearchCONNECTION = new FlightSearchCONNECTION();

        System.out.println("\nOrder for: " + JakubDudek + ". List of all flights FROM " + JakubDudekOrder1.getDepartureAirport() + ": ");
        List<String> result1 = flightSearchFROM.FlightSearchFromProcess(allFlightList, JakubDudekOrder1);
        System.out.println(result1);

        System.out.println("\nOrder for: " + MartynaBykowska + ". List of all flights TO " + MartynaBykowskaOrder1.getArrivalAirport() + ": ");
        List<String> result2 = flightSearchTO.FlightSearchToProcess(allFlightList, MartynaBykowskaOrder1);
        System.out.println(result2);

        System.out.println("\nOrder for: " + JakubDudek + ". Connecting flights FROM: " + JakubDudekOrder2.getDepartureAirport() + " TO: " + JakubDudekOrder2.getArrivalAirport() +
                           ", are possible from the following cities: ");
        List<String> result3 = flightSearchCONNECTION.FlightSearchConnectionProcess(allFlightList, JakubDudekOrder2);
        System.out.println(result3);
    }
}
