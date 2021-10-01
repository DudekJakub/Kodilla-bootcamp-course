package com.kodilla.stream.sand;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class testGetSandBeansQuantityWithReduce {

    @Test
    void testGetSandBeansQuantityWithReduce() {
        //Given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Africa());
        continents.add(new Asia());

        //When
        BigDecimal totalSand = continents.stream()
                .map(SandStorage::getSandBeansQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        //Then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");
        Assertions.assertEquals(expectedSand,totalSand);
    }

}
