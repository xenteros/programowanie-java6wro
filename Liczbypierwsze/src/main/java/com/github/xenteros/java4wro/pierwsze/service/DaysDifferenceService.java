package com.github.xenteros.java4wro.pierwsze.service;

import java.util.Calendar;
import java.util.Date;

public class DaysDifferenceService {

    private int[] daysInMonts = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private LeapYearService leapYearService;

    public DaysDifferenceService() {
        this.leapYearService = new LeapYearService();
    }

    public int daysSinceCommonEraBeginningWithDate() {

        final Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        int totalDays = 0;
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);

        totalDays += sumDaysInYearsBefore(year);
        totalDays += sumDaysInMonthsBefore(month, year);
        totalDays += calendar.get(Calendar.DAY_OF_MONTH) - 1;

        return totalDays;
    }

    private int sumDaysInYearsBefore(int year) {
        int totalDays = 0;
        for (int i = 1; i < year; i++) {
            totalDays += leapYearService.isLeapYear(i) ? 366 : 365;
        }
        return totalDays;
    }
    private int sumDaysInMonthsBefore(int month, int year) {
        int totalDays = 0;
        for (int i = 0; i < month; i++) {
            totalDays += daysInMonts[i];
            if (i == 1 && leapYearService.isLeapYear(year)) {
                totalDays += 1;
            }
        }
        return totalDays;
    }
}
