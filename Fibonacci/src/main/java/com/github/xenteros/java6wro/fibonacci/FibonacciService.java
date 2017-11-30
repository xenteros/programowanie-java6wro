package com.github.xenteros.java6wro.fibonacci;

import java.math.BigInteger;

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

    public BigInteger fibonacciMatrix(int n) {
        BigInteger[][] arr = new BigInteger[2][2];
        arr[0][0] = BigInteger.ONE;
        arr[0][1] = BigInteger.ONE;
        arr[1][0] = BigInteger.ONE;
        arr[1][1] = BigInteger.ZERO;

        return null;
    }
    private BigInteger[][] multiplyTwoArrays2x2(BigInteger[][] t1, BigInteger[][] t2) {
        BigInteger[][] result = new BigInteger[2][2];
        result[0][0] = t1[0][0].multiply(t2[0][0]).add(t1[0][1].multiply(t2[1][0]));
        result[0][1] = t1[0][0].multiply(t2[0][1]).add(t1[0][1].multiply(t2[1][1]));
        result[1][0] = t1[1][0].multiply(t2[0][0]).add(t1[1][1].multiply(t2[0][1]));
        result[1][1] = t1[1][0].multiply(t2[0][1]).add(t1[1][1].multiply(t2[1][1]));
        return result;
    }

}
