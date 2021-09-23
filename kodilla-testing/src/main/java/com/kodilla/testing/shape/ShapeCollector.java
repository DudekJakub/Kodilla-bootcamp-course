package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> shapeList = new ArrayList<Shape>();

    public ShapeCollector(ArrayList<Shape> shapeList){
        this.shapeList = shapeList;
    }

    @Override
    public String toString() {
        return "ShapeCollector:" +
                "shapeList=" + shapeList;
    }

    public ArrayList<Shape> getShapeList() {
        return shapeList;
    }

    public void addFigure(Shape shape){
        shapeList.add(shape);
    }

    public void removeFigure(Shape shape){
        shapeList.remove(shape);
    }

    public Shape getFigure(int n) {
        if (n >= 0 && n < shapeList.size()) {
            return shapeList.get(n);
        } else {
            return null;
        }
    }

    public ArrayList<Shape> showFigures() {
        for (Shape figures : shapeList) {
            //System.out.println(figures);
        }
        return shapeList;
    }
}
