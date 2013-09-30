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
 * @version 2013/04/15 18:44:46
 */
@SuppressWarnings("unused")
public class NativeStringTest extends ScriptTester {

    @Test
    public void append() throws Exception {
        test(new Scriptable() {

            String act() {
                NativeString string = new NativeString();
                string = string.concat("test");

                return string.toString();
            }
        });
    }
}
