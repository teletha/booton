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
 * @version 2013/10/25 2:04:20
 */
class Elementary {

    /**
     * Adds an integer value to the array of integers remembering carry.
     * 
     * @return a possible generated carry (0 or 1)
     */
    static int inplaceAdd(int a[], final int aSize, final int addend) {
        long carry = addend & 0xFFFFFFFFL;

        for (int i = 0; (carry != 0) && (i < aSize); i++) {
            carry += a[i] & 0xFFFFFFFFL;
            a[i] = (int) carry;
            carry >>= 32;
        }
        return (int) carry;
    }

}
