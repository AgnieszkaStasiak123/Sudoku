package org.sudoku;

import com.google.common.base.Objects;
import java.util.Observable;
import java.util.Observer;


public class SudokuBoard implements Observer {

    private SudokuField[][] classBoard;
    //I am using Backtracking algorithm to solve Sudoku.
    //REMEMBER, WE ARE USING NOT COPIED BOARD HERE
    private SudokuSolver sudokuSolver;

    public SudokuBoard(SudokuSolver sudokuSolver) {
       this.sudokuSolver = sudokuSolver;
       solveGame();
    }

    private void solveGame() {
        classBoard = new SudokuField[9][9];
        //checkBoard();
        initializeArray();
        sudokuSolver.solve(this);
    }

    private void initializeArray() {
        for (int i = 0;  i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                classBoard[i][j] = new SudokuField();
                classBoard[i][j].addObserver(this);
            }
        }
    }


    public boolean checkBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!getBox(j, i).verify()) {
                    if (!(getRow(i).verify() && getColumn(i).verify()) || !getBox(j, i).verify()) {
                        return false;
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

    public SudokuRow getRow(int x) {
        SudokuRow row = new SudokuRow();
        SudokuField[] values = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            values[i] = classBoard[x][i];
        }
        row.setToType(values);

        return row;
    }

    public  SudokuColumn getColumn(int y) {
        SudokuColumn column = new SudokuColumn();
        SudokuField[] values = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            values[i] = classBoard[i][y];
        }
        column.setToType(values);
        return column;
    }

    public  SudokuBox getBox(int x, int y) {
        SudokuBox box = new SudokuBox();
        SudokuField[] values = new SudokuField[9];

        int squareStartRow = y - y % 3;
        int squareStartColumn = x - x % 3;

        int counter = 0;

        for (int i = squareStartColumn; i < squareStartColumn + 3; i++) {
            for (int j = squareStartRow; j < squareStartRow + 3; j++) {

                values[counter] = classBoard[j][i];

                counter++;
            }
        }

        box.setToType(values);
        return box;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                msg.append(classBoard[i][j].getFieldValue()).append("  ");
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

    @Override
    public void update(Observable o, Object arg) {
        checkBoard();
    }


}
