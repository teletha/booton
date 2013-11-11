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

import org.junit.Ignore;
import org.junit.Test;

import booton.translator.Debuggable;
import booton.translator.Param;
import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/10/09 15:55:09
 */
@SuppressWarnings("unused")
public class ForTest extends ScriptTester {

    @Test
    public void normal() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                for (int i = 0; i < 3; i++) {
                    value++;
                }

                return value;
            }
        });
    }

    @Test
    public void withoutInitialize() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                int i = 0;
                value++;

                for (; i < 3; i++) {
                    value++;
                }

                return value;
            }
        });
    }

    @Test
    public void withoutUpdate() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                for (int i = 0; i < 8;) {
                    i = value;
                    value += 2;

                    if (value == 5) {
                        break;
                    }
                }

                return value;
            }
        });
    }

    @Test
    public void afterProcess() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                String name = "act";

                for (int i = 0; i < name.length(); i++) {
                    value++;
                }

                return value;
            }
        });
    }

    @Test
    public void noneReturnCodeAfterLoopWillConfuseCompiler() throws Exception {
        test(new Scriptable() {

            String act() {
                int m = 0;

                for (int i = 0; i < 3; i++) {
                    m++;
                }
                String.valueOf(m); // noise

                return String.valueOf(m);
            }
        });
    }

    @Test
    public void breakNoLabel() {
        test(new Scriptable() {

            public int act(@Param(from = 8, to = 10) int value) {
                for (int i = 0; i < 3; i++) {
                    value++;

                    if (value == 10) {
                        value += 10;
                        break;
                    }
                }
                return value;
            }
        });
    }

    @Test
    public void continueNoLabel() {
        test(new Scriptable() {

            public int act(@Param(from = 1, to = 10) int value) {
                for (int i = 0; i < 3; i++) {
                    value++;

                    if (value % 2 == 0) {
                        continue;
                    }
                    value += 3;
                }
                return value;
            }
        });
    }

    @Test
    public void continueNest() throws Exception {
        test(new Scriptable() {

            int act(int value) {
                root: for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (i == 1) {
                            continue root;
                        }
                        value++;
                    }
                    value++;
                }
                return value;
            }
        });
    }

    @Test
    public void continueMultiple() throws Exception {
        test(new Scriptable() {

            int act(int value) {
                root: for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (i == 1) {
                            continue root;
                        }
                        value++;

                        if (i == 2) {
                            continue root;
                        }
                        value++;
                    }
                    value++;
                }
                return value;
            }
        });
    }

    @Test
    public void returnNest() throws Exception {
        test(new Scriptable() {

            int act(int value) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (i == 1) {
                            return 100;
                        }
                        value++;
                    }
                    value++;
                }
                return value;
            }
        });
    }

    @Test
    @Ignore
    public void continueWithLogicalExpressionFail() throws Exception {
        test(new Scriptable() {

            int act(int value) {
                root: for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 4; j++) {
                        value++;

                        if ((i + j) % 3 == 0) {
                            continue root;
                        }
                    }
                }
                return value;
            }
        });
    }

    @Test
    public void continueWithLogicalExpressionAndAfterProcess() throws Exception {
        test(new Scriptable() {

            int act(int value) {
                root: for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 4; j++) {
                        if ((i + j) % 3 == 0) {
                            continue root;
                        }
                        value++;
                    }
                }
                return value;
            }
        });
    }

    @Test
    @Ignore
    public void continueWithLogicalExpression() throws Exception {
        test(new Scriptable() {

            int act(int value) {
                for (int i = 0; i < 3; i++) {
                    value++;

                    if (i == -1 || value % 5 == 0) {
                        continue;
                    }
                    value++;
                }
                return value;
            }
        });
    }

    @Test
    public void returnInNest() throws Exception {
        test(new Scriptable() {

            int act(int value) {
                if (value == 0) {
                    value++;
                } else {
                    for (int i = 0; i < 3; i++) {
                        value++;

                        if (i == -1 || value % 5 == 0) {
                            return 1000;
                        }
                    }
                }
                return value;
            }
        });
    }

    @Test
    public void complex() throws Exception {
        test(new Scriptable() {

            int act(int value) {
                for (int j = 0; j < 2; j++) {
                    if (value % 2 == 0) {
                        if (value % 3 == 0) {
                            value += 100;
                        } else if (value % 4 == 0) {
                            value += 200;
                        }
                    }
                    value += 2;
                }
                return value;
            }
        });
    }

    @Test
    @Ignore
    public void infinite() throws Exception {
        test(new Scriptable() {

            @Debuggable
            int act(int value) {
                for (;;) {
                    value++;

                    if (value % 5 == 0) {
                        return value;
                    } else {
                        if (value % 9 == 0) {
                            return value;
                        } else {
                            value++;
                        }
                    }
                }
            }
        });
    }
}
