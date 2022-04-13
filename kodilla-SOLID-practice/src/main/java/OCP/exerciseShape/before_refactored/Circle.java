package OCP.exerciseShape.before_refactored;

public class Circle extends Shape {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
        shapeType = ShapeType.CIRCLE;
    }

    public double getRadius() {
        return radius;
    }
}
