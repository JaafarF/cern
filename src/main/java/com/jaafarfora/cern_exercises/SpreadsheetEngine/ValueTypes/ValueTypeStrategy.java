package com.jaafarfora.cern_exercises.SpreadsheetEngine.ValueTypes;

public interface ValueTypeStrategy {
    boolean matches(String value);
    ValueType getType();
}
