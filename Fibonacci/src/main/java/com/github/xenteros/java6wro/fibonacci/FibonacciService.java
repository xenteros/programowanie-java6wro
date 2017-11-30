package com.github.xenteros.java6wro.fibonacci;

public class FibonacciService {

    private int n;
    private long[] partialResults;

    public FibonacciService(int n) {
        this.n = n;
        partialResults = new long[n];
        partialResults[0] = 1;
        partialResults[1] = 1;
    }

    public long fib(int n) {
        long i = partialResults[n - 2];
        long j = partialResults[n - 1];

        if (i == 0) {
            i = fib(n - 2);
            partialResults[n - 2] = i;
        }
        if (j == 0) {
            j = fib(n - 1);
            partialResults[n - 1] = j;
        }
        return i + j;
    }
}
