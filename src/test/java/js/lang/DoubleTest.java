/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/08/25 21:37:56
 */
@RunWith(ScriptRunner.class)
public class DoubleTest {

    @Test
    public void valueOf() throws Exception {
        assert Double.valueOf(0.1d).doubleValue() == 0.1;
        assert Double.valueOf(0).doubleValue() == 0;
    }

    @Test
    public void valueOfString() throws Exception {
        assert Double.valueOf("0.1").doubleValue() == 0.1;
    }

    @Test
    public void doubleToRawLongBits() throws Exception {
        System.out.println(aaa(1));
        assert Double.doubleToRawLongBits(1) == 4607182418800017408L;
        assert Double.doubleToRawLongBits(2) == 4611686018427387904L;
        assert Double.doubleToRawLongBits(-1) == -4616189618054758400L;
        assert Double.doubleToRawLongBits(-118.625) == -4585324127639830528L;
    }

    public static long aaa(double value) {
        boolean negative = value < 0;

        if (negative) {
            value *= -1;
        }

        double exp = Math.floor(Math.log(value) / Math.log(2));
        double frac = Math.floor(value * Math.pow(2, 52 - exp));
        exp += 1023;

        StringBuilder builder = new StringBuilder();
        builder.append(negative ? "1" : "0");

        String mix = "0000000000".concat(Long.toBinaryString((long) exp));
        mix = mix.substring(mix.length() - 11);

        builder.append(mix).append(Long.toBinaryString((long) frac).substring(1));

        BigInteger bigInteger = new BigInteger(builder.toString(), 2);
        System.out.println(bigInteger);
        return bigInteger.longValue();
    }
}