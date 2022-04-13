package com.kodilla.patterns.factory.shape;

public class Rectangle extends Shape {

    int x;
    int y;

    public Rectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String render() {
        return "This is rendered RECTANGLE at positions X = " + x + " & Y = " + y;
    }

    @Override
    public boolean isRendered() {
        return x>=0 && y>=0;
    }
}
