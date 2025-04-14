package com.jaafarfora.cern_exercises.spreadsheet_engine.ValueTypes;

public class StringStrategy implements ValueTypeStrategy {
    @Override
    public boolean matches(String value) {
        return true;
    }

    @Override
    public ValueType getType() {
        return ValueType.STRING;
    }
}
