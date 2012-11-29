/*
 * Copyright (C) 2009 Nameless Production Committee.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package booton.translator;

import org.junit.Test;

import booton.translator.api.IntScript;

/**
 * @version 2009/08/05 17:47:47
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
