package com.kodilla.patterns.factory;

public final class Rectangle implements Shape {

    private final String name;
    private final double width;
    private final double lenght;

    public Rectangle(final String name, final double width, final double lenght) {
        this.name = name;
        this.width = width;
        this.lenght = lenght;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return width * lenght;
    }

    @Override
    public double getCircumference() {
        return 2 * width + 2 * lenght;
    }
}
