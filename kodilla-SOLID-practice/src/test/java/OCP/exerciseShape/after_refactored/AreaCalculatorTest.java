package OCP.exerciseShape.after_refactored;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AreaCalculatorTest {

    @Test
    void calculateArea() {
        //Given
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(10));
        shapes.add(new Square(10));

        AreaCalculator areaCalculator = new AreaCalculator();

        //When
        double areaResult = areaCalculator.calculateArea(shapes);

        //Then
        assertEquals(414, areaResult, 1);
    }
}