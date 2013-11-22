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
 * @version 2013/11/22 11:21:48
 */
@SuppressWarnings("unused")
public class IntArrayTest extends ScriptTester {

    @Test
    public void base() {
        test(new Scriptable() {

            public int[] act() {
                int[] array = new int[2];
                array[0] = 1;
                array[1] = 2;

                return array;
            }
        });
    }

    @Test
    public void withExpression() {
        test(new Scriptable() {

            private int field = 10;

            public int[] act() {
                int[] array = new int[4];
                array[0] = field + field;
                array[1] = field - field;
                array[2] = field * field;
                array[3] = field / field;

                return array;
            }
        });
    }

    @Test
    public void shorthand() {
        test(new Scriptable() {

            public int[] act() {
                return new int[] {1, 2};
            }
        });
    }

    @Test
    public void shorthandWithFirstZero() {
        test(new Scriptable() {

            public int[] act() {
                return new int[] {0, -1};
            }
        });
    }

    @Test
    public void shorthandWithFirstZero2() {
        test(new Scriptable() {

            public int[] act() {
                return new int[] {0, 0, -1};
            }
        });
    }

    @Test
    public void shorthandWithlastZero() {
        test(new Scriptable() {

            public int[] act() {
                return new int[] {-2, 0};
            }
        });
    }

    @Test
    public void shorthandWithAllZero() {
        test(new Scriptable() {

            public int[] act() {
                return new int[] {0, 0};
            }
        });
    }

    @Test
    public void expressionByShorthand() {
        test(new Scriptable() {

            private int field = 10;

            public int[] act() {
                return new int[] {field + field, field - field, field * field, field / field};
            }
        });
    }

    @Test
    public void many() {
        test(new Scriptable() {

            public int[] act() {
                return new int[] {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
            }
        });
    }

    @Test
    public void multiDimensionArray() {
        test(new Scriptable() {

            public int[][] act() {
                int[][] array = new int[3][2];
                array[0] = new int[] {1, 2};
                array[1] = new int[] {3, 4};
                array[2] = new int[] {5, 6};

                return array;
            }
        });
    }

    @Test
    public void multiDimensionArrayByShorthand() {
        test(new Scriptable() {

            public int[][] act() {
                return new int[][] { {0, 1}, {2, 3, 4}, {5, 6, 7, 8}};
            }
        });
    }

    @Test
    public void threeDimensionArray() {
        test(new Scriptable() {

            public int[][][] act() {
                int[][][] array = new int[2][3][1];
                array[0] = new int[][] { {0}, {2}, {1}};
                array[1] = new int[][] { {3}, {-1}, {1, 0, 1}};

                return array;
            }
        });
    }

    @Test
    public void threeDimensionArrayWithoutNeedlessDeclaration() {
        test(new Scriptable() {

            public int[][][] act() {
                int[][][] array = new int[2][][];
                array[0] = new int[][] { {0}, {2}, {1}};
                array[1] = new int[][] { {3}, {-1}, {1, 0, 1}};

                return array;
            }
        });
    }

    @Test
    public void access() {
        test(new Scriptable() {

            public int act(int value) {
                int[] array = {1, value};

                return array[1];
            }
        });
    }

    @Test
    public void length() {
        test(new Scriptable() {

            public int act(@Param(ints = {0, 1, 10}) int value) {
                return new int[value].length;
            }
        });
    }

    @Test
    public void forBlock() {
        test(new Scriptable() {

            public int act(int value) {
                int sum = 0;
                int[] array = {0, 1, 2};

                for (int i = 0; i < array.length; i++) {
                    sum += array[i];
                }
                return sum;
            }
        });
    }

    @Test
    public void forEachBlock() {
        test(new Scriptable() {

            public int act(int value) {
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
    public void splitLine() {
        test(new Scriptable() {

            public int act() {
                int sum = 0;
                int[] array = {123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789,
                        123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789};

                for (int i : array) {
                    sum += i;
                }
                return sum;
            }
        });
    }

    @Test
    public void withShorthandExpression() {
        test(new Scriptable() {

            public int act() {
                int[] array = {1};
                array[0] += 10;

                return array[0];
            }
        });
    }
}
