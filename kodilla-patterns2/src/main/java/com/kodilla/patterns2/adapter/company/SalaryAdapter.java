package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.newhrsystem.Employee;
import com.kodilla.patterns2.adapter.company.oldhrsystem.SalaryCalculator;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class SalaryAdapter extends SalaryAdaptee implements SalaryCalculator {

    @Override
    public double TotalSalary(String[][] workers, double[] salaries) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < salaries.length; i++) {
            employees.add(new Employee(
                    workers[i][0],
                    workers[i][1],
                    workers[i][2],
                    BigDecimal.valueOf(salaries[i])
            ));
        }
        return calculateSalary(employees).doubleValue();
    }
}
