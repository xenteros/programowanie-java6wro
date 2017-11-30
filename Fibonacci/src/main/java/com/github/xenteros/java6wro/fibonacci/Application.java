package com.github.xenteros.java6wro.fibonacci;

public class Application {

    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        System.out.println(fib(40));
//        System.out.println((System.currentTimeMillis() - start));

//        FibonacciService fibonacciService = new FibonacciService(40);
//        long start = System.currentTimeMillis();
//        System.out.println(fibonacciService.fib(39));
//        System.out.println((System.currentTimeMillis() - start));
        FibonacciService fibonacciService = new FibonacciService(10000);
        long start = System.currentTimeMillis();
        fibonacciService.fib(9999);
        System.out.println(System.currentTimeMillis()-start);
        start = System.currentTimeMillis();
        System.out.println(fibonacciService.fibonacciMatrix(9999));
        System.out.println(System.currentTimeMillis()-start);

    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        //spr czy w tablicy jest cos pod indeksem n-1
        return fib(n - 1) + fib(n - 2);
    }

    public static int fastPow(int a, int b) {
        if (b == 1) {
            return a;
        }
        if (b % 2 == 0) {
            int res = fastPow(a, b/2);
            return res*res;
        }
        return a*fastPow(a, b-1);
    }
}
