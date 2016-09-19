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

import java.util.OptionalLong;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/06/23 17:10:35
 */
@RunWith(ScriptRunner.class)
public class OptionalLongTest {

    @Test
    public void get() throws Exception {
        OptionalLong optional = OptionalLong.of(10);

        assert optional.getAsLong() == 10L;
    }

    @Test
    public void equals() throws Exception {
        OptionalLong optional1 = OptionalLong.of(21);
        OptionalLong optional2 = OptionalLong.of(21);

        assert optional1.equals(optional2);
    }
}
