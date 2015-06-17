/*
 * Copyright (C) 2015 Nameless Production Committee
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
 * @version 2013/08/24 23:25:52
 */
@RunWith(ScriptRunner.class)
public class ByteTest {

    @Test
    public void parse() throws Exception {
        assert Byte.parseByte("1") == 1;
        assert Byte.parseByte("-1") == -1;
    }

    @Test(expected = NumberFormatException.class)
    public void parseNaN() throws Exception {
        Byte.parseByte("Number");
    }

    @Test(expected = NumberFormatException.class)
    public void parseEmpty() throws Exception {
        Byte.parseByte("");
    }

    @Test(expected = NumberFormatException.class)
    public void parseNull() throws Exception {
        Byte.parseByte(null);
    }
}
