package com.jaafarfora.cern_exercises;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesFinder {
    public List<String> search(List<String> elements) {
        List<String> duplicates = new ArrayList<>();
        if (elements == null || elements.size() < 2) {
            return duplicates;
        }
        for (int i = 0; i < elements.size(); i++) {
            if (!duplicates.contains(elements.get(i))) {
                for (int j = i + 1; j < elements.size(); j++) {
                    if (elements.get(i).equals(elements.get(j))) {
                        duplicates.add(elements.get(i));
                        break;
                    }
                }
            }
        }
        return duplicates;
    }
}
