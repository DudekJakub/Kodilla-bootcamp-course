package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class TaxiOrderTestSuite {

    @Test
    public void testBasicTaxiOrderGetCost() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        Assertions.assertEquals(new BigDecimal("5.00"), calculatedCost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        //When
        String description = theOrder.getDiscription();
        //Then
        Assertions.assertEquals("Drive a course", description);
    }

    @Test
    public void testTaxiNetworkGetCost() {
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        //When
        BigDecimal calculatedCost = taxiOrder.getCost();
        //Then
        Assertions.assertEquals(new BigDecimal("40.00"), calculatedCost);
    }

    @Test
    public void testTaxiNetworkGetDescription() {
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        //When
        String description = taxiOrder.getDiscription();
        //Then
        Assertions.assertEquals("Drive a course by Taxi Network", description);
    }

    @Test
    public void testUberNetworkGetCost() {
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new UberNetworkOrderDecorator(taxiOrder);
        //When
        BigDecimal calculatedCost = taxiOrder.getCost();
        //Then
        Assertions.assertEquals(new BigDecimal("25.00"), calculatedCost);
    }

    @Test
    public void testUberNetworkGetDescription() {
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new UberNetworkOrderDecorator(taxiOrder);
        //When
        String description = taxiOrder.getDiscription();
        //Then
        Assertions.assertEquals("Drive a course by Uber Network", description);
    }

    @Test
    public void testMyTaxiNetworkGetCost() {
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        //When
        BigDecimal calculatedCost = taxiOrder.getCost();
        //Then
        Assertions.assertEquals(new BigDecimal("35.00"), calculatedCost);
    }

    @Test
    public void testMyTaxiNetworkGetDescription() {
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        //When
        String description = taxiOrder.getDiscription();
        //Then
        Assertions.assertEquals("Drive a course by MyTaxi Network", description);
    }

    @Test
    public void testChildSeatDecorator() {
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new UberNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        //When
        BigDecimal calculatedCost = taxiOrder.getCost();
        String description = taxiOrder.getDiscription();
        //Then
        Assertions.assertEquals(new BigDecimal("27.00"), calculatedCost);
        Assertions.assertEquals("Drive a course by Uber Network with child seat", description);
    }

    @Test
    public void testExpressDecorator() {
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new UberNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ExpressDecorator(taxiOrder);
        //When
        BigDecimal calculatedCost = taxiOrder.getCost();
        String description = taxiOrder.getDiscription();
        //Then
        Assertions.assertEquals(new BigDecimal("30.00"), calculatedCost);
        Assertions.assertEquals("Drive a course by Uber Network (express service)", description);
    }

    @Test
    public void testVipCarDecorator() {
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new UberNetworkOrderDecorator(taxiOrder);
        taxiOrder = new VipCarDecorator(taxiOrder);
        //When
        BigDecimal calculatedCost = taxiOrder.getCost();
        String description = taxiOrder.getDiscription();
        //Then
        Assertions.assertEquals(new BigDecimal("35.00"), calculatedCost);
        Assertions.assertEquals("Drive a course by Uber Network (variant VIP)", description);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        taxiOrder = new VipCarDecorator(taxiOrder);
        taxiOrder = new ExpressDecorator(taxiOrder);
        //When
        BigDecimal calculatedCost = taxiOrder.getCost();
        //Then
        Assertions.assertEquals(new BigDecimal("57.00"), calculatedCost);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {
        //Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        taxiOrder = new VipCarDecorator(taxiOrder);
        taxiOrder = new ExpressDecorator(taxiOrder);
        //When
        String description = taxiOrder.getDiscription();
        //Then
        Assertions.assertEquals("Drive a course by Taxi Network with child seat (variant VIP) (express service)", description);
    }
}
