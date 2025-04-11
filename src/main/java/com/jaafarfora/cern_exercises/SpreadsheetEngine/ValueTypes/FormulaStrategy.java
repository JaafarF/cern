package com.jaafarfora.cern_exercises.SpreadsheetEngine.ValueTypes;

public class FormulaStrategy implements ValueTypeStrategy {
    @Override
    public boolean matches(String value) {
        return value != null && value.trim().startsWith("= ");
    }

    @Override
    public ValueType getType() {
        return ValueType.FORMULA;
    }
}
