/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.math;

/**
 * @version 2013/10/25 2:01:45
 */
class Multiplication {

    /**
     * Multiplies an array of integers by an integer value.
     * 
     * @param a the array of integers
     * @param aSize the number of elements of intArray to be multiplied
     * @param factor the multiplier
     * @return the top digit of production
     */
    static int multiplyByInt(int[] a, int aSize, int factor) {
        return multiplyByInt(a, a, aSize, factor);
    }

    /**
     * Computes the value unsigned ((uint)a*(uint)b + (uint)c + (uint)d). This method could improve
     * the readability and performance of the code.
     * 
     * @param a parameter 1
     * @param b parameter 2
     * @param c parameter 3
     * @param d parameter 4
     * @return value of expression
     */
    static long unsignedMultAddAdd(int a, int b, int c, int d) {
        return (a & 0xFFFFFFFFL) * (b & 0xFFFFFFFFL) + (c & 0xFFFFFFFFL) + (d & 0xFFFFFFFFL);
    }

    /**
     * Multiplies an array of integers by an integer value and saves the result in {@code res}.
     * 
     * @param a the array of integers
     * @param aSize the number of elements of intArray to be multiplied
     * @param factor the multiplier
     * @return the top digit of production
     */
    private static int multiplyByInt(int[] res, int[] a, int aSize, int factor) {
        long carry = 0;
        for (int i = 0; i < aSize; i++) {
            carry = unsignedMultAddAdd(a[i], factor, (int) carry, 0);
            res[i] = (int) carry;
            carry >>>= 32;
        }
        return (int) carry;
    }

}
