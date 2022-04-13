package com.kodilla.patterns.factory.shape;

public class Circle extends Shape {

    int x;
    int y;

    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String render() {
        return "This is rendered CIRCLE at positions X = " + x + " & Y = " + y;
    }

    @Override
    public boolean isRendered() {
        return x >= 0 && y >= 0;
    }
}
