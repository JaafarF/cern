package com.jaafarfora.cern_exercises;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DuplicatesFinderTest {

    private final DuplicatesFinder duplicatesFinder = new DuplicatesFinder();

    static Stream<Arguments> nullEmptyAndOneElementLists() {
        return Stream.of(
            Arguments.of((List<String>) null),
            Arguments.of(List.of()),
            Arguments.of(List.of("r"))
        );
    }

    @ParameterizedTest
    @MethodSource("nullEmptyAndOneElementLists")
    void null_empty_and_one_element_list_should_return_empty_result(List<String> input) {
        // When
        List<String> result = duplicatesFinder.search(input);
        // Then
        assertThat(result).isEmpty();
    }

    @Test
    void should_return_list_with_duplicates() {
        // Given
        List<String> stringList = List.of("a", "w", "r", "w", "e", "w", "r");
        // When
        List<String> results = duplicatesFinder.search(stringList);
        System.out.println(results);
        // Then
        assertThat(results.size()).isEqualTo(2);
        assertThat(results.getFirst()).isEqualTo("w");
        assertThat(results.get(1)).isEqualTo("r");
    }
}
