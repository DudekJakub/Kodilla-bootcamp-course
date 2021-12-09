package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BigmacTestSuite {

    private List<String> ingredientsResult = new ArrayList<>();

    @Test
    void testBigmacNew() {
        //Given
        Bigmac newBigmac = new Bigmac.BigmacBuilder()
                .bun(BigmacBun.WITHOUT_SESAME)
                .sauce("mild")
                .burgers(2)
                .ingredient("Cheese")
                .ingredient("Ham")
                .ingredient("Mushrooms")
                .ingredient("Onion")
                .ingredient("cucumber")
                .build();
        System.out.println(newBigmac);

        //When
        int bugersResult = newBigmac.getBurgers();
        ingredientsResult.addAll(newBigmac.getIngredients());

        //Then
        Assertions.assertEquals(2, bugersResult);
        Assertions.assertEquals(5, ingredientsResult.size());
    }
}
