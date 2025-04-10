package com.jaafarfora.cern_exercises;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DuplicatesFinderTest {

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
        DuplicatesFinder<String> duplicatesFinder = new DuplicatesFinder<>();
        List<String> result = duplicatesFinder.search(input);
        // Then
        assertThat(result).isEmpty();
    }

    @Test
    void should_return_list_with_string_duplicates() {
        // Given
        List<String> stringList = List.of("a", "w", "r", "w", "e", "w", "r");
        // When
        DuplicatesFinder<String> duplicatesFinder = new DuplicatesFinder<>();
        List<String> results = duplicatesFinder.search(stringList);
        System.out.println(results);
        // Then
        assertThat(results.size()).isEqualTo(2);
        assertThat(results.getFirst()).isEqualTo("w");
        assertThat(results.get(1)).isEqualTo("r");
    }

    @Test
    void should_return_duplicate_users_based_on_name() {
        // Given
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("Alice");
        User user4 = new User("Charlie");
        User user5 = new User("Bob");

        List<User> users = List.of(user1, user2, user3, user4, user5);

        DuplicatesFinder<User> finder = new DuplicatesFinder<>();

        // When
        List<User> duplicates = finder.search(users);

        // Then
        assertThat(duplicates.size()).isEqualTo(2);
        assertThat(duplicates).containsExactly(user3, user5); // First duplicates detected
    }

}

class User {
    public User(String name) {
        this.name = name;
    }

    String name;

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}