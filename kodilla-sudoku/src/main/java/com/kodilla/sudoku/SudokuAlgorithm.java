package com.kodilla.sudoku;

public class SudokuAlgorithm {

    int BOARD_RANGE = 9;

    public boolean isRowFilled(int[][] board, int row, int number) {
        for (int i=0; i<BOARD_RANGE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    public boolean isColumnFilled(int[][] board, int column, int number) {
        for (int i=0; i<BOARD_RANGE; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    public boolean isNumberInBox(int[][] board, int row, int column, int number) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;

        for (int i = localBoxRow; i<localBoxRow+3; i++) {
            for (int j=localBoxColumn; j<localBoxColumn+3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canPlaceNumber(int[][] board, int row, int column, int number) {
        return !isRowFilled(board, row, number) && !isColumnFilled(board, column, number) && !isNumberInBox(board, row, column, number);
    }

    public boolean solveBoard(int[][] board) {
        for (int row=0; row<BOARD_RANGE; row++) {
            for (int column=0; column<BOARD_RANGE; column++) {
                if (board[row][column] == 0) {
                    for (int numberToTry=1; numberToTry<=BOARD_RANGE; numberToTry++) {
                        if(canPlaceNumber(board, numberToTry, row, column)) {
                            board[row][column] = numberToTry;

                            if(solveBoard(board)) {
                                return true;
                            } else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
