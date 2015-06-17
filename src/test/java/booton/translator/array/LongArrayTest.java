/*
 * Copyright (C) 2015 Nameless Production Committee
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
 * @version 2014/02/07 12:59:28
 */
@SuppressWarnings("unused")
public class LongArrayTest extends ScriptTester {

    @Test
    public void base() {
        test(new Scriptable() {

            public long[] act() {
                long[] array = new long[2];
                array[0] = 1;
                array[1] = 2;

                return array;
            }
        });
    }

    @Test
    public void multipleAssign() throws Exception {
        test(new Scriptable() {

            public long[] act() {
                long[] array = new long[3];
                array[0] = array[1] = array[2] = 30230225454L;

                return array;
            }
        });
    }

    @Test
    public void ArrayWithExpression() {
        test(new Scriptable() {

            private long field = 12345678L;

            public long[] act() {
                long[] array = new long[4];
                array[0] = field + field;
                array[1] = field - field;
                array[2] = field * field;
                array[3] = field / field;

                return array;
            }
        });
    }

    @Test
    public void ArrayByShorthand() {
        test(new Scriptable() {

            public long[] act() {
                return new long[] {1, 2};
            }
        });
    }

    @Test
    public void ArrayByShorthandWithFirstZero() {
        test(new Scriptable() {

            public long[] act() {
                return new long[] {0L, -1L};
            }
        });
    }

    @Test
    public void ArrayByShorthandWithlastZero() {
        test(new Scriptable() {

            public long[] act() {
                return new long[] {-2L, 0L};
            }
        });
    }

    @Test
    public void ArrayByShorthandWithAllZero() {
        test(new Scriptable() {

            public long[] act() {
                return new long[] {0L, 0L};
            }
        });
    }

    @Test
    public void ArrayWithExpressionByShorthand() {
        test(new Scriptable() {

            private long field = 10;

            public long[] act() {
                return new long[] {field + field, field - field, field * field, field / field};
            }
        });
    }

    @Test
    public void ArraySoMany() {
        test(new Scriptable() {

            public long[] act() {
                return new long[] {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
            }
        });
    }

    @Test
    public void MultiDimensionArray() {
        test(new Scriptable() {

            public long[][] act() {
                long[][] array = new long[3][2];
                array[0] = new long[] {1, 2};
                array[1] = new long[] {3, 4};
                array[2] = new long[] {5, 6};

                return array;
            }
        });
    }

    @Test
    public void MultiDimensionArrayByShorthand() {
        test(new Scriptable() {

            public long[][] act() {
                return new long[][] { {0, 1}, {2, 3, 4}, {5, 6, 7, 8}};
            }
        });
    }

    @Test
    public void ArrayAccess() {
        test(new Scriptable() {

            public long act(long value) {
                long[] array = {1, value};

                return array[1];
            }
        });
    }

    @Test
    public void ArrayLength() {
        test(new Scriptable() {

            public int act(@Param(ints = {0, 1, 10}) int value) {
                return new long[value].length;
            }
        });
    }

    @Test
    public void withShorthandExpression() {
        test(new Scriptable() {

            public long act() {
                long[] array = {1};
                array[0] += 10;

                return array[0];
            }
        });
    }
}
