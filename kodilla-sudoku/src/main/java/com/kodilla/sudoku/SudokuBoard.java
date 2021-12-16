package com.kodilla.sudoku;

public class SudokuBoard {

    private static int BOARD_RANGE = 9;

    int[][] board = {
            {7,0,2,0,5,0,6,0,0},
            {0,0,0,0,0,3,0,0,0},
            {1,0,0,0,0,9,5,0,0},
            {8,0,0,0,0,0,0,9,0},
            {0,4,3,0,0,0,7,5,0},
            {0,9,0,0,0,0,0,0,8},
            {0,0,9,7,0,0,0,0,5},
            {0,0,0,2,0,0,0,0,0},
            {0,0,7,0,4,0,2,0,3}
    };

    public int[][] getBoard() {
        return board;
    }

    public static void printBoard(int[][] board) {
        for (int row=0; row<BOARD_RANGE; row++) {
            if (row == 3) {
                System.out.println("-----------");
            } else if (row == 6) {
                System.out.println("-----------");
            }
                for (int column = 0; column < BOARD_RANGE; column++) {
                    System.out.print(board[row][column]);
                    if (column == 2) {
                        System.out.print("|");
                    } else if (column == 5) {
                        System.out.print("|");
                    }
                }
            System.out.println();
        }
    }
}
