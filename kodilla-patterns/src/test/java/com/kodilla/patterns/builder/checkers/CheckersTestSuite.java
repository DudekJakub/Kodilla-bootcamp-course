package com.kodilla.patterns.builder.checkers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckersTestSuite {

    @Test
    void testCheckersBuilder() {
        //Given
        Checkers checkers = new Checkers.CheckersBuilder()
                .playerOne("Kuba")
                .playerTwo("Bartek")
                .Figure(FigureFactory.PAWN, Figure.WHITE, 3, 0)
                .Figure(FigureFactory.PAWN, Figure.BLACK, 7, 9)
                .Figure(FigureFactory.QUEEN, Figure.WHITE, 2, 0)
                .build();
        System.out.println(checkers.getBoard());

        //When
        Figure figureOne = checkers.getBoard().getFigure(3, 0);
        Figure figureTwo = checkers.getBoard().getFigure(7, 9);
        Figure figureThree = checkers.getBoard().getFigure(2, 0);
        Figure figureFour = checkers.getBoard().getFigure(1, 1);

        //Then
        Assertions.assertEquals(Figure.WHITE, figureOne.getColor());
        Assertions.assertEquals(Pawn.class, figureTwo.getClass());
        Assertions.assertEquals(Queen.class, figureThree.getClass());
        Assertions.assertNull(figureFour);
    }
}
