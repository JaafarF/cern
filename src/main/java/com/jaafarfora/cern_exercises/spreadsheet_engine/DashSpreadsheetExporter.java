package com.jaafarfora.cern_exercises.spreadsheet_engine;

public class DashSpreadsheetExporter extends SpreadsheetExporter {

    public DashSpreadsheetExporter(SpreadsheetImpl sheet) {
        this.sheetToExport = sheet;
        SYMBOL = "-";
    }
}
