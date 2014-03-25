/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.math;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/03/17 9:41:10
 */
@RunWith(ScriptRunner.class)
public class BigDecimalTest {

    @Test
    public void constructorString() throws Exception {
        BigDecimal value = new BigDecimal("1");
        assert value.intValue() == 1;

        value = new BigDecimal("123456789012345678901234567890.12345678901");
        assert value.toString().endsWith("123456789012345678901234567890.12345678901");
    }
}
