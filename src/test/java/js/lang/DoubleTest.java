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
        assert Double.doubleToRawLongBits(0) == 0;
    }
}
