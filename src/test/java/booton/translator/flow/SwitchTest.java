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
 * @version 2013/04/08 14:28:16
 */
@SuppressWarnings("unused")
public class SwitchTest extends ScriptTester {

    @Test
    public void Return() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                switch (value) {
                case 0:
                    return 0;

                case 1:
                    return 1;

                default:
                    return value + 5;
                }
            }
        });
    }

    @Test
    public void Sparse() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                switch (value) {
                case 0:
                    return 0;

                case 2:
                    return 1;

                case 4:
                    return 10;

                default:
                    return value + 5;
                }
            }
        });
    }

    @Test
    public void NoDefault() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                switch (value) {
                case 0:
                    return 0;

                case 2:
                    return 12;

                case 4:
                    return 10;
                }
                return value + 10;
            }
        });
    }

    @Test
    public void EmptyDefault() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                switch (value) {
                case 0:
                    value = 10;
                    break;

                case 2:
                    value = 20;
                    break;

                default:
                    break;
                }
                return value + 10;
            }
        });
    }

    @Test
    public void Multiple() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                switch (value) {
                case 0:
                case 1:
                    return 0;

                case 5:
                    return 1;

                default:
                    return value + 5;
                }
            }
        });
    }

    @Test
    public void Nest() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                switch (value) {
                case 0:
                case 3:
                    switch (value) {
                    case 3:
                        return 20;

                    default:
                        return 100;
                    }

                case 5:
                    return 1;

                default:
                    return value + 5;
                }
            }
        });
    }

    @Test
    public void StrangeOrder() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                switch (value) {
                default:
                    return value + 5;

                case 1:
                    return 1;

                case 0:
                    return 0;
                }
            }
        });
    }

    @Test
    public void Break() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                int result;

                switch (value) {
                case 0:
                    result = -1;
                    break;

                case 1:
                    result = -2;
                    break;

                default:
                    result = value;
                    break;
                }
                return result;
            }
        });
    }

    @Test
    public void BreakNoDefault() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                int result = 100;

                switch (value) {
                case 0:
                    result = -1;
                    break;

                case 1:
                    result = -2;
                    break;
                }
                return result;
            }
        });
    }

    @Test
    public void BreakNoDefaultInOtherFlow() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                int result = 100;

                if (value != 4) {
                    switch (value) {
                    case 0:
                        result = -1;
                        break;

                    case 1:
                        result = -2;
                        break;
                    }
                }
                return result;
            }
        });
    }

    @Test
    public void BreakNoDefaultInNestedOtherFlow() {
        test(new Scriptable() {

            public int act(int value) {
                for (int i = 0; i < 3; i++) {
                    if (value != 2) {
                        switch (value) {
                        case 1:
                            value++;
                            break;
                        }
                    }
                }
                return value;
            }
        });
    }

    @Test
    public void BreakNoDefaultInNestedOtherFlow2() {
        test(new Scriptable() {

            public int act(int value) {
                for (int i = 0; i < 3; i++) {
                    if (value != 2) {
                        switch (value) {
                        case 1:
                            value++;
                            break;
                        }
                        value += 3;
                    }
                }
                return value;
            }
        });
    }

    @Test
    public void BreakAndReturn() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                int result;

                switch (value) {
                case 0:
                    return 10;

                case 1:
                    result = -2;
                    break;

                default:
                    result = value;
                    break;
                }

                return result;
            }
        });
    }

    @Test
    public void breakToOutside() throws Exception {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 3) int value) {
                int result = 0;

                root: while (result < 7) {
                    switch (value) {
                    case 0:
                        return 10;

                    case 1:
                        result = -1;
                        break root;

                    case 2:
                        result += 3;
                        break;

                    default:
                        result++;
                        break;
                    }
                }
                return result;
            }
        });
    }

    @Test
    public void Enum0() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 2) int value) {
                Number number = Number.values()[value];

                switch (number) {
                case Four:
                    return 40;

                case Three:
                    return 30;

                default:
                    return 1;
                }
            }
        });
    }

    @Test
    public void Enum1() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 2) int value) {
                Number[] numbers = Number.values();

                switch (numbers[value]) {
                case Four:
                    return 40;

                case Three:
                    return 30;

                default:
                    return 1;
                }
            }
        });
    }

    @Test
    public void Enum2() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 2) int value) {
                switch (Number.values()[value]) {
                case Four:
                    return 40;

                case Three:
                    return 30;

                default:
                    return 1;
                }
            }
        });
    }

    /**
     * @version 2013/01/23 15:24:08
     */
    private static enum Number {
        One, Two, Three, Four, Five;
    }
}
