/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.operator;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/03/17 10:28:45
 */
@RunWith(ScriptRunner.class)
public class ArithmeticOperatorPriorityTest {

    @Test
    public void shiftWithAdd() throws Exception {
        int value = 128;
        int base = 2;
        assert value >> base + 1 == 16;
        assert (value >> base) + 1 == 33;
    }

}
