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

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/03/13 13:39:23
 */
@RunWith(ScriptRunner.class)
public class BigIntegerTest {

    @Test
    @Ignore
    public void ToString() throws Exception {
        assert new BigInteger("0").toString().equals("0");
        assert new BigInteger("-1").toString().equals("-1");
        assert new BigInteger("12345").toString().equals("12345");
        assert new BigInteger("12345678901234567890").toString().equals("12345678901234567890");
    }
}
