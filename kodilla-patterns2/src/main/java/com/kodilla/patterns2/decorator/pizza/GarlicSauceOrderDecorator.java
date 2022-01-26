package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class GarlicSauceOrderDecorator extends AbstractPizzaOrderDecorator {

    private BasicPizzaOrder basicPizzaOrder;

    public GarlicSauceOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal("3.50"));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " [GARLIC SAUCE]";
    }
}
