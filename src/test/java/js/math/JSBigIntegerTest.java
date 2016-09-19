/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.math;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/03/17 10:24:07
 */
@Ignore
@RunWith(ScriptRunner.class)
public class JSBigIntegerTest {

    @Test
    public void testname() throws Exception {
        JSBigInteger i = new JSBigInteger("12345678901234567890");
    }
}
