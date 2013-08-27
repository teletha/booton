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

import booton.translator.ScriptRunner;

/**
 * @version 2013/08/27 16:48:45
 */
@RunWith(ScriptRunner.class)
public class MatcherTest {

    @Test
    public void group() {
        Matcher matcher = Pattern.compile("test.+").matcher("testman");
        matcher.matches();

        assert matcher.group().equals("testman");
    }

    @Test
    public void parameter0() {
        Matcher matcher = Pattern.compile("test.+").matcher("testman");
        matcher.matches();

        assert matcher.group(0).equals("testman");
    }

    @Test
    public void groupCount() {
        Matcher matcher = Pattern.compile("test(.+)").matcher("testman");
        matcher.matches();

        assert matcher.groupCount() == 1;
    }
}
