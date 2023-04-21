package org.sudoku;

public class SudokuColumn extends SudokuType {

    @Override
    protected Object clone() {
        SudokuField[] fields = new SudokuField[9];
        getSudokuFieldList().toArray(fields);
        SudokuColumn clm = new SudokuColumn();
        clm.setToType(fields);
        return clm;
    }
}