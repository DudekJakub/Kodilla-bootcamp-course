package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Collection Test Suite: begin \n");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Collection  Test Suite: end \n-------------");
    }

    @BeforeEach
    public void before() {
        System.out.println("Collection Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Collection Test Case: end\n");
    }

    @DisplayName("Testing class that selects even numbers from the collection (useing empty collection)")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given (empty list)
        ArrayList<Integer> emptyList = new ArrayList<>();

        //When
        List<Integer> resultList = OddNumbersExterminator.exterminate(emptyList);
        System.out.println("Testing empty list...");
        System.out.println("ResultList: " + resultList);

        //Then
        Assertions.assertEquals(emptyList, resultList);
    }

    @DisplayName("Testing class that selects even numbers from the collection (useing normal collection)")
    @Test
    void testOddNumbersExterminatorNormalList() {

        //Given
        ArrayList<Integer> normalList = new ArrayList<>();
        normalList.add(1);
        normalList.add(2);
        normalList.add(3);
        normalList.add(4);
        normalList.add(5);
        normalList.add(6);
        normalList.add(7);
        normalList.add(8);
        normalList.add(9);
        normalList.add(10);

        ArrayList<Integer> expectedResultList = new ArrayList<>();
        expectedResultList.add(2);
        expectedResultList.add(4);
        expectedResultList.add(6);
        expectedResultList.add(8);
        expectedResultList.add(10);

        //When
        List<Integer> resultList = OddNumbersExterminator.exterminate(normalList);
        System.out.println("Testing normal list...");
        System.out.println("ResultList: " + resultList);

        //Then
        Assertions.assertEquals(expectedResultList, resultList);

    }
}
