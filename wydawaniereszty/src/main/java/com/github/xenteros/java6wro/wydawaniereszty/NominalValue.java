package com.github.xenteros.java6wro.wydawaniereszty;

public enum NominalValue {

    ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20), FIFTY(50),
    ONE_HUNDRED(100), TWO_HUNDRED(200), FIVE_HUNDRED(500);

    private int value;

    NominalValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
