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
 * @version 2012/12/01 12:28:09
 */
@SuppressWarnings("unused")
public class LogicalExpressionTest extends ScriptTester {

    @Test
    public void True() {
        test(new Scriptable() {

            public boolean act() {
                return true;
            }
        });
    }

    @Test
    public void False() {
        test(new Scriptable() {

            public boolean act() {
                return false;
            }
        });
    }

    @Test
    public void Equal() {
        test(new Scriptable() {

            public boolean act(int value) {
                return value == 1;
            }
        });
    }

    @Test
    public void Not() {
        test(new Scriptable() {

            public boolean act(int value) {
                return value != 1;
            }
        });
    }

    @Test
    public void Or() {
        test(new Scriptable() {

            public boolean act(int value) {
                return value == 1 || value == -1;
            }
        });
    }

    @Test
    public void NotOr() {
        test(new Scriptable() {

            public boolean act(int value) {
                return value != 1 || value == -1;
            }
        });
    }

    @Test
    public void OrNot() {
        test(new Scriptable() {

            public boolean act(int value) {
                return value == 1 || value != -1;
            }
        });
    }

    @Test
    public void NotOrNot() {
        test(new Scriptable() {

            public boolean act(int value) {
                return value != 1 || value != -1;
            }
        });
    }

    @Test
    public void MultipleOr() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return value % 2 == 0 || value % 3 == 0 || value % 5 == 0;
            }
        });
    }

    @Test
    public void And() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return value % 2 == 0 && value % 3 == 0;
            }
        });
    }

    @Test
    public void NotAnd() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return value % 2 != 0 && value % 3 == 0;
            }
        });
    }

    @Test
    public void AndNot() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return value % 2 == 0 && value % 3 != 0;
            }
        });
    }

    @Test
    public void NotAndNot() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return value % 2 != 0 && value % 3 != 0;
            }
        });
    }

    @Test
    public void MultipleAnd() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return value % 2 == 0 && value % 3 == 0 && value % 4 == 0;
            }
        });
    }

    @Test
    public void Complex1() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return value % 5 == 0 || value % 3 == 0 && value % 4 == 0;
            }
        });
    }

    @Test
    public void Complex2() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return value % 5 == 0 || (value % 3 == 0 && value % 4 == 0);
            }
        });
    }

    @Test
    public void Complex3() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return (value % 5 == 0 || value % 3 == 0) && value % 2 == 0;
            }
        });
    }

    @Test
    public void Complex4() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return value % 2 == 0 && value % 3 == 0 || value % 4 == 0;
            }
        });
    }

    @Test
    public void Complex5() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return (value % 2 == 0 && value % 3 == 0) || value % 4 == 0;
            }
        });
    }

    @Test
    public void Complex6() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return value % 3 == 0 && (value % 2 == 0 || value % 5 == 0);
            }
        });
    }

    @Test
    public void Complex10() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return value % 5 == 0 && value % 3 == 0 || value % 2 == 0 || value % 7 == 0;
            }
        });
    }

    @Test
    public void Complex11() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return value % 5 == 0 || value % 3 == 0 && value % 2 == 0 || value % 7 == 0;
            }
        });
    }

    @Test
    public void Complex12() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return value % 5 == 0 || value % 3 == 0 || value % 2 == 0 && value % 7 == 0;
            }
        });
    }

    @Test
    public void Complex13() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return (value % 5 == 0 || value % 3 == 0 || value % 7 == 0) && value % 2 == 0;
            }
        });
    }

    @Test
    public void Complex14() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 24) int value) {
                return (value % 5 == 0 && value % 3 == 0) || (value % 7 == 0 && value % 2 == 0);
            }
        });
    }

    @Test
    public void Complex20() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 48) int value) {
                return (value % 3 == 0 && value % 4 == 0) || (value % 7 == 0 || value % 6 == 0) && value % 5 == 0;
            }
        });
    }

    @Test
    public void Complex21() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 48) int value) {
                return ((value % 3 == 0 && value % 4 == 0) || (value % 7 == 0 || value % 6 == 0)) && value % 5 == 0;
            }
        });
    }

    @Test
    public void Complex22() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 48) int value) {
                return (value % 3 == 0 || value % 4 == 0) && (value % 5 == 0 || value % 6 == 0) && value % 2 == 0;
            }
        });
    }

    @Test
    public void Complex23() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 48) int value) {
                return ((value % 3 == 0 || value % 4 == 0) && (value % 7 == 0 || value % 11 == 0)) || value % 5 == 0;
            }
        });
    }

    @Test
    public void Complex24() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 128) int value) {
                return value % 5 == 0 && ((value % 3 == 0 && value % 4 == 0) || (value % 7 == 0 || value % 6 == 0));
            }
        });
    }

    @Test
    public void Complex25() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 128) int value) {
                return ((value % 3 == 0 && value % 4 == 0) || (value % 7 == 0 && value % 6 == 0)) && value % 5 == 0;
            }
        });
    }

    @Test
    public void Complex26() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 128) int value) {
                return (value % 3 == 0 && value % 4 == 0) || (value % 7 == 0 && value % 6 == 0) && value % 5 == 0;
            }
        });
    }

    @Test
    public void Complex27() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 128) int value) {
                return value % 3 == 0 || value % 4 == 0 || value % 7 == 0 && (value % 6 == 0 || value % 5 == 0);
            }
        });
    }

    @Test
    public void Complex28() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 128) int value) {
                return (value % 11 == 0 || value % 7 == 0) && ((value % 3 == 0 && value % 2 == 0) || value % 5 == 0);
            }
        });
    }

    @Test
    public void Complex29() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 128) int value) {
                return value % 7 == 0 || (value % 3 == 0 || value % 2 == 0) && value % 5 == 0;
            }
        });
    }

    @Test
    public void Complex30() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 128) int value) {
                return value % 7 == 0 && (value % 3 == 0 && value % 2 == 0 || value % 5 == 0);
            }
        });
    }

    @Test
    public void Complex31() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 128) int value) {
                return value % 7 == 0 && (value % 5 == 0 || value % 3 == 0) && value % 2 == 0;
            }
        });
    }

    @Test
    public void IfOr() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
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
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 12) int value) {
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
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
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
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 48) int value) {
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
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 5) int value) {
                return method(value == 1 || value == 2);
            }

            private boolean method(boolean value) {
                return value;
            }
        });
    }

    @Test
    public void MethodAnd() {
        test(new Scriptable() {

            public boolean act(int value) {
                return method(value % 2 == 0 && value % 3 == 0);
            }

            private boolean method(boolean value) {
                return value;
            }
        });
    }

    @Test
    public void MethodComplex1() {
        test(new Scriptable() {

            public boolean act(int value) {
                return method((value % 4 == 0 || value % 3 == 0) && value % 2 == 0);
            }

            private boolean method(boolean value) {
                return value;
            }
        });
    }

    @Test
    public void MethodComplex2() {
        test(new Scriptable() {

            public boolean act(int value) {
                return method((value % 4 == 0 || value % 3 == 0) && value % 2 == 0 || (value % 5 == 0 || value % 7 == 0) && value % 3 == 0);
            }

            private boolean method(boolean value) {
                return value;
            }
        });
    }

    @Test
    public void VariableOr() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 5) int value) {
                boolean v = value == 1 || value == 2;

                return v;
            }
        });
    }

    @Test
    public void VariableAnd() {
        test(new Scriptable() {

            public boolean act(int value) {
                boolean v = value % 2 == 0 || value % 3 == 0;

                return v;
            }
        });
    }

    @Test
    public void VariableComplex1() {
        test(new Scriptable() {

            public boolean act(int value) {
                boolean v = (value % 3 == 0 || value % 4 == 0) && value % 2 == 0;

                return v;
            }
        });
    }

    @Test
    public void VariableComplex2() {
        test(new Scriptable() {

            public boolean act(int value) {
                boolean v = (value % 3 == 0 || value % 4 == 0) && value % 2 == 0 || value % 5 == 0 && (value % 2 == 0 || value % 3 == 0);

                return v;
            }
        });
    }

    @Test
    public void ConditionalOperator() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                return value == 1 ? 20 : value;
            }
        });
    }

    @Test
    public void ConditionalOperatorLogicalSum() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                return value == 1 || value == 2 ? 20 : value;
            }
        });
    }

    @Test
    public void ConditionalOperatorComplex() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                return (value % 2 == 0 || value % 3 == 0) && value % 5 == 0 ? value + 1 : value + 2;
            }
        });
    }

    @Test
    public void ConditionalOperatorNest1() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                return value % 2 == 0 ? value == 2 ? 20 : 10 : value;
            }
        });
    }

    @Test
    public void ConditionalOperatorNest2() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                return value == 1 || value == 2 ? value == 1 ? 20 : 10 : value;
            }
        });
    }

    @Test
    public void ConditionalOperatorNest3() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                return value % 2 == 0 ? value == 2 || value == 4 ? 20 : 10 : value;
            }
        });
    }

    @Test
    public void ConditionalOperatorNest4() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                return value == 0 ? 20 : value == 1 ? 10 : value;
            }
        });
    }

    @Test
    public void ConditionalOperatorNest5() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 100) int value) {
                return value % 2 == 0 ? value % 3 == 0 || value % 4 == 0 && (value % 5 == 0 || value % 7 == 0) ? 20
                        : 10 : value;
            }
        });
    }

    @Test
    public void ConditionalOperatorWithIf() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
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
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                return method(value == 1 ? value + 1 : value + 2);
            }

            private int method(int test) {
                return test + 1;
            }
        });
    }

    @Test
    public void ConditionalOperatorWithLogicalSumInMethod() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                return method(value == 1 || value == 2 ? value + 1 : value + 2);
            }

            private int method(int test) {
                return test + 1;
            }
        });
    }

    @Test
    public void ConditionalOperatorComplexInMethod() {
        test(new Scriptable() {

            public int act(int value) {
                return method((value % 2 == 0 || value % 3 == 0) && value % 4 == 0 ? value + 1 : value + 2);
            }

            private int method(int test) {
                return test + 1;
            }
        });
    }

    @Test
    public void Anonymous() {
        test(new Scriptable() {

            public String act() {
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
        test(new Scriptable() {

            public int act(@Param(from = 1, to = 10) int value) {
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

            /**
             * @see booton.translator.api.Scriptable#act(int)
             */
            public int act(int value) {
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

    @Test
    @Ignore
    public void TryCatchAfter() {
        test(new Scriptable() {

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
    @Ignore
    public void TryMultipleCatch() {
        test(new Scriptable() {

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
    @Ignore
    public void TryCatchInCatch() {
        test(new Scriptable() {

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
    @Ignore
    public void TryCatchInTry() {
        test(new Scriptable() {

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
    @Ignore
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
                }
                return value;
            }
        });
    }

    @Test
    @Ignore
    public void TryFinallyAfterNest() {
        test(new Scriptable() {

            private int id = 0;

            public int act(@Param(from = 0, to = 10) int value) {
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
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 3) int value) {
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
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
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
    @Ignore
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
    @Ignore
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
}
