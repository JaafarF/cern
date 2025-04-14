package com.jaafarfora.cern_exercises.spreadsheet_engine.ValueTypes;

public class IntegerStrategy implements ValueTypeStrategy {
    @Override
    public boolean matches(String value) {
        if (value == null) return false;
        value = value.trim();
        try {
            Integer.parseInt(value.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public ValueType getType() {
        return ValueType.INTEGER;
    }

}
