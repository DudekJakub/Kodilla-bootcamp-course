package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.List;

public interface Service {

    List<Order> getOrders();
    void setOrderCompleted(Order order);
}
