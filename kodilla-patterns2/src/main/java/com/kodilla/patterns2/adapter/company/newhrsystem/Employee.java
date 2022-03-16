package com.kodilla.patterns2.adapter.company.newhrsystem;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
public class Employee {

    final private String name;
    final private String surname;
    final private String peselId;
    final private BigDecimal baseSalary;

    public Employee(String peselId, String name, String surname, BigDecimal baseSalary) {
        this.name = name;
        this.surname = surname;
        this.peselId = peselId;
        this.baseSalary = baseSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return peselId != null ? peselId.equals(employee.peselId) : employee.peselId == null;
    }

    @Override
    public int hashCode() {
        return peselId != null ? peselId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", peselId='" + peselId + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }
}
