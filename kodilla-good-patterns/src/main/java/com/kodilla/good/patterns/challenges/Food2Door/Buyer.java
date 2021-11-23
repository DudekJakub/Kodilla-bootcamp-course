package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.Objects;

public class Buyer {

    private String name;
    private String city;
    private String street;
    private String postCode;
    private String buildingNumber;

    public Buyer(String name, String city, String street, String postCode, String buildingNumber) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.postCode = postCode;
        this.buildingNumber = buildingNumber;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buyer buyer = (Buyer) o;

        return Objects.equals(getName(), buyer.getName()) && Objects.equals(getCity(), buyer.getCity()) && Objects.equals(getStreet(), buyer.getStreet())
                && Objects.equals(getPostCode(), buyer.getPostCode()) && Objects.equals(getBuildingNumber(), buyer.getBuildingNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCity(), getStreet(), getPostCode(), getBuildingNumber());
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                '}';
    }
}
