package com.kodilla.patterns.factory.enemies;

import org.junit.jupiter.api.Test;

public class EnemiesFactoryTestSuite {

    @Test
    public void testSmallEnemyUnitCreation() {
        //Given
        String[] gameBoard = new String[] {"x", "x", "x"};

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                System.out.print(gameBoard[j]);
            }
        }
    }
}
