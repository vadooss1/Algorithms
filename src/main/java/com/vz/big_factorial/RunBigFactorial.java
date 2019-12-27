package com.vz.big_factorial;

import java.math.BigInteger;

public class RunBigFactorial {
    public static void main(String[] args) {
        BigInteger digit = sumDigitsOf_fact(100);
        System.out.println(digit);

    }

    /**
     * The method calculates factorial of {@param digit} and returns sum of all factorial's digits
     * @param digit - some positive number
     * @return sum of all factorial's digits
     */
    static BigInteger sumDigitsOf_fact(long digit) {//to determine factorial using the BigInteger class through the cycle
        BigInteger sum = BigInteger.ZERO;
        BigInteger result = BigInteger.ONE;
        for (long i = 2; i <= digit; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        while (!result.equals(BigInteger.ZERO)) {//to sum digit using division by modulus
            sum = sum.add(result.mod(BigInteger.TEN));
            result = result.divide(BigInteger.TEN);
        }
        return sum;
    }

}
