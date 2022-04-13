package OCP.exerciseShape.before_refactored;

public class Square extends Shape {

    private final double side;

    public Square(double side) {
        this.side = side;
        shapeType = ShapeType.SQUARE;
    }

    public double getSide() {
        return side;
    }
}
