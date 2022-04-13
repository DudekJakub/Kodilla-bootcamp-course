package LSP.myExample.brokenLSP.Figures;

public class Rectangle {

    protected double longerSide;
    protected double shorterSide;

    public String render() {
        return "This is rendered RECTANGLE with longer side = " + longerSide + " & shorter side = " + shorterSide;
    }

    public double getLongerSide() {
        return longerSide;
    }

    public void setLongerSide(double longerSide) {
        this.longerSide = longerSide;
    }

    public double getShorterSide() {
        return shorterSide;
    }

    public void setShorterSide(double shorterSide) {
        this.shorterSide = shorterSide;
    }

    public double calculateArea() {
        return longerSide * shorterSide;
    }
}
