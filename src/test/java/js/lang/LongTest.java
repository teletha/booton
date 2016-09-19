/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/03/27 1:11:32
 */
@RunWith(ScriptRunner.class)
public class LongTest {

    @Test
    public void parseLong() {
        assert Long.parseLong("1") == 1L;
        assert Long.parseLong("-1") == -1L;
    }

    @Test(expected = NumberFormatException.class)
    public void parseLongNaN() {
        Long.parseLong("Number");
    }

    @Test(expected = NumberFormatException.class)
    public void parseLongEmpty() {
        Long.parseLong("");
    }

    @Test(expected = NumberFormatException.class)
    public void parseLongNull() {
        Long.parseLong(null);
    }

    @Test
    public void valueOf() {
        assert Long.valueOf(1L).toString().endsWith("1");
        assert Long.valueOf(12345678901L).toString().equals("12345678901");
    }
}
