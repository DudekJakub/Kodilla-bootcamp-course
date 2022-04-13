package com.kodilla.patterns.factory.shape;

public class ShapeFactory {

    public Shape createShape(ShapeType shapeType, int x, int y) throws Exception {

        switch (shapeType) {
            case Circle:
                return new Circle(x, y);
            case Rectangle:
                return new Rectangle(x, y);
            case Triangle:
                return new Triangle(x, y);
            default:
                throw new Exception("Shape type " + shapeType + " is not present!");
        }
    }
}
