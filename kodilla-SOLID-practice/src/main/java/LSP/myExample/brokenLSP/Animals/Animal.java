package LSP.myExample.brokenLSP.Animals;

public abstract class Animal {
    protected int height;
    protected int weight;

    protected Animal(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    protected abstract void breath();
    protected abstract void fly();
    protected abstract void swim();
    protected abstract void setHeight(int height);
    protected abstract int getHeight();
    protected abstract void setWeight(int weight);
    protected abstract int getWeight();
    protected abstract int getSize();
}
