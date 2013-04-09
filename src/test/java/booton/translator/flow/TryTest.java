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
 * @version 2013/01/11 16:57:25
 */
@SuppressWarnings("unused")
public class TryTest extends ScriptTester {

    @Test
    public void TryCatch() {
        test(new Scriptable() {

            @Debuggable
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

    @Test
    public void TryCatchAfter() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    if (value % 2 == 0) {
                        throw new Error();
                    }
                    value += 1;
                } catch (Error e) {
                    value += 2;
                }
                return value;
            }
        });
    }

    @Test
    public void TryEmptyCatch() {
        test(new Scriptable() {

            private int number = 10;

            @Debuggable
            public int act(int value) {
                try {
                    if (value == 0) {
                        throw new Error();
                    }
                    number = value;
                } catch (Error e) {
                    // do nothing
                }
                return number;
            }
        });
    }

    @Test
    public void TryMultipleCatch() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 5) int value) {
                try {
                    if (value == 2) {
                        throw new Error();
                    }

                    if (value == 3) {
                        throw new Exception();
                    }

                    return value + 1;
                } catch (Exception e) {
                    return 2;
                } catch (Error e) {
                    return 3;
                }
            }
        });
    }

    @Test
    public void TryCatchInCatch() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    if (value % 2 == 0) {
                        throw new Error();
                    }
                    return value + 1;
                } catch (Error e) {
                    try {
                        if (value % 3 == 0) {
                            throw new Error();
                        }
                        return value + 2;
                    } catch (Error e2) {
                        return value + 3;
                    }
                }
            }
        });
    }

    @Test
    public void TryCatchInTry() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    if (value % 2 == 0) {
                        throw new Exception();
                    }

                    try {
                        if (value % 3 == 0) {
                            throw new Error();
                        }
                    } catch (Error e) {
                        return value + 1;
                    }
                    return value + 2;
                } catch (Exception e) {
                    return value + 3;
                }
            }
        });
    }

    @Test
    public void TryCatchFromDepth() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    return compute(value);
                } catch (Exception e) {
                    return value + 10;
                }
            }

            private int compute(int value) throws Exception {
                if (value % 2 == 0) {
                    throw new Exception();
                }
                return value;
            }
        });
    }

    @Test
    public void TryCatchWithFrameFull() {
        test(new Scriptable() {

            public int act(int value) {
                for (int i = 0; i < 1; i++) {
                    value++;
                }

                try {
                    return value;
                } catch (Exception e) {
                    return 10; // unexecutable
                }

            }
        });
    }

    @Test
    public void TryCatchSequencial() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 3) int value) {
                try {
                    if (value == 0) {
                        throw new Error();
                    }
                } catch (Error e) {
                    return -1;
                }

                try {
                    if (value == 3) {
                        throw new Error();
                    }
                } catch (Error e) {
                    return -1;
                }
                return value;
            }
        });
    }

    @Test
    public void TryFinally() {
        test(new Scriptable() {

            private int number = 10;

            @Debuggable
            public int act(int value) {
                try {
                    set(value);
                } catch (Error e) {
                    // do nothing
                }
                return number;
            }

            @Debuggable
            private void set(int value) {
                try {
                    if (value == 0) {
                        throw new Error();
                    }
                    number = value;
                } finally {
                    number++;
                }
            }
        });
    }

    @Test
    public void TryCatchFinally() {
        test(new Scriptable() {

            @Debuggable
            public int act(int value) {
                try {
                    if (value == 0) {
                        throw new Error();
                    }
                    value++;
                } catch (Error e) {
                    value--;
                } finally {
                    value = value + 10;
                }
                return value;
            }
        });
    }
}
