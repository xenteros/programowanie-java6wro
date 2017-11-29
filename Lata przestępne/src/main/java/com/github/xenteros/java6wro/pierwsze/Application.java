package com.github.xenteros.java6wro.pierwsze;

import com.github.xenteros.java6wro.pierwsze.service.DaysDifferenceService;
import com.github.xenteros.java6wro.pierwsze.service.LeapYearService;

public class Application {

    public static void main(String[] args) {
        LeapYearService leapYearService = new LeapYearService();
        System.out.println();
        System.out.println(leapYearService.isLeapYear(2004));
        System.out.println();
        DaysDifferenceService daysDifferenceService = new DaysDifferenceService();
        System.out.println();
        System.out.println(daysDifferenceService.daysSinceCommonEraBeginningWithDate());
        System.out.println();
    }
}
