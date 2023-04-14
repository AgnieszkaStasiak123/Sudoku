package org.sudoku;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SudokuTypeTest {

    SudokuBox box = new SudokuBox();

    @Test
    void setToTypeTest(){
        SudokuField[] fields = getInvalidFields();

        box.setToType(fields);

        for (int i = 0; i < 9; i++)
        {
            assertTrue(fields[i] == box.getType(i));
        }
    }

    @Test
    void verifyTest(){
        box.setToType(getInvalidFields());

        assertFalse(box.verify());

        box.setToType(getValidFields());

        assertTrue(box.verify());
    }

    @Test
    void observerTest() {
        box.setToType(getValidFields());

        assertTrue(box.getType(0).countObservers() == 0);
    }

    SudokuField[] getInvalidFields()
    {
        SudokuField[] fields = new SudokuField[9];

        for (int i = 0; i < 9; i++)
        {
            fields[i] = new SudokuField();
            fields[i].setFieldValue(i);
        }

        fields[5].setFieldValue(4);

        return fields;
    }

    SudokuField[] getValidFields()
    {
        SudokuField[] fields = new SudokuField[9];

        for (int i = 0; i < 9; i++)
        {
            fields[i] = new SudokuField();
            fields[i].setFieldValue(i);
        }

        return fields;
    }
}
