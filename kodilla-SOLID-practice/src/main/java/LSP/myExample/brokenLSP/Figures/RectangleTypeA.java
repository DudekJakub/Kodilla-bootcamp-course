package LSP.myExample.brokenLSP.Figures;

public class RectangleTypeA extends Rectangle {

    @Override
    public String render() {
        return super.render() + " of type " + RectangleTypeA.class.getSimpleName();
    }
}
