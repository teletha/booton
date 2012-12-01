/*
 * Copyright (C) 2012 Nameless Production Committee
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

import booton.translator.api.Param;
import booton.translator.api.ScriptTester;
import booton.translator.api.Scriptable;

/**
 * @version 2012/11/30 15:32:30
 */
@SuppressWarnings("unused")
public class ControlStructureTest extends ScriptTester {

    @Test
    public void If() {
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
    public void IfThen() {
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
    public void IfThenNest1() {
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
    public void IfThenNest2() {
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
    public void IfElse() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                if (value < 3) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
    }

    @Test
    public void IfElseAfter() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                if (value < 3) {
                    value = 2;
                } else {
                    value = 0;
                }
                return value;
            }
        });
    }

    @Test
    public void IfNest() {
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
    public void IfNest2() {
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
    public void While() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                while (value < 3) {
                    value++;
                }

                return value;
            }
        });
    }

    @Test
    public void WhileBreak() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                while (value < 3) {
                    value++;

                    if (value == 1) {
                        break;
                    }
                }

                return value;
            }
        });
    }

    @Test
    public void WhileInfiniteBreak() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                while (true) {
                    value++;

                    if (value == 10) {
                        break;
                    }
                }

                return value;
            }
        });
    }

    @Test
    public void WhileMultipuleBreaks() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                while (value < 5) {
                    value++;

                    if (value == 1) {
                        break;
                    }

                    if (value == 7) {
                        break;
                    }
                }

                return value;
            }
        });
    }

    @Test
    public void WhileContinue() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                while (value < 3) {
                    value += 2;

                    if (value == 3) {
                        continue;
                    }
                    value += 2;
                }
                return value;
            }
        });
    }

    @Test
    public void WhileNest() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                while (value < 30) {
                    value += 10;

                    while (30 < value) {
                        value--;
                    }
                }

                return value;
            }
        });
    }

    @Test
    public void WhileLabeledBreak() {
        test(new Scriptable() {

            public int act(@Param(from = 1, to = 10) int value) {
                root: while (value < 100) {
                    value *= 2;

                    while (50 < value) {
                        value--;

                        if (value == 70) {
                            break root;
                        }
                    }

                    value *= 2;
                }

                return value;
            }
        });
    }

    @Test
    public void DoWhile() {
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
    public void DoWhileEquivalent() {
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

    public void DoWhileBreak() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                do {
                    value++;

                    if (value == 2) {
                        break;
                    }
                } while (value < 4);

                return value;
            }
        });
    }

    @Test
    public void DoWhileInfiniteBreak() {
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
    public void DoWhileContinue() {
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
    public void For() {
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
    public void ForWithoutInitialize() {
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
    public void ForWithoutUpdate() {
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
    public void ForBreak() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                for (int i = 0; i < 3; i++) {
                    value++;

                    if (value == 10) {
                        break;
                    }
                }

                return value;
            }
        });
    }

    @Test
    public void ForContinue() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                for (int i = 0; i < 3; i++) {
                    value++;

                    if (value == 10) {
                        continue;
                    }

                    value++;
                }

                return value;
            }
        });
    }

    @Test
    public void ForAfterProcess() {
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
    @Ignore
    public void SwitchReturn() {
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
    @Ignore
    public void SwitchReturnWithOrder() {
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
    @Ignore
    public void SwitchBreak() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                int result;

                switch (value) {
                case 0:
                    result = -1;
                    break;

                case 1:
                    result = 10;
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
    @Ignore
    public void TryCatch() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 3) int value) {
                try {
                    if (value == 0) {
                        throw new Error();
                    }
                    return value;
                } catch (Error e) {
                    return -1;
                }
            }
        });
    }

    @Ignore
    @Test
    public void TryCatchFinally() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 3) int value) {
                try {
                    if (value == 0) {
                        throw new Error();
                    }
                    value++;
                } catch (Error e) {
                    value = 10;
                } finally {
                    value += 5;
                }
                return value;
            }
        });
    }

    @Test
    @Ignore
    public void TryFinallyAfter() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 3) int value) {
                try {
                    value++;
                } finally {
                    value += 4;
                }
                return value;
            }
        });
    }

    @Test
    @Ignore
    public void TryMultipleCatch() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 3) int value) {
                try {
                    if (value == 2) {
                        throw new Error();
                    }

                    return 6 / value;
                } catch (ArithmeticException e) {
                    return -1;
                } catch (Error e) {
                    return -2;
                }
            }
        });
    }
}
