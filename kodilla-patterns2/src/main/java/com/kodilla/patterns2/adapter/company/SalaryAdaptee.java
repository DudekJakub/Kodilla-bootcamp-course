package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.newhrsystem.CompanySalaryProcessor;
import com.kodilla.patterns2.adapter.company.newhrsystem.Employee;
import com.kodilla.patterns2.adapter.company.newhrsystem.SalaryProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SalaryAdaptee implements SalaryProcessor {

    @Override
    public BigDecimal calculateSalary(List<Employee> employees) {
        CompanySalaryProcessor processor = new CompanySalaryProcessor();
        return processor.calculateSalary(employees);
    }
}
