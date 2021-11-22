package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.Objects;

public class Order {

    private int orderNumber;
    private Product product;
    private Buyer buyer;
    private boolean completed;

    public Order(int orderNumber, Product product, Buyer buyer, boolean completed) {
        this.orderNumber = orderNumber;
        this.product = product;
        this.buyer = buyer;
        this.completed = completed;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Product getProduct() {
        return product;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean isCompleted) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return isCompleted() == order.isCompleted() && getOrderNumber() == order.getOrderNumber() && Objects.equals(getBuyer(), order.getBuyer()) && Objects.equals(getProduct(), order.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderNumber(), getProduct(), getBuyer(), isCompleted());
    }
}
