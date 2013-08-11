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

import org.junit.Test;

import booton.translator.Debuggable;
import booton.translator.Param;
import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/11/30 15:32:37
 */
@SuppressWarnings("unused")
public class LogicalExpressionInControlStructureTest extends ScriptTester {

    @Test
    public void Or() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                if (value == 1 || value == 3) {
                    return value;
                } else {
                    return 0;
                }
            }
        });
    }

    @Test
    public void Complex() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                if ((value == 1 || value == 3) && value == 10) {
                    return value;
                } else {
                    return 0;
                }
            }
        });
    }

    @Test
    public void Complex2() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                if ((value == 1 || value == 3) && value == 10) {
                    return value;
                } else {
                    return 0;
                }
            }
        });
    }

    @Test
    public void NotOr() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                if (value != 1 || value == 3) {
                    return value;
                } else {
                    return 0;
                }
            }
        });
    }

    @Test
    public void OrNot() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                if (value == 1 || value != 3) {
                    return value;
                } else {
                    return 0;
                }
            }
        });
    }

    @Test
    public void NotOrNot() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                if (value != 1 || value != 3) {
                    return value;
                } else {
                    return 0;
                }
            }
        });
    }

    @Test
    public void MultipuleOR() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                if (value == 1 || value == 3 || value == 5) {
                    return value;
                } else {
                    return 0;
                }
            }
        });
    }

    @Test
    public void And() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 20) int value) {
                if (value % 2 == 0 && value % 3 == 0) {
                    return value;
                } else {
                    return 0;
                }
            }
        });
    }

    @Test
    public void NotAnd() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 20) int value) {
                if (value % 2 != 0 && value % 3 == 0) {
                    return value;
                } else {
                    return 0;
                }
            }
        });
    }

    @Test
    public void AndNot() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 20) int value) {
                if (value % 2 == 0 && value % 3 != 0) {
                    return value;
                } else {
                    return 0;
                }
            }
        });
    }

    @Test
    public void NotAndNot() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 20) int value) {
                if (value % 2 != 0 && value % 3 != 0) {
                    return value;
                } else {
                    return 0;
                }
            }
        });
    }

    @Test
    public void MultipleAnd() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 20) int value) {
                if (value % 2 == 0 && value % 3 == 0 && value % 4 == 0) {
                    return value;
                } else {
                    return 0;
                }
            }
        });
    }

    @Test
    public void nest() {
        test(new Scriptable() {

            @Debuggable
            public int act(@Param(from = 0, to = 10) int value) {
                if (1 < value && value <= 10) {
                    while (value % 3 != 0) {
                        if (value == 5) {
                            return 100;
                        }
                        value++;
                    }
                }

                return value;
            }
        });
    }
}
