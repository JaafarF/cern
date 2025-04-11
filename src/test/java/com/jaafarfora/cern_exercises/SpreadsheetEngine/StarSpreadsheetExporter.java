package com.jaafarfora.cern_exercises.SpreadsheetEngine;

public class StarSpreadsheetExporter {
    SpreadsheetImpl sheetToExport;
    private static final  char SYMBOL = '*';
    public static final int ROWS = 10;
    public static final int COLUMNS = 5;

    public StarSpreadsheetExporter(SpreadsheetImpl sheet) {
        this.sheetToExport = sheet;
    }

    public String export() {
        StringBuilder sheetContent = new StringBuilder(ROWS + "," + COLUMNS + "#");
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                String value = this.sheetToExport.get(row, col);
                sheetContent.append(value.isEmpty() ? SYMBOL : value);
                if (!value.isEmpty()) {
                    sheetContent.append(SYMBOL);
                }
            }
        }
        return sheetContent.toString();
    }
}
