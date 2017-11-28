package com.github.xenteros.java4wro.pierwsze.service;

public class LeapYearService {

    /*
        zwróć prawdę, gdy:
            jest podzielny przez 400
                lub
            jest podzielny przez 4 i niepodzielny przez 100

        wpp zwróć fałsz
     */
    public boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        return year % 4 == 0 && year % 100 != 0;
    }
}