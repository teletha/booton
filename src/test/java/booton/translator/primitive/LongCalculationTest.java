/*
 * Copyright (C) 2014 Nameless Production Committee
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
 * @version 2014/03/27 2:42:39
 */
@RunWith(ScriptRunner.class)
public class LongCalculationTest {

    @Test
    public void add() throws Exception {
        long value = 1L;
        assert value + 20L == 21L;
        assert value + 1000000000000000000L == 1000000000000000001L;
        assert value + -1000000000000000001L == -1000000000000000000L;
    }

    @Test
    public void subtract() throws Exception {
        long value = 1L;
        assert 20L - value == 19L;
        assert 1000000000000000001L - value == 1000000000000000000L;
        assert -1000000000000000000L - value == -1000000000000000001L;
    }

    @Test
    public void divide() throws Exception {
        long value = 2L;
        assert 20L / value == 10L;
        assert 2222222222222222222L / value == 1111111111111111111L;
        assert -2222222222222222222L / value == -1111111111111111111L;
    }
}
