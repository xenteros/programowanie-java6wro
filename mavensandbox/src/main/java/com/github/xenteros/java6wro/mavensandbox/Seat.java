package com.github.xenteros.java6wro.mavensandbox;

public class Seat {

    private String row;
    private int column;
    private int multiplier;

    public Seat(String row, int column, int multiplier) {
        this.row = row;
        this.column = column;
        this.multiplier = multiplier;
    }

    public String getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
