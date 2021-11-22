package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.ArrayList;
import java.util.List;

public class GlutenFreeShop implements FoodProducer {

    private static final String name = "GlutenFreeShop";
    private List<Product> productList = new ArrayList<Product>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public boolean process(Service service) {
        return true;
    }
}
