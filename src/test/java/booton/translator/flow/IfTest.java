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

import booton.soeur.Param;
import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2013/08/11 9:53:05
 */
@SuppressWarnings("unused")
public class IfTest extends ScriptTester {

    @Test
    public void normal() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                if (value < 3) {
                    return 2;
                }
                return 1;
            }
        });
    }

    @Test
    public void then() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                if (value < 3) {
                    value++;
                }
                return value;
            }
        });
    }

    @Test
    public void thenNest() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                if (value < 5) {
                    value += 1;

                    if (value < 5) {
                        value += 2;
                    }
                }
                return value;
            }
        });
    }

    @Test
    public void thenNestImmidiately() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                if (value < 5) {
                    if (value < 3) {
                        value += 1;
                    }
                    value += 2;
                }
                return value;
            }
        });
    }

    @Test
    public void nestReturn() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                if (value < 3) {
                    if (1 < value) {
                        return 0;
                    }
                    return 2;
                }
                return 1;
            }
        });
    }

    @Test
    public void nestComplexLogicalExpression() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                if (value < 3 && 1 < value || value % 2 == 0) {
                    if (1 < value && value < 2) {
                        return 0;
                    } else {
                        return 11;
                    }
                }
                return 1;
            }
        });
    }

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
    public void shorthandLine() throws Exception {
        test(new Scriptable() {

            public int act(int o) {
                if (o == 2) // need line
                    return o + 3;

                return o;
            }
        });
    }

    @Test
    public void shorthandElse() throws Exception {
        test(new Scriptable() {

            public int act(int o) {
                if (o == 2)
                    return o + 3;
                else
                    return o;
            }
        });
    }

    @Test
    public void shorthandMultiple() throws Exception {
        test(new Scriptable() {

            public int act(int o) {
                if (o == 2)
                    return o + 3;
                else if (o == 1)
                    return -10;
                else
                    return o;
            }
        });
    }

    @Test
    public void shorthandWithExpression() throws Exception {
        test(new Scriptable() {

            public int act(int o) {
                if (o == 2) o = o + 3;

                return o;
            }
        });
    }

    @Test
    public void shorthandElseWithExpression() throws Exception {
        test(new Scriptable() {

            public int act(int o) {
                if (o == 2)
                    o = o + 3;
                else
                    o = o + 10;
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
    public void shorthandInNest() throws Exception {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int o) {
                while (o < 10) {
                    o++;
                    if (o % 2 == 0) {
                        if (o % 3 == 0) return -100;
                    } else if (o % 5 == 0) return -10;
                }
                return o;
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

    @Test
    public void oneLiner() throws Exception {
        test(new Scriptable() {

            public int act(int o) {
                // @formatter:off
                if (o == 2) {return o + 3;} else {return o;}
                // @formatter:on
            }
        });
    }

    @Test
    public void denyInElse() throws Exception {
        test(new Scriptable() {

            boolean act(String attrs) {
                if (attrs == null) {
                    return attrs != null;
                } else {
                    return !attrs.equals("");
                }
            }
        });
    }

    @Test
    public void whileElse() throws Exception {
        test(new Scriptable() {

            private boolean flag;

            String act(String attrs) {
                if (attrs == null) {
                    attrs = "huu";
                } else {
                    while (flag) {
                    }
                    attrs = "ok";
                }
                return attrs;
            }
        });
    }

    @Test
    public void multipleInWhile() throws Exception {
        test(new Scriptable() {

            int act(int value) {
                while (value++ < 5) {
                    if (value != 0 && value != 1 && value != 2) {
                        value += 4;
                    }
                }
                return value;
            }

        });
    }
}
