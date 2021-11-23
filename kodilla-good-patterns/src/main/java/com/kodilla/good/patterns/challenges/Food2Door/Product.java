package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.Objects;

public class Product {

    private String productName;
    private int productQuantity;

    public Product(String productName, int productQuantity) {
        this.productName = productName;
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return productQuantity == product.productQuantity && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productQuantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
