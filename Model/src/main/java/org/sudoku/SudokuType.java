package org.sudoku;

import java.util.Arrays;
import java.util.List;

public class SudokuType {

    private List<SudokuField> sudokuFields = Arrays.asList(new SudokuField[9]);

    public SudokuType() {
        sudokuFields.replaceAll(ignored -> new SudokuField());
    }

    public SudokuField getType(int i) {
        return sudokuFields.get(i);
    }

    public void setToType(SudokuField[] sudokuFields) {
        this.sudokuFields = List.of(sudokuFields);
    }

    public boolean verify() {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sudokuFields.get(i).getFieldValue() == sudokuFields.get(j).getFieldValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}
