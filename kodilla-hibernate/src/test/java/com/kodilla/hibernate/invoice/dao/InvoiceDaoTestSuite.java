package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private InvoiceDao invoiceDao;


    @Test
    void testInvoiceDaoSave() {
        //Given
        Product xboxSeriesX = new Product("Xbox Series X");
        Product playstation5 = new Product("Playstation 5");
        Product diablo2 = new Product("Diablo2");
        Product heroes3 = new Product("Heroes3");

        Item item1 = new Item(10, new BigDecimal(2300));
        Item item2 = new Item(15, new BigDecimal(2400));
        Item item3 = new Item(100, new BigDecimal(99));
        Item item4 = new Item(57, new BigDecimal(69));

        xboxSeriesX.getItem().add(item1);
        playstation5.getItem().add(item2);
        diablo2.getItem().add(item3);
        heroes3.getItem().add(item4);

        Invoice invoice1 = new Invoice("001");
        Invoice invoice2 = new Invoice("002");

        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);
        item3.setInvoice(invoice2);
        item4.setInvoice(invoice2);

        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice2.getItems().add(item3);
        invoice2.getItems().add(item4);

        //When
        invoiceDao.save(invoice1);
        int id1 = invoice1.getId();

        invoiceDao.save(invoice2);
        int id2 = invoice2.getId();

        int quantity = item1.getQuantity();
        List<Item> readItems = itemDao.findByQuantity(quantity);

        //Then
        Assertions.assertNotEquals(0, id1);
        Assertions.assertNotEquals(0, id2);

        Assertions.assertEquals(2, invoice1.getItems().size());
        Assertions.assertEquals(1, readItems.size());

        //CleanUp
        invoiceDao.deleteById(id1);
        invoiceDao.deleteById(id2);
    }
}
