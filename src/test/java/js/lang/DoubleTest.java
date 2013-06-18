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
 * @version 2013/04/15 22:48:15
 */
@SuppressWarnings("unused")
public class DoubleTest extends ScriptTester {

    @Test
    public void valueOf() throws Exception {
        test(new Scriptable() {

            double act() {
                return Double.valueOf(0.1d).doubleValue();
            }
        });
    }

    @Test
    public void valueOfString() throws Exception {
        test(new Scriptable() {

            double act() {
                return Double.valueOf("0.1").doubleValue();
            }
        });
    }
}
