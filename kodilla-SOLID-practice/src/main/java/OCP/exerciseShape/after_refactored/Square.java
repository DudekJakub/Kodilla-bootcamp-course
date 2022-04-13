package OCP.exerciseShape.after_refactored;

public class Square extends Shape {

    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    protected double calculateArea() {
        return side * side;
    }

    public double getSide() {
        return side;
    }
}
