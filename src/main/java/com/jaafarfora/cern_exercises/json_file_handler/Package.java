package com.jaafarfora.cern_exercises.json_file_handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Package {

    private final String name;
    private List<Package> subpackages = new ArrayList<>();

    public Package(String name, List<Package> subpackages) {
        this.name = name;
        this.subpackages = subpackages;
    }

    public String getName() {
        return name;
    }

    public List<Package> getSubpackages() {
        return subpackages;
    }
}
