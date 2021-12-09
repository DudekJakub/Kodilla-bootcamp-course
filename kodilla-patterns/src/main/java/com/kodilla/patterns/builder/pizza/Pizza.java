package com.kodilla.patterns.builder.pizza;

import java.util.ArrayList;
import java.util.List;

public final class Pizza {

    private final String pizzaName;
    private String bottom;
    private final String sauce;
    private List<String> ingredients = new ArrayList<>();



    public static class PizzaBuilder {
        private String pizzaName;
        private String bottom;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public PizzaBuilder pizzaName(String pizzaName){
            this.pizzaName = pizzaName;
            return this;
        }

        public PizzaBuilder bottom(String bottom) {
            this.bottom = bottom;
            return this;
        }

        public PizzaBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder ingredient(String ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Pizza build() {
            return new Pizza(pizzaName, bottom, sauce, ingredients);
        }
    }

    private Pizza(final String pizzaName, final String bottom, final String sauce, List<String> ingredients) {
        this.pizzaName = pizzaName;
        this.bottom = bottom;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public void checkBottom() {
        if (bottom == null)
           this.setBottom("standard");
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public String getBottom() {
        return bottom;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "PIZZA [" + pizzaName + "]: " + "bottom = " + bottom + ", sauce = " + sauce + "\ningredients = " + ingredients;
    }
}
