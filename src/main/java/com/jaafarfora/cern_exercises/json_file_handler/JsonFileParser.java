package com.jaafarfora.cern_exercises.json_file_handler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonFileParser {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final int STARTING_INDENT = 0;
    private static final int INDENT = 1;
    private static final String INDENT_SYMBOL = "  ";
    private static final String PREFIX = "- ";
    private static final String LINE_BREAK = "\n";

    public static List<Package> getPackagesGraph(String fileName) throws IOException {
        List<Package> packages = new ArrayList<>();
        File file = new File(fileName);
        Map<String, List<String>> raw = mapper.readValue(file, new TypeReference<>() {});
        for (String name : raw.keySet()) {
            Package pkg = build(name, raw);
            packages.add(pkg);
        }
        return packages;
    }

    public static String printPackagesGraph(String fileName) throws IOException {
        File file = new File(fileName);
        Map<String, List<String>> raw = mapper.readValue(file, new TypeReference<>() {});
        StringBuilder graph = new StringBuilder();
        for (String name : raw.keySet()) {
            Package pkg = build(name, raw);
            graph = printPackage(pkg, STARTING_INDENT, graph);
        }
        return graph.toString();
    }

    private static StringBuilder printPackage(Package pkg, int indent, StringBuilder graph) {
        graph.append(INDENT_SYMBOL.repeat(indent) + PREFIX + pkg.getName() + LINE_BREAK);
        for (Package dep : pkg.getSubpackages()) {
            printPackage(dep, indent + INDENT, graph);
        }
        return graph;
    }

    private static Package build(String name, Map<String, List<String>> raw) {
        List<Package> deps = new ArrayList<>();
        for (String dep : raw.getOrDefault(name, List.of())) {
            deps.add(build(dep, raw));
        }
        return new Package(name, deps);
    }
}
