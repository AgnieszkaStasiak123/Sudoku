package org.sudoku;

import java.util.ListResourceBundle;

public class Language_pl extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"_classError", "Nie znaleziono klasy."},
            {"_fileError", "Blad wejscia, wyjscia."},
            {"_dataBaseExc", "Błąd bazy danych."},
            {"_duplicateFileExc", "Prawdopodobienstwo duplikatu."}
        };
    }
}
