package com.jaafarfora.cern_exercises.spreadsheet_engine.ValueTypes;

public interface ValueTypeStrategy {
    boolean matches(String value);
    ValueType getType();
}
