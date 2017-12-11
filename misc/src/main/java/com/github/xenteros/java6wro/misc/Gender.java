package com.github.xenteros.java6wro.misc;

public enum Gender {
    MAN("Man"), WOMAN("Woman");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public static Gender fromString(String s) {
        for (Gender g : values()) {
            if (g.gender.equalsIgnoreCase(s)) {
                return g;
            }
        }
        return null;
    }

}
