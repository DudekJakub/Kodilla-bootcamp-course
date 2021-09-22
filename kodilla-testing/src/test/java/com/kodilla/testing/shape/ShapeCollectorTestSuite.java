package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforAllTests() {
        System.out.println("This is the beggining of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Prepering to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for figures")
    class TestFigures {

        @Test
        void testAddFigure() {
            //Given
            square square = new square(5);
            Circle circle = new Circle(5);
            Triangle triangle = new Triangle(5,5);

            ShapeCollector testList = new ShapeCollector(new ArrayList<Shape>(Arrays.asList(square, circle)));

            //When
            testList.addFigure(triangle);

            //Then
            Assertions.assertEquals(3, testList.getShapeList().size());
        }

        @Test
        void testRemoveFigure() {
            //Given
            square square = new square(5);
            Circle circle = new Circle(5);
            Triangle triangle = new Triangle(5,5);

            ShapeCollector testList = new ShapeCollector(new ArrayList<Shape>(Arrays.asList(triangle, square, circle)));

            //When
            testList.removeFigure(square);

            //Then
            Assertions.assertEquals(2, testList.getShapeList().size());
        }

        @Test
        void testGetFigure() {
            //Given
            square square = new square(5);
            Circle circle = new Circle(5);
            Triangle triangle = new Triangle(5,5);

            ArrayList<Shape> testList = new ArrayList<Shape>();
            testList.add(square);
            testList.add(circle);
            testList.add(triangle);

            ShapeCollector shapeCollector = new ShapeCollector(testList);

            //When
            shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(square, shapeCollector.getFigure(0));
            //System.out.println(shapeCollector.getFigure(0));
        }

        @Test
        void testShowFigures() {
            //Given
            square square = new square(5);
            Circle circle = new Circle(5);
            Triangle triangle = new Triangle(5,5);

            ArrayList<Shape> testList = new ArrayList<Shape>();
            testList.add(square);
            testList.add(triangle);
            testList.add(circle);

            ShapeCollector shapeCollector = new ShapeCollector(testList);

            //When
            ArrayList<Shape> retrievedList;
            retrievedList = shapeCollector.showFigures();

            //Then
            Assertions.assertEquals(testList, retrievedList);
        }
    }
}
