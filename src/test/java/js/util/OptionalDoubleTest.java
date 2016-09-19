/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.OptionalDouble;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/10/30 20:25:39
 */
@RunWith(ScriptRunner.class)
public class OptionalDoubleTest {

    @Test
    public void get() throws Exception {
        OptionalDouble optional = OptionalDouble.of(10);

        assert optional.getAsDouble() == 10;
    }

    @Test
    public void equals() throws Exception {
        OptionalDouble optional1 = OptionalDouble.of(21);
        OptionalDouble optional2 = OptionalDouble.of(21);

        assert optional1.equals(optional2);
    }
}
