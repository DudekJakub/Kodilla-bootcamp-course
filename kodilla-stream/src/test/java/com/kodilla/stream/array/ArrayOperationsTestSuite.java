package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        Random random = new Random();

        int[] array = new int[20];
        for (int n = 0; n < array.length; n++) {
            array[n] = random.nextInt(10);
        }

        //When
        double expected = 0;
        for (int n = 0; n < array.length; n++) {
            expected = expected + array[n];
        }

        expected = expected / array.length;
        double result = ArrayOperations.getAverage(array);

        //Then
        System.out.println("\n Expected average: " + expected);
        System.out.println("\n Result Average: " + result);

        Assertions.assertEquals(expected, result);
    }
}
