package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

@SpringBootTest
public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrder() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder("ciasto cienkie", "sos pomidorowy");
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        String descripiton = pizzaOrder.getDescription();
        //Then
        assertEquals(new BigDecimal(15), calculatedCost);
        assertEquals("Ingredients: ciasto cienkie, sos pomidorowy, cheese + extras:", descripiton);
    }

    @Test
    public void testHamOrderDecorator() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder("ciasto grube", "sos pomidorowy");
        pizzaOrder = new HamOrderDecorator(pizzaOrder);
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals(new BigDecimal(25), calculatedCost);
        assertEquals("Ingredients: ciasto grube, sos pomidorowy, cheese + extras: [HAM]", description);
    }

}
