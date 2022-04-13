package LSP.myExample.brokenLSP.Animals;

import jdk.jshell.spi.ExecutionControl;

public class Eagle extends Bird{

    protected Eagle(int height, int weight) {
        super(height, weight);
    }

    @Override
    protected int getSize() {
        return super.getSize();
    }

    @Override
    protected void swim() {
        throw new RuntimeException("Eagle cannot swim!");
    }
}
