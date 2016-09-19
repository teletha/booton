/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.primitive;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/03/24 13:07:04
 */
@RunWith(ScriptRunner.class)
public class TypeConversionTest {

    @Test
    public void longToInt() throws Exception {
        long value = 123L;
        assert ((int) value) == 123;

        value = Integer.MAX_VALUE;
        assert ((int) value) == 2147483647;

        value = Integer.MAX_VALUE + 1;
        assert ((int) value) == -2147483648;

        value = Integer.MIN_VALUE;
        assert ((int) value) == -2147483648;

        value = Integer.MIN_VALUE - 1;
        assert ((int) value) == 2147483647;

        value = 123456789012L;
        assert ((int) value) == -1097262572;

        value = -9876543210987654L;
        assert ((int) value) == 374136698;
    }

    @Test
    public void intToLong() throws Exception {
        int value = 123;
        assert (value) == 123L;

        value = Integer.MAX_VALUE;
        assert (value) == 2147483647L;

        value = Integer.MAX_VALUE + 1;
        assert (value) == -2147483648L;

        value = Integer.MIN_VALUE;
        assert (value) == -2147483648L;

        value = Integer.MIN_VALUE - 1;
        assert (value) == 2147483647L;
    }
}
