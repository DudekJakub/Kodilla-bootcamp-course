package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorTestSuite {

    @Test
    void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double addResult = calculator.add(5, 5);
        double subResult = calculator.sub(5, 5);
        double mulResult = calculator.mul(5, 5);
        double divResult = calculator.div(5, 5);

        //Then
        Assertions.assertEquals(10, addResult);
        Assertions.assertEquals(0,  subResult);
        Assertions.assertEquals(25, mulResult);
        Assertions.assertEquals(1,  divResult);
    }
}
