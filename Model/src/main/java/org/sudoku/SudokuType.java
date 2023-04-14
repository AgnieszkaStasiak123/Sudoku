package org.sudoku;

public class SudokuType {

    private SudokuField[] sudokuFields = new SudokuField[9]; //It allways is gonna be 9 things.


    public SudokuType() {
        for (SudokuField field: sudokuFields) {
            field = new SudokuField();
        }
    }

    public SudokuField getType(int i) {
        return sudokuFields[i];
    }

    public void setToType(SudokuField[] sudokuFields) {
        this.sudokuFields = sudokuFields;
    }

    public boolean verify() {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sudokuFields[i].getFieldValue() == sudokuFields[j].getFieldValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}
