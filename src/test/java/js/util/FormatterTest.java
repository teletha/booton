/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Formatter;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2015/08/07 0:24:18
 */
@RunWith(ScriptRunner.class)
public class FormatterTest {

    @Test
    public void testname() throws Exception {
        Formatter formatter = new Formatter();
        formatter.format("%d", 10);

        assert formatter.toString().equals("10");
    }
}
