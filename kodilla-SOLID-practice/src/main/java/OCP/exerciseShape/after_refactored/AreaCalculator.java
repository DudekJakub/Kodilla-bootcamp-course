package OCP.exerciseShape.after_refactored;

import java.util.List;

public class AreaCalculator {

    public double calculateArea(List<Shape> shapes) {
        double area = 0;

        for (Shape shape : shapes) {
            area += shape.calculateArea();
        }
        System.out.println("Total area = " + area);
        return area;
    }
}
