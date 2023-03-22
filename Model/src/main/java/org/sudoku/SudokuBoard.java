package org.sudoku;

import com.google.common.base.Objects;
import java.util.Random;


public class SudokuBoard {

    private int[][] classBoard;
    //I am using Backtracking algorithm to solve Sudoku.
    //TODO::REMEMBER, WE ARE USING NOT COPIED BOARD HERE


    public SudokuBoard() {
        classBoard = new int[9][9];
        fillBoard(classBoard);
    }

    private static boolean fillBoard(int [][] board) {
        Random random = new Random();
        int row = -1;
        int column = -1;
        boolean stillEmpty = true;
        int number = 0;


        //I'm checking if board is still not fully filled.

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
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
                board[row][column] = number;
                if (fillBoard(board)) {
                    return true;
                } else {
                    board[row][column] = 0;
                }
            }
        }

        return false;
    }

    //TODO::BOARD[ROW][COLUMN]
    private static boolean isSafe(int[][] board, int numberToFill, int row, int column) {
        for (int i = 0; i < 9; i++) {  //rows
            if (board[row][i] == numberToFill) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {  //columns
            if (board[i][column] == numberToFill) {
                return false;
            }
        }

        int boxRowStart = row - row % 3;
        int boxColStart = column - column % 3;

        for (int r = boxRowStart; r < boxRowStart + 3; r++) {
            for (int d = boxColStart; d < boxColStart + 3; d++) {
                if (board[r][d] == numberToFill) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkBoard() {
        for (int i = 0; i < 9; i++) {       //rows
            for (int j = 0; j < 9; j++) {
                for (int k = j + 1; k < 9; k++) {
                    if (classBoard[i][j] == classBoard[i][k]) {
                        return false;
                    }
                }
            }
        }


        for (int i = 0; i < 9; i++) {       //columns
            for (int j = 0; j < 9; j++) {
                for (int k = j + 1; k < 9; k++) {
                    if (classBoard[j][i] == classBoard[k][i]) {
                        return false;
                    }
                }
            }
        }
        //blocks
        int boxRowStart;
        int boxColStart;
        //TODO::My eyes are bleeding rn, but at least it works.

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column += 3) {
                boxRowStart = row - row % 3;
                boxColStart = column - column % 3;
                for (int r = boxRowStart; r < boxRowStart + 3; r++) {
                    for (int d = boxColStart; d < boxColStart + 3; d++) {
                        for (int k = r + 1; k < boxRowStart + 3; k++) {
                            for (int l = d + 1; l < boxRowStart + 3; l++) {
                                if (classBoard[r][d] == classBoard[k][l]) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }


        return true;
    }


    public int getValue(int row, int column) {
        return classBoard[row][column];
    }

    public void setValue(int row, int column, int valueToSet) {
        classBoard[row][column] = valueToSet;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                msg.append(classBoard[i][j]).append("  ");
            }
            msg.append("\n");
        }
        return msg.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SudokuBoard that = (SudokuBoard) o;
        return Objects.equal(classBoard, that.classBoard);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode((Object) classBoard);
    }
}
