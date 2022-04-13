package LSP.exerciseShape.before_refactored;

public class Square extends Rectangle {

    @Override
    public void setWidth(int width) {
        width = width;
        height = width;
    }

    @Override
    public void setHeight(int height) {
        width = height;
        height = height;
    }
}
