package com.kodilla.patterns.factory.enemies;

public class SmallEnemyUnit extends AbstractEnemyUnit {

    protected SmallEnemyUnit(String name, String description, int price) {
        super(name, description, price);
    }

    @Override
    public void moveEnemyUnitOn(String x, String y) {
        super.moveEnemyUnitOn(x, y);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public char getSymbol() {
        return super.getSymbol();
    }

    @Override
    public String getType() {
        return super.getType();
    }
}
