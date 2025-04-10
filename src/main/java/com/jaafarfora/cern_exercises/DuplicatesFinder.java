package com.jaafarfora.cern_exercises;

import java.util.*;

public class DuplicatesFinder<T> {
    public List<T> search(List<T> elements) {
        Set<T> found = new HashSet<>();
        Set<T> duplicates = new LinkedHashSet<>();
        if (elements == null || elements.size() < 2) {
            return new ArrayList<>();
        }
        for (T element : elements) {
            boolean isFirstTimeFound = found.add(element);
            if (!isFirstTimeFound) {
                duplicates.add(element);
            }
        }
        return new ArrayList<>(duplicates);
    }
}
