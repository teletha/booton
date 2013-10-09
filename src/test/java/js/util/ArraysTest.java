/*
 * Copyright (C) 2013 Nameless Production Committee
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

import booton.translator.ScriptRunner;

/**
 * @version 2013/10/09 15:52:13
 */
@RunWith(ScriptRunner.class)
public class ArraysTest {

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
}
