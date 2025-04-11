package com.jaafarfora.cern_exercises.SpreadsheetEngine;

import com.jaafarfora.cern_exercises.SpreadsheetEngine.ValueTypes.ValueType;

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

    public ValueType getValueType(int x, int y) {
        String value = this.get(x, y).trim();
        if (value.startsWith("= ")) {
            return ValueType.FORMULA;
        }
        try {
            Integer.parseInt(value);
            return ValueType.INTEGER;
        } catch (NumberFormatException _) {}

        return ValueType.STRING;
    }
}
