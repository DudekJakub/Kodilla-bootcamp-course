package com.kodilla.stream.array;

import org.junit.jupiter.api.*;

public class ArrayOperationsTestSuite {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Array Operations Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Array Operations Test Suite: end");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Array Operations Test Case: begin\n");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("\nArray Operations Test Case: end");
    }

    @Test
    void testGetAverage() {
        //Given
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        //When
        double result = ArrayOperations.getAverage(array);

        //Then
        System.out.println("\n Result Average: " + result);
        Assertions.assertEquals(10.5, result);
    }
}
