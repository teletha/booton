/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.sdk;

import org.junit.Ignore;
import org.junit.Test;

import booton.translator.api.Scriptable;
import booton.translator.api.ScriptTester;

/**
 * @version 2012/11/30 8:59:14
 */
@SuppressWarnings("unused")
public class StringValueOfTest extends ScriptTester {

    @Test
    public void Int() throws Exception {
        test(new Scriptable() {

            String act() {
                return String.valueOf(1);
            }
        });
    }

    @Test
    public void Long() throws Exception {
        test(new Scriptable() {

            String act() {
                return String.valueOf(1234567890L);
            }
        });
    }

    @Test
    public void Float() throws Exception {
        test(new Scriptable() {

            String act() {
                return String.valueOf(0.1F);
            }
        });
    }

    @Test
    public void Double() throws Exception {
        test(new Scriptable() {

            String act() {
                return String.valueOf(0.12345678901D);
            }
        });
    }

    @Test
    public void Boolean() throws Exception {
        testByBoolean(new Scriptable() {

            String act(boolean value) {
                return String.valueOf(value);
            }
        });
    }

    @Test
    public void Char() throws Exception {
        test(new Scriptable() {

            String act() {
                return String.valueOf('Q');
            }
        });
    }

    @Test
    @Ignore
    public void CharArray() throws Exception {
        test(new Scriptable() {

            String act() {
                return String.valueOf(new char[] {'c', 'a', 't'});
            }
        });
    }
}
