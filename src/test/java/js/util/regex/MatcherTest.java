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
        Matcher matcher = Pattern.compile("text").matcher("text");
        assert matcher.matches();
        assert matcher.group().equals("text");
        assert matcher.groupCount() == 0;

        // call multiple
        assert matcher.matches();
        assert matcher.group().equals("text");

    }

    @Test
    public void groupInt() {
        Matcher matcher = Pattern.compile("text(\\d+)").matcher("text14");
        assert matcher.matches();
        assert matcher.group().equals("text14");
        assert matcher.groupCount() == 1;
        assert matcher.group(0).equals("text14");
        assert matcher.group(1).equals("14");
    }

    @Test
    public void find() {
        Matcher matcher = Pattern.compile("text\\d").matcher("text1 text2 text3");
        assert matcher.find();
        assert matcher.group().equals("text1");
        assert matcher.find();
        assert matcher.group().equals("text2");
        assert matcher.find();
        assert matcher.group().equals("text3");
        assert !matcher.find();
    }

}
