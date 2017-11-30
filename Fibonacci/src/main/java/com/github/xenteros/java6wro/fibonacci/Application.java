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
        FibonacciService fibonacciService = new FibonacciService(3);
        System.out.println(fibonacciService.fibonacciMatrix(1));

    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        //spr czy w tablicy jest cos pod indeksem n-1
        return fib(n-1) + fib(n-2);
    }
}
