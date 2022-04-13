package LSP.exerciseShape.before_refactored;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void setWidth_Rectangle() {
        //Given
        Rectangle rectangle = new Rectangle();

        //When
        rectangle.setWidth(10);
        rectangle.setHeight(10);

        //Then
        assertEquals(10, rectangle.getWidth());
        assertEquals(100, rectangle.getArea());
    }

    @Test
    void setWidth_Square() {
        //Given
        Square square = new Square();

        //When
        square.setWidth(10);
        square.setHeight(9);

        //Then
        assertNotEquals(10, square.getWidth()); //!!!
        assertEquals(90, square.getArea());
    }
}