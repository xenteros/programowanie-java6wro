package com.github.xenteros.java6wro.primaries;

import java.util.UUID;

public class User {

    private String uuid = UUID.randomUUID().toString();
    private int age;

    public int getAge() {
        return age;
    }
}
