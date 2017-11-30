package com.github.xenteros.java6wro.fibonacci;

import java.math.BigInteger;

public class FibonacciService {

    private int n;
    private BigInteger[] partialResults;

    public FibonacciService(int n) {
        this.n = n;
        partialResults = new BigInteger[n];
        partialResults[0] = BigInteger.ONE;
        partialResults[1] = BigInteger.ONE;
    }

    public BigInteger fib(int n) {
        BigInteger i = partialResults[n - 2];
        BigInteger j = partialResults[n - 1];

        if (i == null) {
            i = fib(n - 2);
            partialResults[n - 2] = i;
        }
        if (j == null) {
            j = fib(n - 1);
            partialResults[n - 1] = j;
        }
        return i.add(j);
    }

    public BigInteger fibonacciMatrix(int n) {
        BigInteger[][] arr = new BigInteger[2][2];
        arr[0][0] = BigInteger.ONE;
        arr[0][1] = BigInteger.ONE;
        arr[1][0] = BigInteger.ONE;
        arr[1][1] = BigInteger.ZERO;

        return pow(arr, n)[0][0];
    }

    private BigInteger[][] pow(BigInteger[][] a, int n) {
        if (n == 1) {
            return a;
        }
        if (n % 2 == 0) {
            BigInteger[][] res = pow(a, n/2);
            return multiplyTwoArrays2x2(res, res);
        }
        return multiplyTwoArrays2x2(pow(a, n-1), a);
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
