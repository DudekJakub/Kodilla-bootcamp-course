package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Company.retrieveCompanyByFirstThreeLetters",
                query = "SELECT * FROM kodilla_course.companies WHERE LEFT(COMPANY_NAME, 3) = :SHORTNAME",
                resultClass = Company.class
        ),
        @NamedNativeQuery(
                name = "Company.retrieveCompanyByPartOfName",
                query = "SELECT * FROM kodilla_course.companies WHERE company_name LIKE :ARG",
                resultClass = Company.class
        )
})
@Entity
@Table(name = "COMPANIES")
public class Company {

    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @NotNull
    @GeneratedValue
    @Id
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "companies"
    )
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
