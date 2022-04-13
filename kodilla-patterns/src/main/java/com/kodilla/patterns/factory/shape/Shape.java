package com.kodilla.patterns.factory.shape;

public abstract class Shape {

    public int x;
    public int y;

    public abstract String render();

    public abstract boolean isRendered();

    //+ gettery i settery

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
