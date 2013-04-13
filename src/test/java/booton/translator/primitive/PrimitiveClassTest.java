/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.primitive;

import org.junit.Ignore;
import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/04/13 14:40:19
 */
public class PrimitiveClassTest extends ScriptTester {

    @Test
    @Ignore
    public void Int() throws Exception {
        test(new Scriptable() {

            Class act() {
                return int.class;
            }
        });
    }
}
