package com.kodilla.stream.invoice.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleInvoiceTestSuite {

    @Test
    void testGetValueToPay() {
        //Given
        SimpleInvoice invoice = new SimpleInvoice();

        //When
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 1", 17.28), 2.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 2", 11.99), 3.5));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 3", 6.49), 5.0));

        //Then
        Assertions.assertEquals(108.975, invoice.getValueToPay(), 0.001);
    }
}
