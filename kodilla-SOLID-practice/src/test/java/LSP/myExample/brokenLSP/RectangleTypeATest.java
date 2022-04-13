package LSP.myExample.brokenLSP;

import LSP.myExample.brokenLSP.Figures.Rectangle;
import LSP.myExample.brokenLSP.Figures.RectangleTypeA;
import LSP.myExample.brokenLSP.Figures.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTypeATest {

    @Test
    public void testLiskovPrinciple() {
        //Given
        Rectangle rectangle = new Rectangle();
        Rectangle rectangleTypeA = new RectangleTypeA();
        Rectangle square = new Square();

        //When
        rectangle.setLongerSide(11);
        rectangle.setShorterSide(10);

        double rectangleLongerSide = rectangle.getLongerSide();
        double rectangleShorterSide = rectangle.getShorterSide();
        double rectangleArea = rectangle.calculateArea();

        rectangleTypeA.setLongerSide(10);
        rectangleTypeA.setShorterSide(9);

        double rectangleTypeA_LongerSide = rectangleTypeA.getLongerSide();
        double rectangleTypeA_ShorterSide = rectangleTypeA.getShorterSide();
        double rectangleTypeA_Area = rectangleTypeA.calculateArea();

        square.setLongerSide(20);
        square.setShorterSide(10);
        double squareLongerSide = square.getLongerSide();
        double squareShorterSide = square.getShorterSide();

        //Then
        assertEquals(11, rectangleLongerSide);
        assertEquals(10, rectangleShorterSide);
        assertEquals(110, rectangleArea);

        assertEquals(10, rectangleTypeA_LongerSide);
        assertEquals(9, rectangleTypeA_ShorterSide);
        assertEquals(90, rectangleTypeA_Area);

        assertEquals(20, squareLongerSide);
        assertEquals(10, squareShorterSide);

        System.out.println(rectangle.render());
        System.out.println(rectangleTypeA.render());
        System.out.println(square.render());
    }
}