package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facade {

    public static final Logger LOGGER = LoggerFactory.getLogger(Facade.class);

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    public List<Company> getCompanyByPartOfName(String partOfName) throws FacadeException {
        boolean wasError = false;
        List<Company> companiesResult = companyDao.retrieveCompanyByPartOfName(partOfName);
        LOGGER.info("Searching for companies...");
        if (companiesResult.isEmpty()) {
            LOGGER.error(FacadeException.ERR_COMPANYNAME_NOT_FOUND);
            wasError = true;
        } else {
            LOGGER.info("Companies found.");
        }
        if (wasError) {
            LOGGER.info("Searching failed. Error occured.");
            throw new FacadeException(FacadeException.ERR_COMPANYNAME_NOT_FOUND);
        }
        return companiesResult;
    }

    public List<Employee> getEmployeeByPartOfLastname(String partOfLastname) throws FacadeException {
        boolean wasError = false;
        List<Employee> employeesResult = employeeDao.retrieveEmployeeByPartOfLastname(partOfLastname);
        LOGGER.info("Searching for employees...");
        if (employeesResult.isEmpty()) {
            LOGGER.error(FacadeException.ERR_EMPLOYEE_NOT_FOUND);
            wasError = true;
        } else {
            LOGGER.info("Employees found.");
        }
        if (wasError) {
            LOGGER.info("Searching failed. Error occured.");
            throw new FacadeException(FacadeException.ERR_EMPLOYEE_NOT_FOUND);
        }
        return employeesResult;
    }
}
