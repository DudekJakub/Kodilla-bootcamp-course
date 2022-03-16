package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee jakubDudek = new Employee("Jakub", "Dudek");
        Employee martynaBykowska = new Employee("Martyna", "Bykowska");
        Employee bartoszSmerek = new Employee("Bartosz", "Smerek");
        Company geodrill = new Company("Geodrill");
        Company dataMaesters = new Company("Data Maesters");
        Company softwareMachine = new Company("Software Machine");

        geodrill.getEmployees().add(jakubDudek);
        geodrill.getEmployees().add(martynaBykowska);
        dataMaesters.getEmployees().add(jakubDudek);
        dataMaesters.getEmployees().add(bartoszSmerek);
        softwareMachine.getEmployees().add(bartoszSmerek);

        jakubDudek.getCompanies().add(geodrill);
        jakubDudek.getCompanies().add(dataMaesters);
        martynaBykowska.getCompanies().add(geodrill);
        bartoszSmerek.getCompanies().add(dataMaesters);
        bartoszSmerek.getCompanies().add(softwareMachine);

        //When
        companyDao.save(geodrill);
        int geodrillId = geodrill.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();

        //Then
        Assertions.assertNotEquals(0, geodrillId);
        Assertions.assertNotEquals(0, dataMaestersId);
        Assertions.assertNotEquals(0, softwareMachineId);

        //CleanUp
//        try{
//            companyDao.deleteById(geodrillId);
//            companyDao.deleteById(dataMaestersId);
//            companyDao.deleteById(softwareMachineId);
//        } catch (Exception e) {
//            //do nothing
//        }
    }

    @Test
    void testNamedQueries() {
        //Given
        Employee employee1 = new Employee("Jakub", "Dudek");
        Employee employee2 = new Employee("Bartosz", "Smerek");
        Employee employee3 = new Employee("Rafał", "Smerek");
        Employee employee4 = new Employee("Dariusz", "Kowalski");
        Employee employee5 = new Employee("Damian", "Dudzik");

        Company company1 = new Company("Data Maesters");
        Company company2 = new Company("Software Machine");

        company1.getEmployees().add(employee1);
        company1.getEmployees().add(employee2);
        company1.getEmployees().add(employee3);
        company2.getEmployees().add(employee4);
        company2.getEmployees().add(employee5);

        employee1.getCompanies().add(company1);
        employee2.getCompanies().add(company1);
        employee3.getCompanies().add(company1);
        employee2.getCompanies().add(company2);
        employee2.getCompanies().add(company2);

        companyDao.save(company1);
        companyDao.save(company2);

        //When
        List<Employee> requestedLastname = employeeDao.retrieveRequestedLastname("Dudek");
        List<Company> firstThreeLettersCompany = companyDao.retrieveCompanyByFirstThreeLetters("Dat");
        System.out.println("----- TUTAJ -----");
        firstThreeLettersCompany.stream().forEach(System.out::println);
        //Then
        try {
            Assertions.assertEquals(1, requestedLastname.size());
            Assertions.assertEquals(1, firstThreeLettersCompany.size());
        } finally {
            //CleanUp
            companyDao.deleteAll();
            employeeDao.deleteAll();
        }
    }
}
