package com.kodilla.patterns.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShapeFactoryTestSuite {

    @Test
    void testFactoryCircle() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape circle = factory.makeShape(ShapeFactory.CIRCLE);
        //Then
        Assertions.assertEquals(Math.PI * Math.pow(4.50, 2.0), circle.getArea(), 0);
        Assertions.assertEquals("The rounded circle", circle.getName());
    }

    @Test
    void testFactorySquare() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape square = factory.makeShape(ShapeFactory.SQUARE);
        //Then
        Assertions.assertEquals(28.0, square.getCircumference(), 0);
        Assertions.assertEquals("The angular square", square.getName());
    }

    @Test
    void testFactoryRectangle() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape rectangle = factory.makeShape(ShapeFactory.RECTANGLE);
        //Then
        Assertions.assertEquals(37.50, rectangle.getArea(), 0);
        Assertions.assertEquals("The long rectangle", rectangle.getName());
    }
}
