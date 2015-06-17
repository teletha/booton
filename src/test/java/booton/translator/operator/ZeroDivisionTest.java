/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.operator;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/03/24 15:12:47
 */
@RunWith(ScriptRunner.class)
@SuppressWarnings("unused")
public class ZeroDivisionTest {

    @Ignore
    @Test(expected = ArithmeticException.class)
    public void primitiveInt() throws Exception {
        double value = 10 / 0;
    }

    @Ignore
    @Test(expected = ArithmeticException.class)
    public void primitiveIntZero() throws Exception {
        double value = 0 / 0;
    }

    @Test(expected = ArithmeticException.class)
    public void primitiveLong() throws Exception {
        double value = 10L / 0;
    }

    @Test(expected = ArithmeticException.class)
    public void primitiveLongZero() throws Exception {
        double value = 0L / 0;
    }

    @Test
    public void primitiveFloat() throws Exception {
        assert Float.isInfinite(10F / 0);
    }

    @Test
    public void primitiveFloatZero() throws Exception {
        assert Float.isNaN(0F / 0);
    }

    @Test
    public void primitiveDouble() throws Exception {
        assert Double.isInfinite(10D / 0);
    }

    @Test
    public void primitiveDoubleZero() throws Exception {
        assert Double.isNaN(0D / 0);
    }
}
