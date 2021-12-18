package SpringTestowanko;

import SpingTestowanko.CalculatorTestowy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTestowyTestSuite {

    @Test
    public void addTest() {
        //Given
        CalculatorTestowy calculatorTestowy = new CalculatorTestowy();

        //When
        double addResult = calculatorTestowy.add(5,5);

        //Then
        Assertions.assertEquals(10,addResult);
    }
}
