package com.kodilla.hibernate.manytomany.facade;

import org.slf4j.Logger;

public class FacadeException extends Exception {

    public static final String ERR_COMPANYNAME_NOT_FOUND = "Company not found";
    public static final String ERR_EMPLOYEE_NOT_FOUND = "Employee not found";

    public FacadeException(String message) {
        super(message);
    }
}
