package org.sudoku;

import java.util.Observable;

public class SudokuField extends Observable {

    private int value;

    public int getFieldValue() {
        return value;
    }

    public void setFieldValue(int value) {

        this.value = value;
        setChanged();
        notifyObservers(value);
    }
}
