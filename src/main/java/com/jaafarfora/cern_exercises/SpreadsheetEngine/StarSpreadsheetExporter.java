package com.jaafarfora.cern_exercises.SpreadsheetEngine;

public class StarSpreadsheetExporter extends SpreadsheetExporter {

    public StarSpreadsheetExporter(SpreadsheetImpl sheet) {
        this.sheetToExport = sheet;
        SYMBOL = "*";
    }
}
