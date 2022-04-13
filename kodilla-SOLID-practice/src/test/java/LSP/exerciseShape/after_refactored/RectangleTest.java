package LSP.exerciseShape.after_refactored;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void setWidth_Rectangle() {
        //Given
        Rectangle rectangle = new Rectangle();

        //When
        rectangle.setWidth(10);
        rectangle.setHeight(9);

        //Then
        assertEquals(10, rectangle.getWidth());
        assertEquals(90, rectangle.getArea());
    }

    @Test
    void setWidth_Square() {
        //Given
        Square square = new Square();

        //When
        square.setSide(11);
        square.setSide(10);

        //Then
        assertEquals(10, square.getSide());
        assertEquals(100, square.getArea());
    }
}