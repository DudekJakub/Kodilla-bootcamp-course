package com.kodilla.testing.shape;

public class Triangle implements Shape {

    String shapeName = "Triangle";
    double field;

    public Triangle(double baseSideLength, double height){
        this.shapeName = shapeName;
        this.field = (0.5 * baseSideLength) * height;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        return field;
    }

    @Override
    public String toString() {
        return  "shapeName='" + shapeName + '\'' +
                " - field=" + field;
    }
}
