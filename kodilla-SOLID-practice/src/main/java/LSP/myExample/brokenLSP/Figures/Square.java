package LSP.myExample.brokenLSP.Figures;

public class Square extends Rectangle {

    @Override
    public String render() {
        return super.render() + " of type " + Square.class.getSimpleName();
    }

    @Override
    public double getLongerSide() {
        return super.getLongerSide();
    }

    @Override
    public void setLongerSide(double longerSide) {
        super.setLongerSide(longerSide);
        shorterSide = longerSide;
    }

    @Override
    public double getShorterSide() {
        return super.getShorterSide();
    }

    @Override
    public void setShorterSide(double shorterSide) {
        super.setShorterSide(shorterSide);
        longerSide = shorterSide;
    }

    @Override
    public double calculateArea() {
        return super.calculateArea();
    }
}
