/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.method;

import org.junit.Test;

import booton.translator.api.ScriptTester;
import booton.translator.api.Scriptable;

/**
 * @version 2012/12/01 3:54:05
 */
@SuppressWarnings("unused")
public class LocalVariableTest extends ScriptTester {

    @Test
    public void parallel() {
        test(new Scriptable() {

            public int act(int value) {
                if (value < 1) {
                    int x = value;

                    value = value - 1;
                    value = x * value;
                } else {
                    int y = value;

                    value = value + 1;
                    value = y * value;
                }
                return value;
            }
        });
    }
}
