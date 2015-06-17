/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.math;

/**
 * @version 2013/10/25 2:04:20
 */
class Elementary {

    /**
     * Adds an integer value to the array of integers remembering carry.
     * 
     * @return a possible generated carry (0 or 1)
     */
    static int inplaceAdd(int[] array, int aSize, int addend) {
        long carry = addend & 0xFFFFFFFFL;

        for (int i = 0; (carry != 0) && (i < aSize); i++) {
            carry += array[i] & 0xFFFFFFFFL;
            System.out.println(carry + "   carry");
            array[i] = (int) carry;
            carry = shift(carry, 32);
            System.out.println(carry + "     carry change");
        }
        return (int) carry;
    }

    static long shift(long num, int pow) {
        return Math.round(num / Math.pow(2, pow));
    }
}
