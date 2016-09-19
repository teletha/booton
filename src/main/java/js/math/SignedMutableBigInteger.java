/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.math;


/**
 * @version 2014/03/15 13:14:32
 */
// @JavaAPIProvider(JDKEmulator.class)
class SignedMutableBigInteger extends MutableBigInteger {

    /**
     * The sign of this MutableBigInteger.
     */
    int sign = 1;

    // Constructors

    /**
     * The default constructor. An empty MutableBigInteger is created with a one word capacity.
     */
    SignedMutableBigInteger() {
        super();
    }

    /**
     * Construct a new MutableBigInteger with a magnitude specified by the int val.
     */
    SignedMutableBigInteger(int val) {
        super(val);
    }

    /**
     * Construct a new MutableBigInteger with a magnitude equal to the specified MutableBigInteger.
     */
    SignedMutableBigInteger(MutableBigInteger val) {
        super(val);
    }

    // Arithmetic Operations

    /**
     * Signed addition built upon unsigned add and subtract.
     */
    void signedAdd(SignedMutableBigInteger addend) {
        if (sign == addend.sign)
            add(addend);
        else
            sign = sign * subtract(addend);

    }

    /**
     * Signed addition built upon unsigned add and subtract.
     */
    void signedAdd(MutableBigInteger addend) {
        if (sign == 1)
            add(addend);
        else
            sign = sign * subtract(addend);

    }

    /**
     * Signed subtraction built upon unsigned add and subtract.
     */
    void signedSubtract(SignedMutableBigInteger addend) {
        if (sign == addend.sign)
            sign = sign * subtract(addend);
        else
            add(addend);

    }

    /**
     * Signed subtraction built upon unsigned add and subtract.
     */
    void signedSubtract(MutableBigInteger addend) {
        if (sign == 1)
            sign = sign * subtract(addend);
        else
            add(addend);
        if (intLen == 0) sign = 1;
    }

    /**
     * Print out the first intLen ints of this MutableBigInteger's value array starting at offset.
     */
    @Override
    public String toString() {
        return this.toBigInteger(sign).toString();
    }
}
