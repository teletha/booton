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
 * @version 2013/02/25 18:20:26
 */
@SuppressWarnings("unused")
public class IfTest extends ScriptTester {

    @Test
    public void integer() throws Exception {
        test(new Scriptable() {

            public boolean act(int value) {
                if (value == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    @Test
    public void object() throws Exception {
        test(new Scriptable() {

            public boolean act(Object o) {
                if (o == null) {
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    @Test
    public void object2() throws Exception {
        test(new Scriptable() {

            public boolean act(Object o) {
                if (o != null) {
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    @Test
    public void ifelse() throws Exception {
        test(new Scriptable() {

            public int act(int o) {
                if (o == 2) {
                    return o + 3;
                } else {
                    return o;
                }
            }
        });
    }

    @Test
    public void multiple() throws Exception {
        test(new Scriptable() {

            @Debuggable
            public int act(int o) {
                if (o == 2) {
                    return o + 3;
                } else if (o == -2) {
                    return o;
                } else {
                    return o - 1;
                }
            }
        });
    }

    @Test
    public void sequence() throws Exception {
        test(new Scriptable() {

            @Debuggable
            public int act(int o) {
                if (o == 2) {
                    o = o + 1;
                }

                if (o == 3) {
                    o = o + 2;
                }

                if (o == 3) {
                    o = o + 3;
                }
                return o;
            }
        });
    }

    @Test
    public void ifelseWithFollowing() throws Exception {
        test(new Scriptable() {

            public int act(int o) {
                if (o == 2) {
                    o += 10;
                } else {
                    o += 2;
                }
                return o;
            }
        });
    }

    @Test
    public void shorthand() throws Exception {
        test(new Scriptable() {

            public int act(int o) {
                if (o == 2) return o + 3;
                return o;
            }
        });
    }

    @Test
    public void shorthandWithExpression3() throws Exception {
        test(new Scriptable() {

            @Debuggable
            public int act(int o) {
                return o == 2 ? 10 : o;
            }
        });
    }

    @Test
    public void shorthandWithExpression() throws Exception {
        test(new Scriptable() {

            @Debuggable
            public int act(int o) {
                if (o == 2) o = o + 3;

                return o;
            }
        });
    }

    @Test
    public void shorthandWithExpression2() throws Exception {
        test(new Scriptable() {

            @Debuggable
            public int act(int o) {
                if (o == 2) {
                    o = o + 3;
                }

                return o;
            }
        });
    }

    @Test
    public void shorthandInFlow() throws Exception {
        test(new Scriptable() {

            public boolean act(int o) {
                while (o < 4) {
                    o = o + 2;
                    if (o == 2) return true;
                }
                return false;
            }
        });
    }

    @Test
    public void noElse() throws Exception {
        test(new Scriptable() {

            public int act(int value) {
                int result = value;

                if (value == 1 || value == 3) {
                    result = -10;
                }
                return result;
            }
        });
    }
}
