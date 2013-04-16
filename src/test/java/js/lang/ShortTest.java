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
public class ShortTest extends ScriptTester {

    @Test
    public void parse() throws Exception {
        test(new Scriptable() {

            short act() {
                return Short.parseShort("1");
            }
        });
    }

    @Test
    public void parseNegative() throws Exception {
        test(new Scriptable() {

            short act() {
                return Short.parseShort("-1");
            }
        });
    }

    @Test
    public void parseNaN() throws Exception {
        test(new Scriptable() {

            short act() {
                try {
                    return Short.parseShort("Number");
                } catch (NumberFormatException e) {
                    return 10;
                }
            }
        });
    }

    @Test
    public void empty() throws Exception {
        test(new Scriptable() {

            short act() {
                try {
                    return Short.parseShort("");
                } catch (NumberFormatException e) {
                    return 10;
                }
            }
        });
    }

    @Test
    public void Null() throws Exception {
        test(new Scriptable() {

            short act() {
                try {
                    return Short.parseShort(null);
                } catch (NumberFormatException e) {
                    return 10;
                }
            }
        });
    }
}
