/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.array;

import org.junit.Test;

import booton.translator.Param;
import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/02/15 20:47:17
 */
@SuppressWarnings("unused")
public class BooleanArrayTest extends ScriptTester {

    @Test
    public void Array() {
        test(new Scriptable() {

            public boolean[] act() {
                boolean[] array = new boolean[2];
                array[0] = true;
                array[1] = false;

                return array;
            }
        });
    }

    @Test
    public void ArrayWithExpression() {
        test(new Scriptable() {

            private boolean field = true;

            public boolean[] act() {
                boolean[] array = new boolean[2];
                array[0] = field;
                array[1] = !field;

                return array;
            }
        });
    }

    @Test
    public void ArrayByShorthand() {
        test(new Scriptable() {

            public boolean[] act() {
                return new boolean[] {true, false};
            }
        });
    }

    @Test
    public void ArrayByShorthandWithAllFalse() {
        test(new Scriptable() {

            public boolean[] act() {
                return new boolean[] {false, false};
            }
        });
    }

    @Test
    public void ArrayWithExpressionByShorthand() {
        test(new Scriptable() {

            private boolean field = true;

            public boolean[] act() {
                return new boolean[] {field, !field};
            }
        });
    }

    @Test
    public void ArraySoMany() {
        test(new Scriptable() {

            public boolean[] act() {
                return new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true};
            }
        });
    }

    @Test
    public void MultiDimensionArray() {
        test(new Scriptable() {

            public boolean[][] act() {
                boolean[][] array = new boolean[3][2];
                array[0] = new boolean[] {true, true};
                array[1] = new boolean[] {true, true};
                array[2] = new boolean[] {true, true};

                return array;
            }
        });
    }

    @Test
    public void MultiDimensionArrayByShorthand() {
        test(new Scriptable() {

            public boolean[][] act() {
                return new boolean[][] { {true, true}, {true, true}, {true, true}};
            }
        });
    }

    @Test
    public void ThreeDimensionArray() {
        test(new Scriptable() {

            public boolean[][][] act() {
                boolean[][][] array = new boolean[2][3][1];
                array[0] = new boolean[][] { {true}, {false}, {true}};
                array[1] = new boolean[][] { {true}, {false}, {true, false, false}};

                return array;
            }
        });
    }

    @Test
    public void ThreeDimensionArrayWithoutNeedlessDeclaration() {
        test(new Scriptable() {

            public boolean[][][] act() {
                boolean[][][] array = new boolean[2][][];
                array[0] = new boolean[][] { {true}, {false}, {true}};
                array[1] = new boolean[][] { {true}, {false}, {true, false, false}};

                return array;
            }
        });
    }

    @Test
    public void ArrayAccess() {
        test(new Scriptable() {

            public boolean act(boolean value) {
                boolean[] array = {false, value};

                return array[1];
            }
        });
    }

    @Test
    public void ArrayLength() {
        test(new Scriptable() {

            public int act(@Param(ints = {0, 1, 10}) int value) {
                return new boolean[value].length;
            }
        });
    }

    @Test
    public void ArrayFor() {
        test(new Scriptable() {

            public int act(boolean value) {
                int sum = 0;
                boolean[] array = {true, false, true};

                for (int i = 0; i < array.length; i++) {
                    if (array[i]) {
                        sum++;
                    }
                }
                return sum;
            }
        });
    }

    @Test
    public void ArrayForEach() {
        test(new Scriptable() {

            public int act(boolean value) {
                int sum = 0;
                boolean[] array = {true, false, true};

                for (boolean i : array) {
                    if (i) {
                        sum++;
                    }
                }
                return sum;
            }
        });
    }
}
