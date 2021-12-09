package com.kodilla.patterns.builder.pizza;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PizzaTestSuite {

    @Test
    void testPizzaNew() {
        //Given
        Pizza newPizza = new Pizza.PizzaBuilder()
                .pizzaName("Capriciosa")
                .ingredient("Onion")
                .sauce("spicy")
                .ingredient("Ham")
                .ingredient("Mushrooms")
                .build();
        newPizza.checkBottom();
        System.out.println(newPizza);

        //When
        int howManyIngredients = newPizza.getIngredients().size();

        //Then
        Assertions.assertEquals(3, howManyIngredients);
    }
}
