package com.kodilla.patterns.factory.shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeFactoryTestSuite2 {

    @Test
    public void testShapeFactoryCircle() throws Exception {
        //Given
        ShapeFactory shapeFactory = new ShapeFactory();

        //When
        Shape circle = shapeFactory.createShape(ShapeType.Circle, 1, 1);

        String renderResult = circle.render();

        //Then
        System.out.println(circle.getClass());

        assertEquals("This is rendered CIRCLE at positions X = 1 & Y = 1", renderResult);
        assertTrue(circle.isRendered());
    }

    @Test
    public void testShapeFactoryRectangle() throws Exception {
        //Given
        ShapeFactory shapeFactory = new ShapeFactory();

        //When
        Shape rectangle = shapeFactory.createShape(ShapeType.Rectangle, 2, 2);

        String renderResult = rectangle.render();

        //Then
        assertEquals("This is rendered RECTANGLE at positions X = 2 & Y = 2", renderResult);
        assertTrue(rectangle.isRendered());
    }

    @Test
    public void testShapeFactoryTriangle() throws Exception {
        //Given
        ShapeFactory shapeFactory = new ShapeFactory();

        //When
        Shape triangle = shapeFactory.createShape(ShapeType.Triangle, 3, 0);

        String renderResult = triangle.render();

        //Then
        assertEquals("This is rendered TRIANGLE at positions X = 3 & Y = 0", renderResult);
        assertTrue(triangle.isRendered());
    }

    @Test
    public void testShapeFactoryRhomboidThatIsntImplemented() throws Exception {
        //Given
        ShapeFactory shapeFactory = new ShapeFactory();

        //Then
        Throwable exception = assertThrows(Exception.class, () -> shapeFactory.createShape(ShapeType.Rhomboid, 10, 5));
        assertEquals("Shape type Rhomboid is not present!", exception.getMessage());
    }
}
