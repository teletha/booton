/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.Debuggable;
import booton.translator.ScriptRunner;

/**
 * @version 2013/08/28 9:23:45
 */
@RunWith(ScriptRunner.class)
public class InvalidTest {

    @Test
    @Debuggable
    public void fail() throws Exception {
        Pattern pattern = Pattern.compile("test");
        Matcher matcher = pattern.matcher("test");

        assert matcher.toMatchResult() != null;
    }
}
