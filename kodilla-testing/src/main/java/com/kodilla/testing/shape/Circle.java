package com.kodilla.testing.shape;

public class Circle implements Shape {

    String shapeName = "Circle";
    double field;

    public Circle(double circleRadius){
        this.shapeName = shapeName;
        this.field = 3.14 * (circleRadius * circleRadius);
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
