package com.kodilla.patterns.factory.enemies;

public interface EnemyBehaviourScheme {

    void moveEnemyUnitOn(String x, String y);
    String getDescription();
    String getName();
    String getType();
    char getSymbol();
    int getPrice();
}
