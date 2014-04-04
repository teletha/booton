/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/08/24 23:21:57
 */
@RunWith(ScriptRunner.class)
public class BooleanTest {

    @Test
    public void parse() throws Exception {
        assert Boolean.parseBoolean("true");
        assert !Boolean.parseBoolean("false");
        assert !Boolean.parseBoolean("Some");
        assert !Boolean.parseBoolean("");
        assert !Boolean.parseBoolean(null);
    }

    @Test
    public void ToString() throws Exception {
        assert Boolean.TRUE.toString().equals("true");
        assert Boolean.FALSE.toString().equals("false");
        assert Boolean.toString(true).equals("true");
        assert Boolean.toString(false).equals("false");
    }
}
