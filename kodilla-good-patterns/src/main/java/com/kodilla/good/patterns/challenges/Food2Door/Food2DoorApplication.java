package com.kodilla.good.patterns.challenges.Food2Door;

public class Food2DoorApplication {

    public static void main(String[] args) {
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();

        ExpeditionService expeditionService = new ExpeditionService();

        Product Milk = new Product("Milk Bottle", 10);
        Product FruitPackage = new Product("FruitPackage", 1);

        Buyer Jakub = new Buyer("Jakub Dudek", "Poznań", "Os. Zwycięstwa", "60-668", "29/2");

        extraFoodShop.addProduct(Milk);
        extraFoodShop.addProduct(FruitPackage);
        expeditionService.addNewOrder(Jakub, Milk);
        expeditionService.addNewOrder(Jakub, FruitPackage);
        extraFoodShop.process(expeditionService);

        System.out.println("\nLista produktów ze sklepu ExtraFoodShop: " + extraFoodShop.getProductList());
        System.out.println("\nLista nieukończonych zamówień: " + expeditionService.getUncompletedOrders());
        System.out.println("\nLista ukończonych zamówień:  " + expeditionService.getCompletedOrders());
    }
}
