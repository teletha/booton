/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.array;

import org.junit.Test;

import booton.translator.api.Param;
import booton.translator.api.ScriptTester;
import booton.translator.api.Scriptable;

/**
 * @version 2012/12/01 3:04:06
 */
@SuppressWarnings("unused")
public class FloatArrayTest extends ScriptTester {

    @Test
    public void FloatArray() {
        test(new Scriptable() {

            public float[] act() {
                float[] array = new float[2];
                array[0] = 1.1f;
                array[1] = 2.2f;

                return array;
            }
        });
    }

    @Test
    public void FloatArrayWithExpression() {
        test(new Scriptable() {

            private float field = 3.14f;

            public float[] act() {
                float[] array = new float[4];
                array[0] = field + field;
                array[1] = field - field;
                array[2] = field * field;
                array[3] = field / field;

                return array;
            }
        });
    }

    @Test
    public void FloatArrayByShorthand() {
        test(new Scriptable() {

            public float[] act() {
                return new float[] {1.5f, -1.5f};
            }
        });
    }

    @Test
    public void FloatArrayByShorthandWithFirstZero() {
        test(new Scriptable() {

            public float[] act() {
                return new float[] {0.0f, 0.3f};
            }
        });
    }

    @Test
    public void FloatArrayByShorthandWithlastZero() {
        test(new Scriptable() {

            public float[] act() {
                return new float[] {0.1f, 0f};
            }
        });
    }

    @Test
    public void FloatArrayByShorthandWithAllZero() {
        test(new Scriptable() {

            public float[] act() {
                return new float[] {0.0f, -0.0f};
            }
        });
    }

    @Test
    public void FloatArrayWithExpressionByShorthand() {
        test(new Scriptable() {

            private float field = 0.002f;

            public float[] act() {
                return new float[] {field + field, field - field, field * field, field / field};
            }
        });
    }

    @Test
    public void FloatArraySoMany() {
        test(new Scriptable() {

            public float[] act() {
                return new float[] {0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f};
            }
        });
    }

    @Test
    public void FloatArrayAccess() {
        test(new Scriptable() {

            public float act(float value) {
                float[] array = {1, value};

                return array[1];
            }
        });
    }

    @Test
    public void FloatMultiDimensionArray() {
        test(new Scriptable() {

            public float[][] act() {
                float[][] array = new float[3][2];
                array[0] = new float[] {1, 2};
                array[1] = new float[] {3, 4};
                array[2] = new float[] {5, 6};

                return array;
            }
        });
    }

    @Test
    public void FloatMultiDimensionArrayByShorthand() {
        test(new Scriptable() {

            public float[][] act() {
                return new float[][] { {0, 1}, {2, 3, 4}, {5, 6, 7, 8}};
            }
        });
    }

    @Test
    public void FloatArrayLength() {
        test(new Scriptable() {

            public int act(@Param(ints = {0, 1, 10}) int value) {
                return new float[value].length;
            }
        });
    }
}
