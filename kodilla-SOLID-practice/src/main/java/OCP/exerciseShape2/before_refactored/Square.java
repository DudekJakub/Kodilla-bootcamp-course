package OCP.exerciseShape2.before_refactored;

public class Square extends Shape {
    private final int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }
}
