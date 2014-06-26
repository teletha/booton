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

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/03/13 13:39:23
 */
@RunWith(ScriptRunner.class)
public class BigIntegerTest {

    @Test
    public void bigString() throws Exception {
        BigInteger value = new BigInteger("12345678901234567890");
        assert value.toString().equals("12345678901234567890");
    }
}
