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

import org.junit.Ignore;
import org.junit.Test;

import booton.translator.api.IntScript;

/**
 * @version 2009/06/29 13:49:20
 */
public class ControlStructureTest extends ScriptTranslatorTestcase {

    @Test
    public void If() {
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                if (value < 3) {
                    return 2;
                }
                return 1;
            }
        });
    }

    @Test
    public void IfThen() {
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                if (value < 3) {
                    value++;
                }
                return value;
            }
        });
    }

    @Test
    public void IfThenNest1() {
        assertScript(0, 10, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 10, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                while (value < 3) {
                    value++;
                }

                return value;
            }
        });
    }

    @Test
    public void WhileBreak() {
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 10, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 10, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(1, 10, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                do {
                    value++;
                } while (value < 3);

                return value;
            }
        });
    }

    @Test
    public void DoWhileEquivalent() {
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                for (int i = 0; i < 3; i++) {
                    value++;
                }

                return value;
            }
        });
    }

    @Test
    public void ForWithoutInitialize() {
        assertScript(0, 5, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 10, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 10, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 10, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 3, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 3, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 3, new IntScript() {

            public int execute(int value) {
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
        assertScript(0, 3, new IntScript() {

            public int execute(int value) {
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
