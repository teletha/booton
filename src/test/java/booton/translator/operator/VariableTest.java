/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.operator;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/08/14 10:23:29
 */
@SuppressWarnings("unused")
public class VariableTest extends ScriptTester {

    @Test
    public void multiAssign() {
        test(new Scriptable() {

            public int act(int value) {
                int a, b;

                a = b = value + 1;

                return a * b;
            }
        });
    }

    @Test
    public void assignAndExpressionInOneLine() {
        test(new Scriptable() {

            public int act(int value) {
                boolean result = (value = value + 3) % 2 == 0;

                return result ? value : value + 1;
            }
        });
    }

}
