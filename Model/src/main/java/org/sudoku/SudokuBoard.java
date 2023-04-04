package org.sudoku;

import com.google.common.base.Objects;


public class SudokuBoard {

    private SudokuField[][] classBoard;
    //I am using Backtracking algorithm to solve Sudoku.
    //TODO::REMEMBER, WE ARE USING NOT COPIED BOARD HERE
    private SudokuSolver sudokuSolver;

    public SudokuBoard(SudokuSolver sudokuSolver) {
       this.sudokuSolver = sudokuSolver;
       solveGame();
    }

    private void solveGame() {
        classBoard = new SudokuField[9][9];
        sudokuSolver.solve(this);
    }



    public boolean checkBoard() {
        for (int i = 0; i < 9; i++) {       //rows
            for (int j = 0; j < 9; j++) {
                for (int k = j + 1; k < 9; k++) {
                    if (classBoard[i][j] == classBoard[i][k]) {
                        System.out.println("rows");
                        return false;
                    }
                }
            }
        }


        for (int i = 0; i < 9; i++) {       //columns
            for (int j = 0; j < 9; j++) {
                for (int k = j + 1; k < 9; k++) {
                    if (classBoard[j][i] == classBoard[k][i]) {
                        System.out.println("columns");
                        return false;
                    }
                }
            }
        }
        //blocks
        int boxRowStart;
        int boxColStart;
        //TODO::My eyes are bleeding rn, but at least it works.

        for (int row = 0; row < 9; row += 3) {
            for (int column = 0; column < 9; column += 3) {
                boxRowStart = row - row % 3;
                boxColStart = column - column % 3;
                for (int r = boxRowStart; r < boxRowStart + 3; r++) {
                    for (int d = boxColStart; d < boxColStart + 3; d++) {
                        for (int k = r + 1; k < boxRowStart + 3; k++) {
                            for (int l = d + 1; l < boxColStart + 3; l++) {
                                if (classBoard[r][d] == classBoard[k][l]) {
                                    System.out.println("boxes" + boxRowStart + " " + boxColStart);
                                    System.out.println("boxes" + r + " " + d);

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
        return classBoard[row][column].getFieldValue();
    }

    public void setValue(int row, int column, int valueToSet) {
        classBoard[row][column].setFieldValue(valueToSet);
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
