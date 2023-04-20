package org.sudoku;

public class SudokuRow extends SudokuType {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SudokuField[] fields = new SudokuField[9];
        getSudokuFieldList().toArray(fields);
        SudokuRow row = new SudokuRow();
        row.setToType(fields);
        return row;
    }
}