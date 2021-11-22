package com.kodilla.good.patterns.challenges;

public class ProductOrderService implements OrderService {

    @Override
    public boolean order(Order order) {
        System.out.println(order.getUser().getUserName() + " " + order.getUser().getUserSurname() + " | " + order.getProduct() + " | " + order.getQuantity() + " | " + order.getDateOfOrder());
        return true;
    }
}
