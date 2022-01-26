package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {

    private final String typeOfCake;
    private final String typeOfSauce;

    public BasicPizzaOrder(String typeOfCake, String typeOfSauce) {
        this.typeOfCake = typeOfCake;
        this.typeOfSauce = typeOfSauce;
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(15);
    }

    @Override
    public String getDescription() {
        return "Ingredients: " + typeOfCake + ", " + typeOfSauce + ", cheese + extras:";
    }
}
