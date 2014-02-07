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

import booton.soeur.Param;
import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2014/02/07 12:58:30
 */
@SuppressWarnings("unused")
public class ShortArrayTest extends ScriptTester {

    @Test
    public void base() {
        test(new Scriptable() {

            public short[] act() {
                short[] array = new short[2];
                array[0] = 1;
                array[1] = 2;

                return array;
            }
        });
    }

    @Test
    public void multipleAssign() throws Exception {
        test(new Scriptable() {

            public short[] act() {
                short[] array = new short[3];
                array[0] = array[1] = array[2] = 3;

                return array;
            }
        });
    }

    @Test
    public void ArrayByShorthand() {
        test(new Scriptable() {

            public short[] act() {
                return new short[] {1, 2};
            }
        });
    }

    @Test
    public void ArrayByShorthandWithFirstZero() {
        test(new Scriptable() {

            public short[] act() {
                return new short[] {0, -1};
            }
        });
    }

    @Test
    public void ArrayByShorthandWithFirstZero2() {
        test(new Scriptable() {

            public short[] act() {
                return new short[] {0, 0, -1};
            }
        });
    }

    @Test
    public void ArrayByShorthandWithlastZero() {
        test(new Scriptable() {

            public short[] act() {
                return new short[] {-2, 0};
            }
        });
    }

    @Test
    public void ArrayByShorthandWithAllZero() {
        test(new Scriptable() {

            public short[] act() {
                return new short[] {0, 0};
            }
        });
    }

    @Test
    public void ArraySoMany() {
        test(new Scriptable() {

            public short[] act() {
                return new short[] {1, 2, 4, 8, 16, 32, 64, 32, 16, 8, 4, 2, 1};
            }
        });
    }

    @Test
    public void MultiDimensionArray() {
        test(new Scriptable() {

            public short[][] act() {
                short[][] array = new short[3][2];
                array[0] = new short[] {1, 2};
                array[1] = new short[] {3, 4};
                array[2] = new short[] {5, 6};

                return array;
            }
        });
    }

    @Test
    public void MultiDimensionArrayByShorthand() {
        test(new Scriptable() {

            public short[][] act() {
                return new short[][] { {0, 1}, {2, 3, 4}, {5, 6, 7, 8}};
            }
        });
    }

    @Test
    public void ThreeDimensionArray() {
        test(new Scriptable() {

            public short[][][] act() {
                short[][][] array = new short[2][3][1];
                array[0] = new short[][] { {0}, {2}, {1}};
                array[1] = new short[][] { {3}, {-1}, {1, 0, 1}};

                return array;
            }
        });
    }

    @Test
    public void ThreeDimensionArrayWithoutNeedlessDeclaration() {
        test(new Scriptable() {

            public short[][][] act() {
                short[][][] array = new short[2][][];
                array[0] = new short[][] { {0}, {2}, {1}};
                array[1] = new short[][] { {3}, {-1}, {1, 0, 1}};

                return array;
            }
        });
    }

    @Test
    public void ArrayAccess() {
        test(new Scriptable() {

            public short act(short value) {
                short[] array = {1, value};

                return array[1];
            }
        });
    }

    @Test
    public void ArrayLength() {
        test(new Scriptable() {

            public int act(@Param(ints = {0, 1, 10}) short value) {
                return new short[value].length;
            }
        });
    }

    @Test
    public void ArrayFor() {
        test(new Scriptable() {

            public short act(short value) {
                short sum = 0;
                short[] array = {0, 1, 2};

                for (int i = 0; i < array.length; i++) {
                    sum += array[i];
                }
                return sum;
            }
        });
    }

    @Test
    public void ArrayForEach() {
        test(new Scriptable() {

            public short act(short value) {
                short sum = 0;
                short[] array = {0, 1, 2};

                for (short i : array) {
                    sum += i;
                }
                return sum;
            }
        });
    }

    @Test
    public void SplitLine() {
        test(new Scriptable() {

            public int act() {
                short sum = 0;
                short[] array = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1};

                for (short i : array) {
                    sum += i;
                }
                return sum;
            }
        });
    }
}
