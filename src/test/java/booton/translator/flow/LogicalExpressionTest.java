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

import booton.translator.Param;
import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/11/04 17:19:06
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
    public void OrWithOtherStatement() {
        test(new Scriptable() {

            public boolean act(int value) {
                int i = value;

                return i == 1 || i != -1;
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
    public void postIncrement() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 10) int value) {
                return value++ % 2 == 0 || value++ % 5 == 0;
            }
        });
    }

    @Test
    public void preIncrement() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 10) int value) {
                return ++value % 2 == 0 || ++value % 5 == 0;
            }
        });
    }

    @Test
    public void postDecrement() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 10) int value) {
                return value-- % 2 == 0 || value-- % 5 == 0;
            }
        });
    }

    @Test
    public void preDecrement() {
        test(new Scriptable() {

            public boolean act(@Param(from = 1, to = 10) int value) {
                return --value % 2 == 0 || --value % 5 == 0;
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

            public boolean act(@Param(from = 0, to = 48) int value) {
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

            public boolean act(@Param(from = 0, to = 48) int value) {
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

            public boolean act(@Param(from = 0, to = 48) int value) {
                return method((value % 4 == 0 || value % 3 == 0) && value % 2 == 0 || (value % 5 == 0 || value % 7 == 0) && value % 3 == 0);
            }

            private boolean method(boolean value) {
                return value;
            }
        });
    }

    @Test
    public void WithMethodCall() {
        test(new Scriptable() {

            public boolean act(@Param(from = 0, to = 12) int value) {
                return (value % 4 == 0 || method3(value)) && value % 2 == 0 || method5(value);
            }

            private boolean method3(int value) {
                return value % 3 == 0;
            }

            private boolean method5(int value) {
                return value % 5 == 0;
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

            public boolean act(@Param(from = 0, to = 24) int value) {
                boolean v = value % 2 == 0 || value % 3 == 0;

                return v;
            }
        });
    }

    @Test
    public void VariableComplex1() {
        test(new Scriptable() {

            public boolean act(@Param(from = 0, to = 24) int value) {
                boolean v = (value % 3 == 0 || value % 4 == 0) && value % 2 == 0;

                return v;
            }
        });
    }

    @Test
    public void VariableComplex2() {
        test(new Scriptable() {

            public boolean act(@Param(from = 0, to = 48) int value) {
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

            public int act(@Param(from = 0, to = 48) int value) {
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
    public void lfElseAfter() {
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
    public void IfNestComplex() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 10) int value) {
                if (value < 3 && 1 < value || value % 2 == 0) {
                    if (1 < value && value < 4) {
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
}
