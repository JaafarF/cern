package com.jaafarfora.cern_exercises.SpreadsheetEngine;

public class Office {
    public static SpreadsheetImpl newSpreadsheet(int rows, int columns) {
        return new SpreadsheetImpl(rows, columns);
    }
}
