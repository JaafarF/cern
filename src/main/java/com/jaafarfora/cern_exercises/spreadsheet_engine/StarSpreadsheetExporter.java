package com.jaafarfora.cern_exercises.spreadsheet_engine;

public class StarSpreadsheetExporter extends SpreadsheetExporter {

    public StarSpreadsheetExporter(SpreadsheetImpl sheet) {
        this.sheetToExport = sheet;
        SYMBOL = "*";
    }
}
