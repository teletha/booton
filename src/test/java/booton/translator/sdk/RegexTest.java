/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.sdk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/01/10 23:11:55
 */
@SuppressWarnings("unused")
public class RegexTest extends ScriptTester {

    @Test
    public void compile() {
        test(new Scriptable() {

            public String act() {
                return Pattern.compile("test").pattern();
            }
        });
    }

    @Test
    public void matche() {
        test(new Scriptable() {

            public boolean act() {
                Matcher matcher = Pattern.compile("test").matcher("test");

                return matcher.matches();
            }
        });
    }

    @Test
    public void unmatche() {
        test(new Scriptable() {

            public boolean act() {
                Matcher matcher = Pattern.compile("test").matcher("false");

                return matcher.matches();
            }
        });
    }

    @Test
    public void group() {
        test(new Scriptable() {

            public String act() {
                Matcher matcher = Pattern.compile("test.+").matcher("testman");
                matcher.matches();

                return matcher.group();
            }
        });
    }

    @Test
    public void parameter0() {
        test(new Scriptable() {

            public String act() {
                Matcher matcher = Pattern.compile("test.+").matcher("testman");
                matcher.matches();

                return matcher.group(0);
            }
        });
    }

    @Test
    public void groupCount() {
        test(new Scriptable() {

            public int act() {
                Matcher matcher = Pattern.compile("test(.+)").matcher("testman");
                matcher.matches();

                return matcher.groupCount();
            }
        });
    }
}
