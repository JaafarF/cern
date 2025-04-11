package com.jaafarfora.cern_exercises;

import java.util.Objects;

public class User {
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
