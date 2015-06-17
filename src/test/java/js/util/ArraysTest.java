/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/11/07 14:48:16
 */
@RunWith(ScriptRunner.class)
public class ArraysTest {

    @Test
    public void fillInt() throws Exception {
        int[] values = {1, 2, 3};
        Arrays.fill(values, 10);
        assert values[0] == 10;
        assert values[1] == 10;
        assert values[2] == 10;
    }

    @Test
    public void fillIntRange() throws Exception {
        int[] values = {1, 2, 3};
        Arrays.fill(values, 1, 3, 10);
        assert values[0] == 1;
        assert values[1] == 10;
        assert values[2] == 10;
    }

    @Test
    public void fillLong() throws Exception {
        long[] values = {1, 2, 3};
        Arrays.fill(values, 10L);
        assert values[0] == 10;
        assert values[1] == 10;
        assert values[2] == 10;
    }

    @Test
    public void fillLongRange() throws Exception {
        long[] values = {1, 2, 3};
        Arrays.fill(values, 0, 2, 10L);
        assert values[0] == 10;
        assert values[1] == 10;
        assert values[2] == 3;
    }

    @Test
    public void fillFloat() throws Exception {
        float[] values = {1, 2, 3};
        Arrays.fill(values, 10F);
        assert values[0] == 10;
        assert values[1] == 10;
        assert values[2] == 10;
    }

    @Test
    public void fillFloatRange() throws Exception {
        float[] values = {1, 2, 3};
        Arrays.fill(values, 1, 3, 10F);
        assert values[0] == 1;
        assert values[1] == 10;
        assert values[2] == 10;
    }

    @Test
    public void fillDouble() throws Exception {
        double[] values = {1, 2, 3};
        Arrays.fill(values, 10D);
        assert values[0] == 10;
        assert values[1] == 10;
        assert values[2] == 10;
    }

    @Test
    public void fillDoubleRange() throws Exception {
        double[] values = {1, 2, 3};
        Arrays.fill(values, 1, 3, 10D);
        assert values[0] == 1;
        assert values[1] == 10;
        assert values[2] == 10;
    }

    @Test
    public void fillBoolean() throws Exception {
        boolean[] values = {false, false, false};
        Arrays.fill(values, true);
        assert values[0];
        assert values[1];
        assert values[2];
    }

    @Test
    public void fillBooleanRange() throws Exception {
        boolean[] values = {false, false, false};
        Arrays.fill(values, 1, 2, true);
        assert !values[0];
        assert values[1];
        assert !values[2];
    }

    @Test
    public void copyOfRange() throws Exception {
        int[] values = {1, 2, 3, 4};

        int[] dest = Arrays.copyOfRange(values, 0, 3);
        assert dest.length == 3;
        assert dest[0] == 1;
        assert dest[1] == 2;
        assert dest[2] == 3;

        dest = Arrays.copyOfRange(values, 0, 5);
        assert dest.length == 5;
        assert dest[0] == 1;
        assert dest[1] == 2;
        assert dest[2] == 3;
        assert dest[3] == 4;
        assert dest[4] == 0;
    }

    @Test
    public void deepEquals() throws Exception {
        Object[] one = {1, 2};

        assert Arrays.deepEquals(one, one);
        assert Arrays.deepEquals(one, new Object[] {1, 2});
        assert !Arrays.deepEquals(one, new Object[] {2, 3});
    }

    @Test
    public void hashCodeNull() throws Exception {
        Object[] array = null;
        assert Arrays.hashCode(array) == 0;
    }
}
