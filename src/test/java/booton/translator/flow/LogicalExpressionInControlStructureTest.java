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

import booton.translator.ScriptTranslatorTestcase;
import booton.translator.api.IntScript;

/**
 * @version 2012/11/30 15:32:37
 */
public class LogicalExpressionInControlStructureTest extends ScriptTranslatorTestcase {

    @Test
    public void Or() {
        test(0, 5, new IntScript() {

            public int act(int value) {
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
        test(0, 5, new IntScript() {

            public int act(int value) {
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
        test(0, 5, new IntScript() {

            public int act(int value) {
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
        test(0, 5, new IntScript() {

            public int act(int value) {
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
        test(0, 5, new IntScript() {

            public int act(int value) {
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
        test(0, 5, new IntScript() {

            public int act(int value) {
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
        test(0, 5, new IntScript() {

            public int act(int value) {
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
        test(0, 20, new IntScript() {

            public int act(int value) {
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
        test(0, 20, new IntScript() {

            public int act(int value) {
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
        test(0, 20, new IntScript() {

            public int act(int value) {
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
        test(0, 20, new IntScript() {

            public int act(int value) {
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
        test(0, 20, new IntScript() {

            public int act(int value) {
                if (value % 2 == 0 && value % 3 == 0 && value % 4 == 0) {
                    return value;
                } else {
                    return 0;
                }
            }
        });
    }
}
