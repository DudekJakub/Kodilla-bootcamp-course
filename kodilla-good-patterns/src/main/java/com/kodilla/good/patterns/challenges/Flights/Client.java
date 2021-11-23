package com.kodilla.good.patterns.challenges.Flights;

import java.util.Objects;

public class Client {

    private String name;
    private String surname;
    private int id;
    private int telNumber;

    public Client(String name, String surname, int id, int telNumber) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.telNumber = telNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public int getTelNumber() {
        return telNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return Objects.equals(name, client.getName()) && Objects.equals(surname, client.getSurname()) && id == client.getId() && telNumber == client.getTelNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, id, telNumber);
    }

    @Override
    public String toString() {
        return "Client " +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", telNumber=" + telNumber;
    }
}
