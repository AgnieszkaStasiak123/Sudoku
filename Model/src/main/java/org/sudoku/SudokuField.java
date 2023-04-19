package org.sudoku;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.util.Observable;

public class SudokuField extends Observable implements Serializable {

    private int value;

    public int getFieldValue() {
        return value;
    }

    public void setFieldValue(int value) {

        this.value = value;
        setChanged();
        notifyObservers(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SudokuField field = (SudokuField) o;
        return value == field.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("value", value)
                .toString();
    }
}
