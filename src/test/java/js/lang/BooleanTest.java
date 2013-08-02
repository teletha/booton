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

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/04/17 3:16:19
 */
@SuppressWarnings("unused")
public class BooleanTest extends ScriptTester {

    @Test
    public void parseTrue() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return Boolean.parseBoolean("true");
            }
        });
    }

    @Test
    public void parseFalse() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return Boolean.parseBoolean("false");
            }
        });
    }

    @Test
    public void parseSome() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return Boolean.parseBoolean("Some");
            }
        });
    }

    @Test
    public void empty() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return Boolean.parseBoolean("");
            }
        });
    }

    @Test
    public void Null() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return Boolean.parseBoolean(null);
            }
        });
    }
}
