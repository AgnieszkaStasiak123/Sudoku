package org.sudoku;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuType implements Serializable,Cloneable {

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

    public List<SudokuField> getSudokuFieldList() {
        return new ArrayList<>(sudokuFields);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SudokuType that = (SudokuType) o;
        return Objects.equal(sudokuFields, that.sudokuFields);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sudokuFields);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("sudokuFields", sudokuFields)
                .toString();
    }
}
