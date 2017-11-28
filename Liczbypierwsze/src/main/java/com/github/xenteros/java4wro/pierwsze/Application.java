package com.github.xenteros.java4wro.pierwsze;

import com.github.xenteros.java4wro.pierwsze.service.LeapYearService;

public class Application {

    public static void main(String[] args) {
        LeapYearService leapYearService = new LeapYearService();
        System.out.println(leapYearService.isLeapYear(2004));
    }
}
