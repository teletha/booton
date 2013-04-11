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
 * @version 2013/04/11 11:23:21
 */
@SuppressWarnings("unused")
public class TryTest extends ScriptTester {

    /**
     * @version 2013/04/10 14:51:57
     */
    private static class Throw {

        private static int error(int value) {
            if (value % 2 == 0) {
                throw new Error();
            }
            return value + 1000;
        }

        private static int exception(int value) throws Exception {
            if (value % 3 == 0) {
                throw new Exception();
            }
            return value + 100000;
        }
    }

    @Test
    public void TryCatch() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    return Throw.error(value);
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
                    value = Throw.error(value);
                } catch (Error e) {
                    value += 2;
                }
                return value;
            }
        });
    }

    @Test
    public void TryCatchAfter2() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    value = Throw.error(value);
                    value = Throw.error(value);
                } catch (Error e) {
                    value += 2;
                }
                return value;
            }
        });
    }

    @Test
    public void TryCatchAfter3() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    value = Throw.error(value);
                } catch (Error e) {
                    return 50;
                }
                return value;
            }
        });
    }

    @Test
    public void TryEmptyCatch() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    value = Throw.error(value);
                } catch (Error e) {
                    // do nothing
                }
                return value;
            }
        });
    }

    @Test
    public void TryMultipleCatch() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    value = Throw.error(value);
                    value = Throw.exception(value);

                    return value + 100;
                } catch (Exception e) {
                    return 2;
                } catch (Error e) {
                    return 3;
                }
            }
        });
    }

    @Test
    public void TryMultipleCatchAfter() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    value = Throw.error(value);
                    value = Throw.exception(value);
                } catch (Exception e) {
                    value = 20;
                } catch (Error e) {
                    value = 30;
                }
                return value;
            }
        });
    }

    @Test
    public void TryCatchInCatch() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    return Throw.error(value);
                } catch (Error e) {
                    try {
                        return Throw.exception(value);
                    } catch (Exception e2) {
                        return value;
                    }
                }
            }
        });
    }

    @Test
    public void TryCatchInCatchAfter() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    value = Throw.error(value);
                } catch (Error e) {
                    try {
                        value = Throw.exception(value);
                    } catch (Exception e2) {
                        value = value + 3;
                    }
                    value = value + 2;
                }
                return value + 1;
            }
        });
    }

    @Test
    public void TryCatchInTry() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    value = Throw.exception(value);

                    try {
                        value = Throw.error(value);
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
    public void TryCatchInTryAfter() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    value = Throw.exception(value);

                    try {
                        value = Throw.error(value);
                    } catch (Error e) {
                        value = value + 4;
                    }
                    value = value + 3;
                } catch (Exception e) {
                    value = value + 4;
                }
                return value + 1;
            }
        });
    }

    @Test
    public void TryCatchWithFrameFull() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
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

            @Debuggable
            public int act(@Param(from = 0, to = 3) int value) {
                try {
                    value = Throw.error(value);
                } catch (Error e) {
                    return -1;
                }

                try {
                    value = Throw.exception(value);
                } catch (Exception e) {
                    return -1;
                }
                return value;
            }
        });
    }

    @Test
    public void TryCatchFinallyAfter() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    value = Throw.error(value);
                } catch (Error e) {
                    value = value + 1;
                } finally {
                    value = value + 2;
                    value = value + 4;
                }
                return value;
            }
        });
    }

    @Test
    public void TryCatchFinallyReturnImmediately() {
        test(new Scriptable() {

            private int counter = 0;

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                return counter + calc(value);
            }

            @Debuggable
            private int calc(int value) {
                try {
                    return Throw.error(value);
                } catch (Error e) {
                    return 10;
                } finally {
                    counter = counter + 2;
                }
            }
        });
    }

    @Test
    public void TryCatchFinallyReturnImmediatelyWithAfter() {
        test(new Scriptable() {

            private int counter = 0;

            public int act(@Param(from = 0, to = 10) int value) {
                return counter + calc(value);
            }

            @Debuggable
            private int calc(int value) {
                try {
                    return Throw.error(value);
                } catch (Error e) {
                    value = value + 3;
                } finally {
                    counter = counter + 2;
                }
                return value + 1;
            }
        });
    }

    @Test
    public void TryFinally() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    value = error(value);
                } catch (Error e) {
                    // do nothing
                }
                return value;
            }

            @Debuggable
            private int error(int value) {
                try {
                    value = Throw.error(value);
                } finally {
                    value++;
                }
                return value;
            }
        });
    }

    @Test
    public void TryFinallyVoid() {
        test(new Scriptable() {

            private int counter = 0;

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    if (value != 0) {
                        error(value);
                    }
                } catch (Error e) {
                    // do nothing
                }
                return counter;
            }

            @Debuggable
            private void error(int value) {
                try {
                    counter = Throw.error(value);
                } finally {
                    counter++;
                }
            }
        });
    }
}
