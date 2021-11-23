package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.ArrayList;
import java.util.List;

public class HealthyShop implements FoodProducer {

    private static final String name = "HealthyShop";
    private List<Product> productList = new ArrayList<Product>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public boolean process(Service service) {
        SendOrderService sendOrderService = new SendOrderService();
        return sendOrderService.isSent(name, service, productList);
    }
}
