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

import booton.translator.ScriptTranslatorTestcase;
import booton.translator.api.BooleanScript;
import booton.translator.api.IntScript;
import booton.translator.api.LogicalExpressionScript;
import booton.translator.api.ObjectScript;

/**
 * @version 2012/11/30 15:32:43
 */
public class LogicalExpressionTest extends ScriptTranslatorTestcase {

    @Test
    public void True() {
        assertScript(new BooleanScript() {

            public boolean execute(boolean value) {
                return true;
            }
        });
    }

    @Test
    public void False() {
        assertScript(new BooleanScript() {

            public boolean execute(boolean value) {
                return false;
            }
        });
    }

    @Test
    public void Equal() {
        assertScript(new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value == 1;
            }
        });
    }

    @Test
    public void Not() {
        assertScript(new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value != 1;
            }
        });
    }

    @Test
    public void Or() {
        assertScript(new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value == 1 || value == -1;
            }
        });
    }

    @Test
    public void NotOr() {
        assertScript(new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value != 1 || value == -1;
            }
        });
    }

    @Test
    public void OrNot() {
        assertScript(new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value == 1 || value != -1;
            }
        });
    }

    @Test
    public void NotOrNot() {
        assertScript(new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value != 1 || value != -1;
            }
        });
    }

    @Test
    public void MultipleOr() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 2 == 0 || value % 3 == 0 || value % 5 == 0;
            }
        });
    }

    @Test
    public void And() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 2 == 0 && value % 3 == 0;
            }
        });
    }

    @Test
    public void NotAnd() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 2 != 0 && value % 3 == 0;
            }
        });
    }

    @Test
    public void AndNot() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 2 == 0 && value % 3 != 0;
            }
        });
    }

    @Test
    public void NotAndNot() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 2 != 0 && value % 3 != 0;
            }
        });
    }

    @Test
    public void MultipleAnd() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 2 == 0 && value % 3 == 0 && value % 4 == 0;
            }
        });
    }

    @Test
    public void Complex1() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 5 == 0 || value % 3 == 0 && value % 4 == 0;
            }
        });
    }

    @Test
    public void Complex2() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 5 == 0 || (value % 3 == 0 && value % 4 == 0);
            }
        });
    }

    @Test
    public void Complex3() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return (value % 5 == 0 || value % 3 == 0) && value % 2 == 0;
            }
        });
    }

    @Test
    public void Complex4() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 2 == 0 && value % 3 == 0 || value % 4 == 0;
            }
        });
    }

    @Test
    public void Complex5() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return (value % 2 == 0 && value % 3 == 0) || value % 4 == 0;
            }
        });
    }

    @Test
    public void Complex6() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 3 == 0 && (value % 2 == 0 || value % 5 == 0);
            }
        });
    }

    @Test
    public void Complex10() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 5 == 0 && value % 3 == 0 || value % 2 == 0 || value % 7 == 0;
            }
        });
    }

    @Test
    public void Complex11() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 5 == 0 || value % 3 == 0 && value % 2 == 0 || value % 7 == 0;
            }
        });
    }

    @Test
    public void Complex12() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 5 == 0 || value % 3 == 0 || value % 2 == 0 && value % 7 == 0;
            }
        });
    }

    @Test
    public void Complex13() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return (value % 5 == 0 || value % 3 == 0 || value % 7 == 0) && value % 2 == 0;
            }
        });
    }

    @Test
    public void Complex14() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return (value % 5 == 0 && value % 3 == 0) || (value % 7 == 0 && value % 2 == 0);
            }
        });
    }

    @Test
    public void Complex20() {
        assertScript(1, 48, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return (value % 3 == 0 && value % 4 == 0) || (value % 7 == 0 || value % 6 == 0) && value % 5 == 0;
            }
        });
    }

    @Test
    public void Complex21() {
        assertScript(1, 48, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return ((value % 3 == 0 && value % 4 == 0) || (value % 7 == 0 || value % 6 == 0)) && value % 5 == 0;
            }
        });
    }

    @Test
    public void Complex22() {
        assertScript(1, 48, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return (value % 3 == 0 || value % 4 == 0) && (value % 5 == 0 || value % 6 == 0) && value % 2 == 0;
            }
        });
    }

    @Test
    public void Complex23() {
        assertScript(1, 48, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return ((value % 3 == 0 || value % 4 == 0) && (value % 7 == 0 || value % 11 == 0)) || value % 5 == 0;
            }
        });
    }

    @Test
    public void Complex24() {
        assertScript(1, 128, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 5 == 0 && ((value % 3 == 0 && value % 4 == 0) || (value % 7 == 0 || value % 6 == 0));
            }
        });
    }

    @Test
    public void Complex25() {
        assertScript(1, 128, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return ((value % 3 == 0 && value % 4 == 0) || (value % 7 == 0 && value % 6 == 0)) && value % 5 == 0;
            }
        });
    }

    @Test
    public void Complex26() {
        assertScript(1, 128, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return (value % 3 == 0 && value % 4 == 0) || (value % 7 == 0 && value % 6 == 0) && value % 5 == 0;
            }
        });
    }

    @Test
    public void Complex27() {
        assertScript(1, 128, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 3 == 0 || value % 4 == 0 || value % 7 == 0 && (value % 6 == 0 || value % 5 == 0);
            }
        });
    }

    @Test
    public void Complex28() {
        assertScript(1, 128, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return (value % 11 == 0 || value % 7 == 0) && ((value % 3 == 0 && value % 2 == 0) || value % 5 == 0);
            }
        });
    }

    @Test
    public void Complex29() {
        assertScript(1, 128, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 7 == 0 || (value % 3 == 0 || value % 2 == 0) && value % 5 == 0;
            }
        });
    }

    @Test
    public void Complex30() {
        assertScript(1, 128, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 7 == 0 && (value % 3 == 0 && value % 2 == 0 || value % 5 == 0);
            }
        });
    }

    @Test
    public void Complex31() {
        assertScript(1, 128, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return value % 7 == 0 && (value % 5 == 0 || value % 3 == 0) && value % 2 == 0;
            }
        });
    }

    @Test
    public void IfOr() {
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
                if (value == 1 || value == 3) {
                    return 10;
                } else {
                    return 20;
                }
            }
        });
    }

    @Test
    public void IfAnd() {
        assertScript(0, 12, new IntScript() {

            public int execute(int value) {
                if (value % 2 == 0 && value % 3 == 0) {
                    return 10;
                } else {
                    return 20;
                }
            }
        });
    }

    @Test
    public void IfComplex1() {
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
                if ((value == 3 || value == 4) && value % 2 == 0) {
                    return value;
                } else {
                    return 0;
                }
            }
        });
    }

    @Test
    public void IfComplex2() {
        assertScript(0, 48, new IntScript() {

            public int execute(int value) {
                if ((value % 3 == 0 && value % 4 == 0) || (value % 7 == 0 || value % 6 == 0) && value % 5 == 0) {
                    return value;
                } else {
                    return 0;
                }
            }
        });
    }

    @Test
    public void MethodOr() {
        assertScript(1, 5, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return method(value == 1 || value == 2);
            }

            private boolean method(boolean value) {
                return value;
            }
        });
    }

    @Test
    public void MethodAnd() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return method(value % 2 == 0 && value % 3 == 0);
            }

            private boolean method(boolean value) {
                return value;
            }
        });
    }

    @Test
    public void MethodComplex1() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return method((value % 4 == 0 || value % 3 == 0) && value % 2 == 0);
            }

            private boolean method(boolean value) {
                return value;
            }
        });
    }

    @Test
    public void MethodComplex2() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                return method((value % 4 == 0 || value % 3 == 0) && value % 2 == 0 || (value % 5 == 0 || value % 7 == 0) && value % 3 == 0);
            }

            private boolean method(boolean value) {
                return value;
            }
        });
    }

    @Test
    public void VariableOr() {
        assertScript(1, 5, new LogicalExpressionScript() {

            public boolean execute(int value) {
                boolean v = value == 1 || value == 2;

                return v;
            }
        });
    }

    @Test
    public void VariableAnd() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                boolean v = value % 2 == 0 || value % 3 == 0;

                return v;
            }
        });
    }

    @Test
    public void VariableComplex1() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                boolean v = (value % 3 == 0 || value % 4 == 0) && value % 2 == 0;

                return v;
            }
        });
    }

    @Test
    public void VariableComplex2() {
        assertScript(1, 24, new LogicalExpressionScript() {

            public boolean execute(int value) {
                boolean v = (value % 3 == 0 || value % 4 == 0) && value % 2 == 0 || value % 5 == 0 && (value % 2 == 0 || value % 3 == 0);

                return v;
            }
        });
    }

    @Test
    public void ConditionalOperator() {
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
                return value == 1 ? 20 : value;
            }
        });
    }

    @Test
    public void ConditionalOperatorLogicalSum() {
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
                return value == 1 || value == 2 ? 20 : value;
            }
        });
    }

    @Test
    public void ConditionalOperatorComplex() {
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
                return (value % 2 == 0 || value % 3 == 0) && value % 5 == 0 ? value + 1 : value + 2;
            }
        });
    }

    @Test
    public void ConditionalOperatorNest1() {
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
                return value % 2 == 0 ? value == 2 ? 20 : 10 : value;
            }
        });
    }

    @Test
    public void ConditionalOperatorNest2() {
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
                return value == 1 || value == 2 ? value == 1 ? 20 : 10 : value;
            }
        });
    }

    @Test
    public void ConditionalOperatorNest3() {
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
                return value % 2 == 0 ? value == 2 || value == 4 ? 20 : 10 : value;
            }
        });
    }

    @Test
    public void ConditionalOperatorNest4() {
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
                return value == 0 ? 20 : value == 1 ? 10 : value;
            }
        });
    }

    @Test
    public void ConditionalOperatorNest5() {
        assertScript(0, 100, new IntScript() {

            public int execute(int value) {
                return value % 2 == 0 ? value % 3 == 0 || value % 4 == 0 && (value % 5 == 0 || value % 7 == 0) ? 20
                        : 10 : value;
            }
        });
    }

    @Test
    public void ConditionalOperatorWithIf() {
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
                if (value % 2 == 0 || value % 3 == 0) {
                    return value == 4 ? 20 : 10;
                } else {
                    return value;
                }
            }
        });
    }

    @Test
    public void ConditionalOperatorInMethod() {
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
                return method(value == 1 ? value + 1 : value + 2);
            }

            private int method(int test) {
                return test + 1;
            }
        });
    }

    @Test
    public void ConditionalOperatorWithLogicalSumInMethod() {
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
                return method(value == 1 || value == 2 ? value + 1 : value + 2);
            }

            private int method(int test) {
                return test + 1;
            }
        });
    }

    @Test
    public void ConditionalOperatorComplexInMethod() {
        assertScript(1, 24, new IntScript() {

            public int execute(int value) {
                return method((value % 2 == 0 || value % 3 == 0) && value % 4 == 0 ? value + 1 : value + 2);
            }

            private int method(int test) {
                return test + 1;
            }
        });
    }

    @Test
    public void Anonymous() {
        assertScript(new ObjectScript<String>() {

            public String execute(String value) {
                return new Object() {

                    public String toString() {
                        return "Anonymous";
                    };
                }.toString();
            }
        });
    }

    @Test
    public void IntArrayForEach() {
        assertScript(1, 10, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                int sum = 0;
                int[] array = {0, 1, 2};

                for (int i : array) {
                    sum += i;
                }
                return sum;
            }
        });
    }

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

    @Test
    @Ignore
    public void TryCatchAfter() {
        assertScript(0, 10, new IntScript() {

            public int execute(int value) {
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
    @Ignore
    public void TryMultipleCatch() {
        assertScript(0, 5, new IntScript() {

            public int execute(int value) {
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
    @Ignore
    public void TryCatchInCatch() {
        assertScript(0, 10, new IntScript() {

            public int execute(int value) {
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
    @Ignore
    public void TryCatchInTry() {
        assertScript(0, 10, new IntScript() {

            public int execute(int value) {
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

    /**
     * <pre>
     * 0 (1c2 1f3)
     * |      \
     * 5+1   6t
     * |
     * 1+3
     * |
     * 7r
     * 
     * 2s2 (4f3)
     * |
     * 8+2
     * |
     * 4+3
     * |
     * 9r
     * 
     * 3s3
     * |
     * 10+3
     * |
     * 11t3
     * </pre>
     */
    @Test
    @Ignore
    public void TryCatchFinally() {
        assertScript(0, 10, new IntScript() {

            private int counter = 0;

            public int execute(int value) {
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
    @Ignore
    public void TryCatchFinallyNodes() {
        assertScript(0, 10, new IntScript() {

            private int counter = 0;

            public int execute(int value) {
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

    /**
     * <pre>
     * 0 (1c2 3f4)
     * |         \
     * 5+1      6t
     * |
     * 1
     * |
     * 7g
     * 
     * 2s2
     * |
     * 8+2
     * |
     * 3+3
     * |
     * 9g
     * 
     * 4s3
     * |
     * 10+3
     * |
     * 11t3
     * 
     * 7+3
     * |
     * 9r
     * </pre>
     */
    @Test
    @Ignore
    public void TryCatchFinallyAfter() {
        assertScript(0, 10, new IntScript() {

            public int execute(int value) {
                try {
                    if (value == 0) {
                        throw new Error();
                    }
                    value += 1;
                } catch (Error e) {
                    value += 2;
                } finally {
                    value += 3;
                }
                return value;
            }
        });
    }

    @Test
    @Ignore
    public void TryFinallyAfterNest() {
        assertScript(0, 10, new IntScript() {

            private int id = 0;

            public int execute(int value) {
                count(value);

                return id;
            }

            private int count(int value) {
                try {
                    if (value % 2 == 0) {
                        return 0;
                    }

                    id += 1;
                } finally {
                    id += 2;
                }
                return 0;
            }
        });
    }

    @Test
    @Ignore
    public void TryFinallyAfterNest2() {
        assertScript(0, 10, new IntScript() {

            private int id = 0;

            public int execute(int value) {
                count(value);

                return id;
            }

            private int count(int value) {
                try {
                    try {
                        if (value % 2 == 0) {
                            throw new Exception();
                        }

                        id += 1;
                    } catch (Exception e) {
                        return id += 2;
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
    @Ignore
    public void TryCatchFinallyAfterNestAtFinally() {
        assertScript(0, 10, new IntScript() {

            public int execute(int value) {
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

    /**
     * <pre>
     * 0+1 (1f1)
     * 2g
     * 
     * 1s2
     * 3+2
     * 4t2
     * 
     * 2+2
     * 5r
     * </pre>
     */
    @Test
    @Ignore
    public void TryFinallyAfter() {
        assertScript(0, 3, new IntScript() {

            public int execute(int value) {
                try {
                    value += 1;
                } finally {
                    value += 2;
                }
                return value;
            }
        });
    }

    /**
     * <pre>
     * 0 (1f1)
     * |         \
     * 2+2    3+1
     * |           |
     * 4g      4g
     * 
     * 1s2
     * |
     * 5
     * |       \
     * 6+4   7+3
     * |          |
     * 8t2    8g
     * 
     * 4
     * |       \
     * 9+4  10+3
     * |       \
     * 11    11g
     * |
     * 12
     * </pre>
     */
    @Test
    @Ignore
    public void TryFinallyAfterWithNodes() {
        assertScript(0, 10, new IntScript() {

            public int execute(int value) {
                try {
                    if (value % 2 == 0) {
                        value += 1;
                    } else {
                        value += 2;
                    }
                } finally {
                    if (value % 3 == 0) {
                        value += 3;
                    } else {
                        value += 4;
                    }
                }

                if (value % 5 == 0) {
                    value += 5;
                } else {
                    value += 6;
                }
                return value;
            }
        });
    }

    @Test
    @Ignore
    public void TryFinallyNest1() {
        assertScript(0, 10, new IntScript() {

            public int execute(int value) {
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
    @Ignore
    public void TryFinallyNest2() {
        assertScript(0, 10, new IntScript() {

            public int execute(int value) {
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
    @Ignore
    public void TryFinallyNest3() {
        assertScript(0, 10, new IntScript() {

            public int execute(int value) {
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
}
