package org.sudoku;

import java.util.Random;

public class BacktrackingSudokuSolver implements SudokuSolver {

    @Override
    public void solve(SudokuBoard sudokuBoard) {
        solveBacktracking(sudokuBoard);
    }

    public boolean solveBacktracking(SudokuBoard board) {
        Random random = new Random();
        int row = -1;
        int column = -1;
        boolean stillEmpty = true;
        int number = 0;


        //I'm checking if board is still not fully filled.

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getValue(i,j) == 0) {
                    row = i;
                    column = j;
                    stillEmpty = false;
                    break;
                }
            }
            if (!stillEmpty) {
                break;
            }
        }
        if (stillEmpty) {
            return true;
        }

        for (int i = 1; i < 15; i++) { //TODO::I don't like this for, think about sth better.
            number = random.nextInt(9) + 1;
            if (isSafe(board, number, row, column)) {
                board.setValue(row,column, number);
                if (solveBacktracking(board)) {
                    return true;
                } else {
                    board.setValue(row,column, 0);
                }
            }
        }

        return false;
    }

    //TODO::BOARD[ROW][COLUMN]
    private static boolean isSafe(SudokuBoard board, int numberToFill, int row, int column) {
        for (int i = 0; i < 9; i++) {  //rows
            if (board.getValue(row,i) == numberToFill) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {  //columns
            if (board.getValue(i,column) == numberToFill) {
                return false;
            }
        }

        int boxRowStart = row - row % 3;
        int boxColStart = column - column % 3;

        for (int r = boxRowStart; r < boxRowStart + 3; r++) {
            for (int d = boxColStart; d < boxColStart + 3; d++) {
                if (board.getValue(r,d) == numberToFill) {
                    return false;
                }
            }
        }

        return true;
    }
}
