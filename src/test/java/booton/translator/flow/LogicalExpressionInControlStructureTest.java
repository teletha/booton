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
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 20, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 20, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 20, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 20, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 20, new IntScript() {

            public int execute(int value) {
                if (value % 2 == 0 && value % 3 == 0 && value % 4 == 0) {
                    return value;
                } else {
                    return 0;
                }
            }
        });
    }
}
