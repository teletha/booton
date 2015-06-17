/*
 * Copyright (C) 2015 Nameless Production Committee
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
 * @version 2014/03/27 9:40:27
 */
@RunWith(ScriptRunner.class)
public class DoubleInAssertTest {

    private double value = 10D;

    @Test
    public void less() throws Exception {
        assert value < 100D; // CMPG IFLT
    }

    @Test
    public void lessEqual() throws Exception {
        assert value <= 100D; // CMPG IFLE
    }

    @Test
    public void greater() throws Exception {
        assert value > 0D; // CMPL IFGT
    }

    @Test
    public void greaterEqual() throws Exception {
        assert value >= 0D; // CMPL IFGE
    }
}
