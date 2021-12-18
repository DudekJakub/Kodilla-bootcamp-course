package SpingTestowanko;

public class CalculatorTestowy {

    private DisplayTestowy displayTestowy = new DisplayTestowy();

    public double add(double a, double b) {
        double result = a + b;
        displayTestowy.DisplayResult(result);
        return result;
    }
}
