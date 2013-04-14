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
 * @version 2013/04/14 0:03:00
 */
@SuppressWarnings("unused")
public class IntegerTest extends ScriptTester {

    @Test
    public void parseInt() throws Exception {
        test(new Scriptable() {

            int act() {
                return Integer.parseInt("1");
            }
        });
    }

    @Test
    public void parseIntNegative() throws Exception {
        test(new Scriptable() {

            int act() {
                return Integer.parseInt("-1");
            }
        });
    }

    @Test
    public void parseIntNaN() throws Exception {
        test(new Scriptable() {

            int act() {
                try {
                    return Integer.parseInt("Number");
                } catch (NumberFormatException e) {
                    return 10;
                }
            }
        });
    }
}
