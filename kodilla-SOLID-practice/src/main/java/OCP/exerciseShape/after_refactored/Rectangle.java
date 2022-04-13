package OCP.exerciseShape.after_refactored;

public class Rectangle extends Shape {

    private final int sideA;
    private final int sideB;

    public Rectangle(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    protected double calculateArea() {
        return sideA * sideB;
    }

    public int getSideA() {
        return sideA;
    }

    public int getSideB() {
        return sideB;
    }
}
