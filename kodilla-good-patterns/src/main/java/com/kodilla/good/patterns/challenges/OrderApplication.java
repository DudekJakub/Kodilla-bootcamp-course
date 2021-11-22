package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderApplication {

    public static void main (String[] args) {

        InformationService informationService = new OrderInformationService();
        OrderService orderService = new ProductOrderService();
        OrderProcessor orderProcessor = new OrderProcessor(informationService, orderService);
        orderProcessor.process(new User("Jakub", "Dudek"), "GPU GTX 1070", 1, LocalDate.ofYearDay(2021, 254), true);

    }
}
