package com.github.xenteros.java6wro.floats;

import java.math.BigDecimal;

public class Application {

    public static void main(String[] args) {



    }

    public static double solveEquations(double left, double right, double margin) {
        double x = left + (right - left) / 2;
        double res = x * x + 3 * x + 1;
        while (res > margin || res < -1*margin) {
            x = left + (right - left) / 2;
            res = x * x + 3 * x + 1;
            if (res > 0) {
                right = x;
            }
            if (res < 0) {
                left = x;
            }
        }
        return x;
    }

    public static void hugeSqrt() {
        double res = 1.0;
        for (int i = 1; i <= 2017; i++) {
            res *= Math.pow(i, 1.0 / 2017);
        }
        System.out.println(res);
    }

    public static void inequality() {
        double res = Math.pow(4, 1.0 / 2);
        System.out.println(res);

        BigDecimal ten = new BigDecimal("10");
        BigDecimal sum = BigDecimal.ZERO;
        int i = 0;
        while (sum.compareTo(ten) < 0) {
            sum = sum.add(new BigDecimal(1.0 / ++i));
        }
        System.out.println(i);
        System.out.println(sum);
    }
}
