package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.List;

public class SendOrderService {

    public boolean isSent(String name, Service service, List<Product> productList) {
        boolean sent = false;
        for (Order order : service.getOrders()) {
            for (Product product : productList) {
                if (order.getProduct().equals(product)) {
                    System.out.println(name + " sent product " + product.getProductName() + " in the amount of " + product.getProductQuantity() + " to " + order.getBuyer());
                    order.setCompleted();
                    sent = true;
                }
            }
        }
        return sent;
    }
}
