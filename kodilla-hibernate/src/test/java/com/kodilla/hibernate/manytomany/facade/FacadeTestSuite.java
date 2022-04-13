//package com.kodilla.hibernate.manytomany.facade;
//
//import com.kodilla.hibernate.manytomany.Company;
//import com.kodilla.hibernate.manytomany.Employee;
//import com.kodilla.hibernate.manytomany.dao.CompanyDao;
//import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class FacadeTestSuite {
//
//    @Autowired
//    Facade facade;
//
//    @Autowired
//    CompanyDao companyDao;
//
//    @Autowired
//    EmployeeDao employeeDao;
//
//    private final Logger LOGGER = LoggerFactory.getLogger(FacadeTestSuite.class);
//
//    @Test
//    public void testGetCompaniesByPartOfName() {
//        //Given
//        Company microsoft = new Company("Microsoft");
//        Company bethesda = new Company("Bethesda");
//        Company microgigs = new Company("Microgigs");
//
//        //When
//        companyDao.save(microsoft);
//        int id1 = microsoft.getId();
//        companyDao.save(bethesda);
//        int id2 = bethesda.getId();
//        companyDao.save(microgigs);
//        int id3 = microgigs.getId();
//
//        List<Company> resultList = companyDao.retrieveCompanyByPartOfName("%Micro%");
//
//        //Then
//        Assertions.assertEquals(2, resultList.size());
//
//        //CleanUp
//        try {
//            companyDao.deleteById(id1);
//            companyDao.deleteById(id2);
//            companyDao.deleteById(id3);
//        } catch (Exception e) {
//            LOGGER.info("Errors with IDs occured");
//        }
//    }
//
//    @Test
//    public void testGetEmployessByPartOfLastname() {
//        //Given
//        Employee jakubdudek = new Employee("Jakub", "Dudek");
//        Employee martynadudek = new Employee("Martyna", "Dudek");
//        Employee bartoszsmerek = new Employee("Bartosz", "Smerek");
//
//        //When
//        employeeDao.save(jakubdudek);
//        int id1 = jakubdudek.getId();
//        employeeDao.save(martynadudek);
//        int id2 = martynadudek.getId();
//        employeeDao.save(bartoszsmerek);
//        int id3 = bartoszsmerek.getId();
//
//        List<Employee> employeesResult = employeeDao.retrieveEmployeeByPartOfLastname("%Dud%");
//
//        //Then
//        Assertions.assertEquals(2, employeesResult.size());
//
//        //CleanUp
//        try {
//            employeeDao.deleteById(id1);
//            employeeDao.deleteById(id2);
//            employeeDao.deleteById(id3);
//        } catch (Exception e) {
//            LOGGER.info("Errors with IDs occured");
//        }
//    }
//
//    @Test
//    public void testFacade() throws FacadeException {
//        //Given
//        companyDao.deleteAll();
//        employeeDao.deleteAll();
//
//        Company microsoft = new Company("Microsoft");
//        Company bethesda = new Company("Bethesda");
//        Company microgigs = new Company("Microgigs");
//
//        Employee jakubdudek = new Employee("Jakub", "Dudek");
//        Employee martynadudek = new Employee("Martyna", "Bykowska");
//        Employee bartoszsmerek = new Employee("Bartosz", "Smerek");
//
//        //When
//        companyDao.save(microsoft);
//        int id1 = microsoft.getId();
//        companyDao.save(bethesda);
//        int id2 = bethesda.getId();
//        companyDao.save(microgigs);
//        int id3 = microgigs.getId();
//
//        employeeDao.save(jakubdudek);
//        int id4 = jakubdudek.getId();
//        employeeDao.save(martynadudek);
//        int id5 = martynadudek.getId();
//        employeeDao.save(bartoszsmerek);
//        int id6 = bartoszsmerek.getId();
//
//        List<Company> companyListResult = facade.getCompanyByPartOfName("%Micro%");
//        List<Employee> employeeListResult = facade.getEmployeeByPartOfLastname("%Byko%");
//
//        //Then
//        Assertions.assertEquals(2, companyListResult.size());
//        Assertions.assertEquals(1, employeeListResult.size());
//
//        try {
//            companyDao.deleteById(id1);
//            companyDao.deleteById(id2);
//            companyDao.deleteById(id3);
//            employeeDao.deleteById(id4);
//            employeeDao.deleteById(id5);
//            employeeDao.deleteById(id6);
//        } catch (Exception e) {
//            LOGGER.info("Errors with IDs occured");
//        }
//    }
//}