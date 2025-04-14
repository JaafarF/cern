package com.jaafarfora.cern_exercises.spreadsheet_engine;

import com.jaafarfora.cern_exercises.spreadsheet_engine.ValueTypes.*;

import java.util.Arrays;
import java.util.List;

public class SpreadsheetImpl {

    private final String[][] sheet;
    private final List<ValueTypeStrategy> strategies;


    public SpreadsheetImpl(int rows, int columns) {
        sheet = new String[rows][columns];
        for (String[] strings : sheet) {
            Arrays.fill(strings, "");
        }
        this.strategies = List.of(
            new FormulaStrategy(),
            new IntegerStrategy(),
            new StringStrategy()
        );
    }

    public String get(int x, int y) {
        String value = sheet[x][y];
        if (getTypeByValue(value).equals(ValueType.INTEGER)) {
            value = value.trim();
        }
        return value;
    }

    public void put(int x, int y, String value) {
        this.sheet[x][y] = value;
    }

    public ValueType getValueType(int x, int y) {
        String value = this.get(x, y);
        return getTypeByValue(value);
    }

    private ValueType getTypeByValue(String value) {
        for (ValueTypeStrategy strategy : strategies) {
            if (strategy.matches(value)) {
                return strategy.getType();
            }
        }
        throw new IllegalStateException("No matching strategy found.");
    }

    /*public void print() {
        for (String[] strings : sheet) {
            System.out.println(Arrays.toString(strings));
        }
    }*/
}
