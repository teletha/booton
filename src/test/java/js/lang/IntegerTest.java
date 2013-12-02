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

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/12/02 18:00:38
 */
@RunWith(ScriptRunner.class)
public class IntegerTest {

    @Test
    public void parse() throws Exception {
        assert Integer.parseInt("1") == 1;
        assert Integer.parseInt("-1") == -1;
    }

    @Test(expected = NumberFormatException.class)
    public void parseNaN() throws Exception {
        Integer.parseInt("Number");
    }

    @Test(expected = NumberFormatException.class)
    public void parseEmpty() throws Exception {
        Integer.parseInt("");
    }

    @Test(expected = NumberFormatException.class)
    public void parseNull() throws Exception {
        Integer.parseInt(null);
    }

    @Test
    public void toStringRadix() throws Exception {
        assert Integer.toString(16, 36).equals("g");
    }
}
