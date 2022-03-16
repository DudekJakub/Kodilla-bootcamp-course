package com.kodilla.patterns2.adapter.company.newhrsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class CompanySalaryProcessor implements SalaryProcessor {

    private final static Logger LOGGER = LoggerFactory.getLogger(CompanySalaryProcessor.class);

    @Bean
    @Override
    public BigDecimal calculateSalary(List<Employee> employees) throws Error {
        LOGGER.info("Starting salary processor...");

        BigDecimal sum = BigDecimal.ZERO;

        try {
            for (Employee employee : employees) {
                System.out.println(employee);
                if (employee.getBaseSalary().intValue() > BigDecimal.valueOf(1000).intValue()) {
                    sum = sum.add(employee.getBaseSalary());
                } else {
                    LOGGER.error("Something went wrong with processing 'calculate salary'!");
                }
            }
        } catch (Error e) {
            System.out.println(e.getMessage());
            LOGGER.error("Something went wrong with processing 'calculate salary'!");
            throw e;
        }
        LOGGER.info("Salary processor successfully finished process.");
        System.out.println("Total salary value = " + sum + " PLN");
        return sum;
    }
}
