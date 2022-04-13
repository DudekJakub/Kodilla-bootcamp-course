package LSP.exerciseShape.after_refactored;

public class Square {
    public int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }
}
