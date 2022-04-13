package OCP.exerciseShape2.before_refactored;

import java.util.List;
import java.util.Optional;

public class ShapeAreaCalculator {

    public int calculateAreas(List<Shape> shapes) {
        for (Shape shape : shapes) {
            if (shape.getClass().getSimpleName().equals(ShapeType.CIRCLE.toString())) {
                return calculateCircleArea((Circle) shape);
            } else if (shape.getClass().getSimpleName().equals(ShapeType.SQUARE.toString())) {
                return calculateSquareArea((Square) shape);
            } else {
                return calculateRectangleArea((Rectangle) shape);
            }
        }
        return 0;
    }

    public int calculateCircleArea(Circle circle) {
        return circle.getRadius() * circle.getRadius() * (int)Math.PI;
    }

    public int calculateSquareArea(Square square) {
        return square.getSide() * square.getSide();
    }

    public int calculateRectangleArea(Rectangle rectangle) {
        return rectangle.getSideA() * rectangle.getSideB();
    }

//    public void renderCircleShape() {
//        System.out.println("Circle has been rendered!");
//    }
//
//    public void renderSquareShape() {
//        System.out.println("Square has been rendered!");
//    }
//
//    public void renderRectangleShape() {
//        System.out.println("Rectangle has been rendered!");
//    }
}
