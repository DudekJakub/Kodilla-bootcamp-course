package com.kodilla.testing.shape;

public class square implements Shape{

    String shapeName = "Square";
    double field;

    public square(double sideLength){
        this.shapeName = shapeName;
        this.field = sideLength * sideLength;
    }

    public String getShapeName(){
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
