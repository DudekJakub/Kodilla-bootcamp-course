package OCP.exerciseShape.before_refactored;

public class Rectangle extends Shape {

    private final int sideA;
    private final int sideB;

    public Rectangle(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
        shapeType = ShapeType.RECTANGLE;
    }

    public int getSideA() {
        return sideA;
    }

    public int getSideB() {
        return sideB;
    }
}
