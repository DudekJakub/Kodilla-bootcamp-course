package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AdapterTestSuite {

    @Autowired
    Workers workers;

    @Test
    public void testGetWorker() {
        //Given
        String worker1 = "";

        //When
        worker1 = workers.getWorker(0);
        System.out.println(worker1);

        //Then
        assertTrue(worker1.contains("John") && worker1.contains("Smith"));

    }

    @Test
    public void testTotalSalary() {
        //Given
        SalaryAdapter salaryAdapter = new SalaryAdapter();
        //When
        double totalSalary = salaryAdapter.TotalSalary(workers.getWorkers(), workers.getSalaries());
        //Then
        assertEquals(27750, totalSalary);
    }
}
