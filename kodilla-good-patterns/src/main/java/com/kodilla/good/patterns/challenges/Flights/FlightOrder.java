package com.kodilla.good.patterns.challenges.Flights;

public class FlightOrder {

    private Client client;
    private String arrivalAirport;
    private String departureAirport;

    public FlightOrder(Client client, String arrivalAirport, String departureAirport) {
        this.client = client;
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
    }

    public Client getClient() {
        return client;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    @Override
    public String toString() {
        return "FlightOrderByClient{" +
                "client=" + client +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                '}';
    }
}
