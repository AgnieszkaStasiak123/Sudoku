package org.sudoku;

import java.util.ListResourceBundle;

public class Language_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"_classError", "Class not found."},
                {"_fileError", "Input, output error."},
                {"_dataBaseExc", "Database error."},
                {"_duplicateFileExc", "Possible duplicate."}
        };
    }
}
