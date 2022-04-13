package com.kodilla.patterns.factory.enemies;

import java.util.Scanner;

public class mainGameBoard {

    private static String[][] board ={
        {"x","x","x"},
        {"x","x","x"},
        {"x","x","x"}
    };

    String[][] getBoard() {
        return board;
    }

    public static void main(String[] args) {

        EnemyFactory enemyFactory = new EnemyFactory();

        mainGameBoard.copyOfBoard(board);

        Scanner scanner = new Scanner(System.in);
        String unitType;

        System.out.println("\n\nWhat type of unit do You want to create? \n Type: \n s - for small unit \n m - for medium unit \n b - for boss unit");

        while (true) {
            unitType = scanner.nextLine();
            if (unitType.equals("s") || unitType.equals("m") || unitType.equals("b")) {
                letPlayerToChoiceUnit(unitType,enemyFactory);
                break;
            } else {
                System.out.println("Wrong unit symbol! Please make choice between 's' / 'm' / 'b' !");
                continue;
            }
        }

    }

    public static void makeMove(AbstractEnemyUnit abstractEnemyUnit) {
        Scanner scanner = new Scanner(System.in);

        String moveX;
        String moveY;

        System.out.println("\n X_position [0/1/2] = ");
        while (true) {
            moveX = scanner.nextLine();
            if (moveX.equals("0") || moveX.equals("1") || moveX.equals("2")) {
                break;
            } else {
                System.out.println("You must chose X position in range of 0 - 2 !");
            }
        }
        System.out.println("\n Y_position [0/1/2] = ");
        while (true) {
            moveY = scanner.nextLine();
            if (moveY.equals("0") || moveY.equals("1") || moveY.equals("2")) {
                break;
            } else {
                System.out.println("You must chose Y position in range of 0 - 2 !");
            }
        }
        abstractEnemyUnit.moveEnemyUnitOn(moveX, moveY);
    }

    public static String letPlayerToChoiceUnit(String unitType, EnemyFactory enemyFactory) {

        AbstractEnemyUnit abstractEnemyUnit;

        switch (unitType) {
            case "s":
                printPlayerUniteChoice("s");
                abstractEnemyUnit = enemyFactory.makeEnemyUnit("s");
                makeMove(abstractEnemyUnit);
                return "s";
            case "m":
                printPlayerUniteChoice("m");
                abstractEnemyUnit = enemyFactory.makeEnemyUnit("m");
                makeMove(abstractEnemyUnit);
                return "m";
            case "b":
                printPlayerUniteChoice("b");
                abstractEnemyUnit = enemyFactory.makeEnemyUnit("b");
                makeMove(abstractEnemyUnit);
                return "b";
        }
        return "";
    }

    public static void printPlayerUniteChoice(String unitType) {
        switch (unitType) {
            case "s":
                System.out.println("You have chosen small unit. Where do You want to start? Place some spot on board -> [x][y] -> both max 3");
                break;
            case "m":
                System.out.println("You have chosen medium unit. Where do You want to start? Place some spot on board -> [x][y] -> both max 3");
                break;
            case "b":
                System.out.println("You have chosen boss unit. Where do You want to start? Place some spot on board -> [x][y] -> both max 3");
                break;
        }
    }

    public static void copyOfBoard(String[][] board) {
        for (int row = 0; row < board.length; row++) {
            if (row == 1 || row == 2) {
                System.out.println("\n----");
            }
            for (int column = 0; column < board.length; column++) {
                if (column == 1 || column == 2) {
                    System.out.print("|");
                }
                System.out.print(board[row][column]);
            }
        }
    }
}
