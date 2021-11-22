package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class Order {

    private final User user;
    private final String product;
    private final int quantity;
    private final LocalDate dateOfOrder;
    private final boolean isOrdered;


    public Order(User user, String product, int quantity, LocalDate dateOfOrder, boolean isOrdered) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.dateOfOrder = dateOfOrder;
        this.isOrdered = isOrdered;
    }

    public User getUser() {
        return user;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
