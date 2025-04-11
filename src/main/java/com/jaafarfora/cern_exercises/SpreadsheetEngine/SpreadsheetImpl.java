package com.jaafarfora.cern_exercises.SpreadsheetEngine;

import java.util.Arrays;

public class SpreadsheetImpl {

    private String[][] sheet;

    public SpreadsheetImpl(int rows, int columns) {
        sheet = new String[rows][columns];
        for (String[] strings : sheet) {
            Arrays.fill(strings, "");
        }
    }

    public String get(int x, int y) {
        return this.sheet[x][y];
    }

    public void put(int x, int y, String value) {
        this.sheet[x][y] = value;
    }
}
