package org.sudoku;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.util.Random;

public class BacktrackingSudokuSolver implements SudokuSolver, Serializable {


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

        for (int i = 1; i < 15; i++) {
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

    //BOARD[ROW][COLUMN]
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .toString();
    }
}
