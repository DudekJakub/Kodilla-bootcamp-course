package OCP.exerciseShape.before_refactored;

import java.util.List;

public class AreaCalculator {

    public double calculateArea(List<Shape> shapes) {

        double area = 0.0;
        for (Shape shape : shapes) {
            if (shape.getShapeType() == ShapeType.CIRCLE) {
                area += calculateCircleArea((Circle) shape);
            } else if (shape.getShapeType() == ShapeType.SQUARE) {
                area += calculateSquareArea((Square) shape);
            } else if (shape.getShapeType() == ShapeType.RECTANGLE) {
                area += calculateRectangleArea((Rectangle) shape);
            }
        }
        System.out.println("Total area = " + area);
        return area;
    }

    public double calculateSquareArea(Square square) {
        return square.getSide() * square.getSide();
    }

    public double calculateCircleArea(Circle circle) {
        return circle.getRadius() * Math.PI * circle.getRadius();
    }

    public double calculateRectangleArea(Rectangle rectangle) {
        return rectangle.getSideA() * rectangle.getSideB();
    }
}
