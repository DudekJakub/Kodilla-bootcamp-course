package com.kodilla.patterns.factory.enemies;

import java.nio.charset.StandardCharsets;

public abstract class AbstractEnemyUnit implements EnemyBehaviourScheme {

    private final String type;
    private final String name;
    private final String description;
    private final int price;
    private final char symbol;
    private final mainGameBoard mainGameBoard = new mainGameBoard();

    protected AbstractEnemyUnit(String name, String description, int price) {
        this.type = this.getClass().getSimpleName();
        this.name = name;
        this.description = description;
        this.price = price;
        this.symbol = name.charAt(0);

        System.out.println("Type: [" + type + "] Name: [" + name + "] | Description: [" + description + "] It costs: [" + price + "]");
    }

    @Override
    public void moveEnemyUnitOn(String x, String y) {
        System.out.println(name + " moved on: x = " + x + " | y = " + y);

        String[][] actualBoard = mainGameBoard.getBoard();
        actualBoard[Integer.parseInt(x)][Integer.parseInt(y)] = String.valueOf(symbol);

        mainGameBoard.copyOfBoard(actualBoard);
    }


    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public String getType() {
        return type;
    }
}
