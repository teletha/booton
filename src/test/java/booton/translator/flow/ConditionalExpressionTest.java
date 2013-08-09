/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.flow;

import org.junit.Test;

import booton.translator.Debuggable;
import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/08/09 12:38:04
 */
@SuppressWarnings("unused")
public class ConditionalExpressionTest extends ScriptTester {

    @Test
    public void logicalExpressionInLeft() {
        test(new Scriptable() {

            @Debuggable
            public boolean act(int value) {
                return value < 3 ? value == 2 : false;
            }
        });
    }

    @Test
    public void withExpression() {
        test(new Scriptable() {

            public int act(String value) {
                return 31 + (value == null ? 0 : value.length());
            }
        });
    }

    @Test
    public void withExpressionThenAssignToVariable() {
        test(new Scriptable() {

            boolean flag = true;

            public String act(String value) {
                String result = flag ? value.concat("test") : value.concat("one");

                return result;
            }
        });
    }

    @Test
    public void withAssignToVariable() {
        test(new Scriptable() {

            public int act(boolean flag) {
                int result = flag ? 10 : 12;

                return result;
            }
        });
    }
}
