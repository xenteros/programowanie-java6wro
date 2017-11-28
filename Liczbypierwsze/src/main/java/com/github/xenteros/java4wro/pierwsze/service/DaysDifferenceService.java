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

        for (int i = 1; i < calendar.get(Calendar.YEAR); i++) {
            totalDays += leapYearService.isLeapYear(i) ? 366 : 365;
        }
        for (int i = 0; i < calendar.get(Calendar.MONTH); i++) {
            totalDays += daysInMonts[i];
            if (i == 1) {
                if (leapYearService.isLeapYear(calendar.get(Calendar.YEAR))) {
                    totalDays += 1;
                }
            }
        }
        totalDays += calendar.get(Calendar.DAY_OF_MONTH) - 1;
        return totalDays;
    }
}
