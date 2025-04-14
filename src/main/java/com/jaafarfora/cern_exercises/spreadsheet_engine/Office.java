package com.jaafarfora.cern_exercises.spreadsheet_engine;

public class Office {
    public static SpreadsheetImpl newSpreadsheet(int rows, int columns) {
        return new SpreadsheetImpl(rows, columns);
    }
}
