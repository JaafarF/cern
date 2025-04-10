package com.jaafarfora.cern_exercises;

import java.util.*;

public class DuplicatesFinder {
    public List<String> search(List<String> elements) {
        Set<String> found = new HashSet<>();
        Set<String> duplicates = new LinkedHashSet<>();
        if (elements == null || elements.size() < 2) {
            return new ArrayList<>();
        }
        for (String element : elements) {
            boolean isFirstTimeFound = found.add(element);
            if (!isFirstTimeFound) {
                duplicates.add(element);
            }
        }
        return new ArrayList<>(duplicates);
    }
}
