package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.ArrayList;
import java.util.List;

public class ExpeditionService implements Service {

    private List<Order> orderList = new ArrayList<Order>();
    private int orderNumber;

    public void addNewOrder(Buyer buyer, Product product) {
        orderNumber++;
        Order order = new Order(orderNumber, product, buyer,false);
        orderList.add(order);
    }

    @Override
    public List<Order> getOrders() {
        return orderList;
    }

    @Override
    public void setOrderCompleted(Order order) {
        for (Order ord : orderList) {
            if (ord.equals(order)) {
                ord.setCompleted();
            }
        }
    }

    public List<Order> getUncompletedOrders() {
        List<Order> orderList = new ArrayList<Order>();
        this.orderList.stream()
                .filter(order -> !order.isCompleted())
                .forEach(orderList::add);
        return orderList;
    }

    public List<Order> getCompletedOrders() {
        List<Order> orderList = new ArrayList<>();
        this.orderList.stream()
                .filter(order -> order.isCompleted())
                .forEach(orderList::add);
        return orderList;
    }

    @Override
    public String toString() {
        return "ExpeditionService{" +
                "orderList=" + orderList +
                ", orderNumber=" + orderNumber +
                '}';
    }
}
