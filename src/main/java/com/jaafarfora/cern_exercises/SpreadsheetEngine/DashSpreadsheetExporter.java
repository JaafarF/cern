package com.jaafarfora.cern_exercises.SpreadsheetEngine;

public class DashSpreadsheetExporter extends SpreadsheetExporter {

    public DashSpreadsheetExporter(SpreadsheetImpl sheet) {
        this.sheetToExport = sheet;
        SYMBOL = "-";
    }
}
