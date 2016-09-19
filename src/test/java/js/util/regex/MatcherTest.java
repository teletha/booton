/*
 * Copyright (C) 2016 Nameless Production Committee
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

import booton.soeur.ScriptRunner;

/**
 * @version 2013/08/27 16:48:45
 */
@RunWith(ScriptRunner.class)
public class MatcherTest {

    @Test
    public void matches() throws Exception {
        Pattern pattern = Pattern.compile("text");
        assert pattern.matcher("text").matches();
        assert!pattern.matcher("my text").matches();
        assert!pattern.matcher("textual").matches();
    }

    @Test
    public void lookingAt() throws Exception {
        Pattern pattern = Pattern.compile("text");
        assert pattern.matcher("text").lookingAt();
        assert!pattern.matcher("my text").lookingAt();
        assert pattern.matcher("textual").lookingAt();
    }

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
        assert!matcher.find();

        try {
            matcher.group();
            throw new AssertionError();
        } catch (IllegalStateException e) {
            // success
        }
    }

    @Test
    public void findWithStartIndex() {
        Matcher matcher = Pattern.compile("text\\d").matcher("text1 text2 text3");
        assert matcher.find(10);
        assert matcher.group().equals("text3");
        assert matcher.find(3);
        assert matcher.group().equals("text2");
        assert matcher.find();
        assert matcher.group().equals("text3");
        assert!matcher.find();
    }

    @Test
    public void reset() throws Exception {
        Matcher matcher = Pattern.compile("text\\d").matcher("text1 text2 text3");
        assert matcher.find();
        assert matcher.group().equals("text1");
        assert matcher.find();
        assert matcher.group().equals("text2");

        matcher.reset();

        assert matcher.find();
        assert matcher.group().equals("text1");
    }

    @Test
    public void resetWithNewInput() throws Exception {
        Matcher matcher = Pattern.compile("text\\d").matcher("text1 text2 text3");
        assert matcher.find();
        assert matcher.group().equals("text1");
        assert matcher.find();
        assert matcher.group().equals("text2");

        matcher.reset("text5 text6 text7");

        assert matcher.find();
        assert matcher.group().equals("text5");
    }

    @Test
    public void usePattern() throws Exception {
        Matcher matcher = Pattern.compile("text\\d").matcher("text1 text2 text3");
        assert matcher.find();
        assert matcher.group().equals("text1");

        matcher.usePattern(Pattern.compile("\\d"));
        assert matcher.find();
        assert matcher.group().equals("2");
    }

    @Test
    public void pattern() throws Exception {
        Pattern pattern = Pattern.compile("text");
        assert pattern.matcher("text").pattern() == pattern;
    }

    @Test(expected = IllegalStateException.class)
    public void start() throws Exception {
        Matcher matcher = Pattern.compile("text\\d").matcher("text1 text2 text3");

        assert matcher.find();
        assert matcher.start() == 0;
        assert matcher.find();
        assert matcher.start() == 6;
        assert matcher.find();
        assert matcher.start() == 12;
        assert!matcher.find();
        matcher.start();
    }

    @Test(expected = IllegalStateException.class)
    public void end() throws Exception {
        Matcher matcher = Pattern.compile("text\\d").matcher("text1 text2 text3");

        assert matcher.find();
        assert matcher.end() == 5;
        assert matcher.find();
        assert matcher.end() == 11;
        assert matcher.find();
        assert matcher.end() == 17;
        assert!matcher.find();
        matcher.end();
    }
}
