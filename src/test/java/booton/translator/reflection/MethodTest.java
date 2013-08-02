/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.reflection;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/01/18 11:28:01
 */
@SuppressWarnings("unused")
public class MethodTest extends ScriptTester {

    @Test
    public void newInstance() throws Exception {
        test(new Scriptable() {

            int act() throws Exception {
                return 1;
            }
        });
    }
}
