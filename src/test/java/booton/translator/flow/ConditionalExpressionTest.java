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
import booton.translator.Param;
import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/08/09 15:50:42
 */
@SuppressWarnings("unused")
public class ConditionalExpressionTest extends ScriptTester {

    @Test
    public void base() {
        test(new Scriptable() {

            @Debuggable
            public int act(int value) {
                return value < 3 ? 10 : 20;
            }
        });
    }

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
    public void logicalExpressionInRight() {
        test(new Scriptable() {

            private boolean a = true;

            @Debuggable
            public boolean act(int value) {
                return value < 3 ? a : value == 4;
            }
        });
    }

    @Test
    public void logicalExpressionInBoth() {
        test(new Scriptable() {

            public boolean act(int value) {
                return value < 3 ? value == 2 : value == 4;
            }
        });
    }

    @Test
    public void logicalCondition() {
        test(new Scriptable() {

            private boolean a = true;

            @Debuggable
            public boolean act(int value) {
                return value < 0 || 2 < value ? a : false;
            }
        });
    }

    @Test
    public void string() {
        test(new Scriptable() {

            @Debuggable
            public String act(int value) {
                return (value < 0 ? "negative" : "positive") + " value";
            }
        });
    }

    @Test
    public void stringNest() {
        test(new Scriptable() {

            @Debuggable
            public String act(int value) {
                return (value < 0 ? "negative" : value == 1 ? "one" : "positive") + " value";
            }
        });
    }

    @Test
    public void stringComplex() {
        test(new Scriptable() {

            @Debuggable
            public String act(@Param(ints = {-1, 0, 1, 2, 3}) int value) {
                return value < 0 ? "negative" : value % 2 != 0 && value != 3 ? "one" : value == 0 ? "zero" : "other";
            }
        });
    }

    @Test
    public void nestRight() {
        test(new Scriptable() {

            @Debuggable
            public String act(int value) {
                return value == 0 ? "zero" : value == 1 ? "one" : "other";
            }
        });
    }

    @Test
    public void nestLeft() {
        test(new Scriptable() {

            @Debuggable
            public String act(int value) {
                return 0 < value ? value == 1 ? "one" : "other" : "negative";
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

    @Test
    public void afterLogicalExpression() {
        test(new Scriptable() {

            @Debuggable
            public int act(int value) {
                boolean result = value % 2 == 0;
                return result ? value : value + 1;
            }
        });
    }
}
