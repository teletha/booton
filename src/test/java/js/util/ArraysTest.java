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
 * @version 2013/08/15 19:39:00
 */
@RunWith(ScriptRunner.class)
public class ArraysTest {

    @Test
    public void copyOf() throws Exception {
        int[] values = {1, 2, 3, 4, 5};
        int[] dest = Arrays.copyOfRange(values, 0, 3);

        assert dest.length == 3;
    }
}
