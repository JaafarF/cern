package com.jaafarfora.cern_exercises.json_file_handler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JsonFileParserTest {

    JsonFileParser jsonFileParser = new JsonFileParser();
    List<Package> expexted;

    @BeforeEach
    void setUp() {
        Package pkg3 = new Package("pkg3", List.of());
        Package pkg2 = new Package("pkg2", List.of(pkg3));
        Package pkg1 = new Package("pkg1", List.of(pkg2, pkg3));
        expexted = List.of(pkg1, pkg2, pkg3);
    }

    @Test
    void getPackagesGraphTest() throws IOException {
        // When
        List<Package> result = JsonFileParser.getPackagesGraph("src/main/resources/packages.json");

        // Then
        assertThat(result).usingRecursiveComparison().isEqualTo(expexted);
    }

    @Test
    void printPackagesGraphTest() throws IOException {
        // Given
        Package pkg3 = new Package("pkg3", List.of());
        Package pkg2 = new Package("pkg2", List.of(pkg3));
        Package pkg1 = new Package("pkg1", List.of(pkg2, pkg3));
        List<Package> expexted = List.of(pkg1, pkg2, pkg3);

        // When
        String result = JsonFileParser.printPackagesGraph("src/main/resources/packages.json");

        // Then
        String expextedString =
            "- pkg1\n"
            + "  - pkg2\n"
            + "    - pkg3\n"
            + "  - pkg3\n"
            + "- pkg2\n"
            + "  - pkg3\n"
            + "- pkg3\n";
        assertThat(expextedString).isEqualTo(result);
    }
}