package org.sudoku;

import java.util.List;

public class SudokuBox extends SudokuType {

    @Override
    protected Object clone() {
        SudokuField[] fields = new SudokuField[9];
        List<SudokuField> fields1 = getSudokuFieldList();

        for (int i = 0; i < fields.length; i++) {
            fields[i] = new SudokuField();
            fields[i].setFieldValue(fields1.get(i).getFieldValue());
        }

        SudokuBox box = new SudokuBox();
        box.setToType(fields);
        return box;
    }
}