package LSP.myExample.brokenLSP.Animals;

import jdk.jshell.spi.ExecutionControl;

public abstract class Bird extends Animal {

    protected Bird(int height, int weight) {
        super(height, weight);
    }

    @Override
    protected int getSize() {
        return height * weight;
    }

    @Override
    protected void breath() {
        System.out.println("This bird is breathing...");
    }

    @Override
    protected void fly() {
        System.out.println("This bird is flying...");
    }

    @Override
    protected void setHeight(int height) {
        this.height = height;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    protected void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    protected int getWeight() {
        return weight;
    }
}
