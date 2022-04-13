package com.kodilla.hibernate.manytomany;


import javax.persistence.*;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(
        name = "Employee.retrieveRequestedLastname",
        query = "FROM Employee WHERE lastname = :LASTNAME"
)
@NamedNativeQuery(
        name = "Employee.retrieveEmployeeByPartOfLastname",
        query = "SELECT * FROM kodilla_course.employees WHERE lastname LIKE :ARG",
        resultClass = Employee.class
)
@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    private int id;
    private String firstname;
    private String lastname;
    private List<Company> companies = new ArrayList<>();

    public Employee() {
    }

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @NotNull
    @GeneratedValue
    @Id
    @Column(name = "EMPLOYEE_ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "FIRSTNAME")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @NotNull
    @Column(name = "LASTNAME")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_COMPANY_EMPLOYEE",
            joinColumns = {@JoinColumn(name="EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")},
            inverseJoinColumns = {@JoinColumn(name="COMPANY_ID", referencedColumnName = "COMPANY_ID")}
    )
    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
