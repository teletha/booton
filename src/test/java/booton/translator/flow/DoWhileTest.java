/*
 * Copyright (C) 2014 Nameless Production Committee
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
import booton.translator.Debuggable;

/**
 * @version 2014/01/16 22:36:52
 */
@SuppressWarnings("unused")
public class DoWhileTest extends ScriptTester {

    @Test
    public void normal() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                do {
                    value++;
                } while (value < 3);

                return value;
            }
        });
    }

    @Test
    public void equivalent() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                while (true) {
                    value++;

                    if (3 <= value) {
                        break;
                    }
                }

                return value;
            }
        });
    }

    @Test
    public void complexCondition() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                do {
                    value += 2;
                } while (++value < 4 || ++value % 3 == 0);

                return value;
            }
        });
    }

    @Test
    public void breakNoLabel() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                do {
                    value++;

                    if (value == 2) {
                        break;
                    }
                    value++;
                } while (value < 4);

                return value;
            }
        });
    }

    @Test
    public void breakInfinite() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                do {
                    value++;

                    if (value == 10) {
                        break;
                    }
                } while (true);

                return value;
            }
        });
    }

    @Test
    public void continueNoLabel() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                do {
                    value += 2;

                    if (value == 2) {
                        continue;
                    }

                    value += 3;
                } while (value < 4);

                return value;
            }
        });
    }

    @Test
    public void continueAndBreak() {
        test(new Scriptable() {

            public int act(int value) {
                do {
                    value++;

                    if (value % 2 == 0) {
                        continue;
                    }

                    if (value < 0) {
                        break;
                    }
                    value++;
                } while (value < 4);

                return value;
            }
        });
    }

    @Test
    public void oneLiner() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                // @formatter:off
                do {value+= 2;} while (value < 3);
                // @formatter:on
                return value;
            }
        });
    }

    @Test
    public void oneLinerComplexCondition() throws Exception {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                // @formatter:off
                do {value += 2;} while (++value < 10 && value % 2 == 0);
                // @formatter:on
                return value;
            }
        });
    }

    @Test
    public void inIf() throws Exception {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                if (value != 3) {
                    do {
                        value += 2;
                    } while (value < 5);
                }
                return value;
            }
        });
    }

    @Test
    public void inIfOneLiner() throws Exception {
        test(new Scriptable() {

            public int act(int value) {
                if (value != 0) {
                    // @formatter:off
                    do {value += 2;} while (value < 3);           
                    // @formatter:on
                }
                return value;
            }
        });
    }

    @Test
    public void continueThenFollow() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                do {
                    value += 5;

                    if (value % 2 == 0) {
                        if (value % 3 == 0) {
                            continue;
                        }
                        value++;
                    }
                    value += 3;
                } while (value < 10);

                return value;
            }
        });
    }

    @Test
    public void nestContinueJump() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                root: do {
                    value += 2;

                    if (value % 2 == 0) {
                        if (value % 3 == 0) {
                            continue;
                        }
                        value++;
                    }

                    do {
                        value++;

                        if (value % 3 == 0) {
                            continue root;
                        }
                    } while (value < 7);
                } while (value < 10);

                return value;
            }
        });
    }
}
