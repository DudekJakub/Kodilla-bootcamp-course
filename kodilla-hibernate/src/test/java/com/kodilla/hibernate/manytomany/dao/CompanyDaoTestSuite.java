package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

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
}
