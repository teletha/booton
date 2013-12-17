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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import booton.soeur.Param;
import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2013/04/11 19:55:53
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
            return value + 10000;
        }

        private static int io(int value) throws IOException {
            if (value % 4 == 0) {
                throw new IOException();
            }
            return value + 100000;
        }
    }

    @Test
    public void TryCatch() {
        test(new Scriptable() {

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
    public void TryEmptyCatchAfterThrow() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    return error(value);
                } catch (Error e) {
                    return -10;
                }
            }

            private int error(int value) {
                try {
                    if (value != 3) {
                        return Throw.exception(value);
                    }
                } catch (Exception e) {
                    // do nothing
                }
                throw new Error();
            }
        });
    }

    @Test
    public void TryMultipleCatch() {
        test(new Scriptable() {

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
    public void TryMultipleCatchInherited() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    value = Throw.io(value);
                    value = Throw.exception(value);
                } catch (IOException e) {
                    value = value + 2;
                } catch (Exception e) {
                    value = value + 3;
                }
                return value;
            }
        });
    }

    @Test
    public void TryMultipleCatchAfter() {
        test(new Scriptable() {

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
    public void TryCatchInTryImmediately() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    try {
                        value = Throw.error(value);
                    } catch (Error e) {
                        return value + 1;
                    }
                    return Throw.exception(value);
                } catch (Exception e) {
                    return value + 3;
                }
            }
        });
    }

    @Test
    public void TryCatchInTryAfter() {
        test(new Scriptable() {

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

            public int act(@Param(from = 0, to = 10) int value) {
                return counter + calc(value);
            }

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
    public void TryCatchFinallyAfterNestAtFinally() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    if (value == 0) {
                        throw new Error();
                    }
                    value += 1;
                } catch (Error e) {
                    value += 2;
                } finally {
                    value += 3;

                    try {
                        if (value % 2 == 0) {
                            throw new Error();
                        }
                        value += 4;
                    } catch (Error e) {
                        value += 5;
                    } finally {
                        value += 6;
                    }
                    value += 7;
                }
                return value;
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
    public void TryFinally2() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    value = error(value);
                } catch (Error e) {
                    // do nothing
                }
                return value;
            }

            private int error(int value) {
                try {
                    for (int i = 0; i < 3; i++) {
                        value = Throw.error(value);
                    }
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

            private void error(int value) {
                try {
                    counter = Throw.error(value);
                } finally {
                    counter++;
                }
            }
        });
    }

    @Test
    public void TryFinallyNest1() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    try {
                        value += 1;
                    } finally {
                        value += 2;
                    }
                } finally {
                    try {
                        value += 3;
                    } finally {
                        value += 4;
                    }
                }
                return value;
            }
        });
    }

    @Test
    public void TryFinallyNest2() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    value += 1;

                    try {
                        value += 2;
                    } finally {
                        value += 3;
                    }
                } finally {
                    value += 4;

                    try {
                        value += 5;
                    } finally {
                        value += 6;
                    }
                }
                return value;
            }
        });
    }

    @Test
    public void TryFinallyNest3() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                try {
                    try {
                        value += 1;
                    } finally {
                        value += 2;
                    }
                    value += 3;
                } finally {
                    try {
                        value += 4;
                    } finally {
                        value += 5;
                    }
                    value += 6;
                }
                return value;
            }
        });
    }

    @Test
    public void TryCatchFinally() {
        test(new Scriptable() {

            private int counter = 0;

            public int act(@Param(from = 0, to = 10) int value) {
                return count(value) + counter;
            }

            private int count(int value) {
                try {
                    if (value % 2 == 0) {
                        throw new Error();
                    }
                    return counter += 1;
                } catch (Error e) {
                    return counter += 2;
                } finally {
                    counter += 3;
                }
            }
        });
    }

    @Test
    public void TryCatchFinallyNodes() {
        test(new Scriptable() {

            private int counter = 0;

            public int act(@Param(from = 0, to = 10) int value) {
                return count(value) + counter;
            }

            private int count(int value) {
                try {
                    if (value % 2 == 0) {
                        throw new Error();
                    }
                    return counter += 1;
                } catch (Error e) {
                    return counter += 2;
                } finally {
                    if (counter % 3 == 0) {
                        counter += 3;
                    } else {
                        counter += 4;
                    }
                }
            }
        });
    }

    @Test
    public void TryFinallyAfterNest2() {
        test(new Scriptable() {

            private int id = 0;

            public int act(@Param(from = 0, to = 10) int value) {
                count(value);
                return id;
            }

            private int count(int value) {
                try {
                    try {
                        if (value % 2 == 0) {
                            throw new Exception();
                        }

                        id += value;
                    } catch (Exception e) {
                        return id += value * 2;
                    } finally {
                        id += 3;
                    }

                    id += 4;
                } finally {
                    id += 5;
                }
                return 0;
            }
        });
    }

    @Test
    public void insideFor() {
        test(new Scriptable() {

            public String act() {
                Map<String, String> map = new HashMap();
                map.put("1", "one");
                map.put("2", "two");
                String valeu = "";

                for (Entry<String, String> entry : map.entrySet()) {
                    try {
                        valeu += "1";
                    } catch (IllegalArgumentException e) {
                        valeu += "2";
                    }
                }
                return valeu;
            }
        });
    }
}
