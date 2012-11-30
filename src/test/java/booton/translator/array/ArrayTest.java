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

import booton.translator.ScriptTranslatorTestcase;
import booton.translator.api.DoubleScript;
import booton.translator.api.FloatScript;
import booton.translator.api.IntScript;
import booton.translator.api.LongScript;
import booton.translator.api.ObjectScript;

/**
 * @version 2012/11/30 15:33:41
 */
public class ArrayTest extends ScriptTranslatorTestcase {

    @Test
    public void LongArray() {
        test(new ObjectScript<long[]>() {

            public long[] act(long[] value) {
                long[] array = new long[2];
                array[0] = 1;
                array[1] = 2;

                return array;
            }
        });
    }

    @Test
    public void LongArrayWithExpression() {
        test(new ObjectScript<long[]>() {

            private long field = 12345678L;

            public long[] act(long[] value) {
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
    public void LongArrayByShorthand() {
        test(new ObjectScript<long[]>() {

            public long[] act(long[] value) {
                return new long[] {1, 2};
            }
        });
    }

    @Test
    public void LongArrayByShorthandWithFirstZero() {
        test(new ObjectScript<long[]>() {

            public long[] act(long[] value) {
                return new long[] {0L, -1L};
            }
        });
    }

    @Test
    public void LongArrayByShorthandWithlastZero() {
        test(new ObjectScript<long[]>() {

            public long[] act(long[] value) {
                return new long[] {-2L, 0L};
            }
        });
    }

    @Test
    public void LongArrayByShorthandWithAllZero() {
        test(new ObjectScript<long[]>() {

            public long[] act(long[] value) {
                return new long[] {0L, 0L};
            }
        });
    }

    @Test
    public void LongArrayWithExpressionByShorthand() {
        test(new ObjectScript<long[]>() {

            private long field = 10;

            public long[] act(long[] value) {
                return new long[] {field + field, field - field, field * field, field / field};
            }
        });
    }

    @Test
    public void LongArraySoMany() {
        test(new ObjectScript<long[]>() {

            public long[] act(long[] value) {
                return new long[] {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
            }
        });
    }

    @Test
    public void LongMultiDimensionArray() {
        test(new ObjectScript<long[][]>() {

            public long[][] act(long[][] value) {
                long[][] array = new long[3][2];
                array[0] = new long[] {1, 2};
                array[1] = new long[] {3, 4};
                array[2] = new long[] {5, 6};

                return array;
            }
        });
    }

    @Test
    public void LongMultiDimensionArrayByShorthand() {
        test(new ObjectScript<long[][]>() {

            public long[][] act(long[][] value) {
                return new long[][] { {0, 1}, {2, 3, 4}, {5, 6, 7, 8}};
            }
        });
    }

    @Test
    public void LongArrayAccess() {
        test(new LongScript() {

            public long act(long value) {
                long[] array = {1, value};

                return array[1];
            }
        });
    }

    @Test
    public void LongArrayLength() {
        test(1, 10, new IntScript() {

            public int act(int value) {
                return new long[value].length;
            }
        });
    }

    @Test
    public void FloatArray() {
        test(new ObjectScript<float[]>() {

            public float[] act(float[] value) {
                float[] array = new float[2];
                array[0] = 1.1f;
                array[1] = 2.2f;

                return array;
            }
        });
    }

    @Test
    public void FloatArrayWithExpression() {
        test(new ObjectScript<float[]>() {

            private float field = 3.14f;

            public float[] act(float[] value) {
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
        test(new ObjectScript<float[]>() {

            public float[] act(float[] value) {
                return new float[] {1.5f, -1.5f};
            }
        });
    }

    @Test
    public void FloatArrayByShorthandWithFirstZero() {
        test(new ObjectScript<float[]>() {

            public float[] act(float[] value) {
                return new float[] {0.0f, 0.3f};
            }
        });
    }

    @Test
    public void FloatArrayByShorthandWithlastZero() {
        test(new ObjectScript<float[]>() {

            public float[] act(float[] value) {
                return new float[] {0.1f, 0f};
            }
        });
    }

    @Test
    public void FloatArrayByShorthandWithAllZero() {
        test(new ObjectScript<float[]>() {

            public float[] act(float[] value) {
                return new float[] {0.0f, -0.0f};
            }
        });
    }

    @Test
    public void FloatArrayWithExpressionByShorthand() {
        test(new ObjectScript<float[]>() {

            private float field = 0.002f;

            public float[] act(float[] value) {
                return new float[] {field + field, field - field, field * field, field / field};
            }
        });
    }

    @Test
    public void FloatArraySoMany() {
        test(new ObjectScript<float[]>() {

            public float[] act(float[] value) {
                return new float[] {0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f};
            }
        });
    }

    @Test
    public void FloatArrayAccess() {
        test(new FloatScript() {

            public float act(float value) {
                float[] array = {1, value};

                return array[1];
            }
        });
    }

    @Test
    public void FloatMultiDimensionArray() {
        test(new ObjectScript<float[][]>() {

            public float[][] act(float[][] value) {
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
        test(new ObjectScript<float[][]>() {

            public float[][] act(float[][] value) {
                return new float[][] { {0, 1}, {2, 3, 4}, {5, 6, 7, 8}};
            }
        });
    }

    @Test
    public void FloatArrayLength() {
        test(1, 10, new IntScript() {

            public int act(int value) {
                return new float[value].length;
            }
        });
    }

    @Test
    public void DoubleArray() {
        test(new ObjectScript<double[]>() {

            public double[] act(double[] value) {
                double[] array = new double[2];
                array[0] = 1.1d;
                array[1] = 2.2d;

                return array;
            }
        });
    }

    @Test
    public void DoubleArrayWithExpression() {
        test(new ObjectScript<double[]>() {

            private double field = 3.14d;

            public double[] act(double[] value) {
                double[] array = new double[4];
                array[0] = field + field;
                array[1] = field - field;
                array[2] = field * field;
                array[3] = field / field;

                return array;
            }
        });
    }

    @Test
    public void DoubleArrayByShorthand() {
        test(new ObjectScript<double[]>() {

            public double[] act(double[] value) {
                return new double[] {1.5d, -1.5d};
            }
        });
    }

    @Test
    public void DoubleArrayByShorthandWithFirstZero() {
        test(new ObjectScript<double[]>() {

            public double[] act(double[] value) {
                return new double[] {0.0d, 0.3d};
            }
        });
    }

    @Test
    public void DoubleArrayByShorthandWithlastZero() {
        test(new ObjectScript<double[]>() {

            public double[] act(double[] value) {
                return new double[] {0.1d, 0d};
            }
        });
    }

    @Test
    public void DoubleArrayByShorthandWithAllZero() {
        test(new ObjectScript<double[]>() {

            public double[] act(double[] value) {
                return new double[] {0.0d, -0.0d};
            }
        });
    }

    @Test
    public void DoubleArrayWithExpressionByShorthand() {
        test(new ObjectScript<double[]>() {

            private double field = 0.002000023d;

            public double[] act(double[] value) {
                return new double[] {field + field, field - field, field * field, field / field};
            }
        });
    }

    @Test
    public void StringArray() {
        test(new ObjectScript<String[]>() {

            public String[] act(String[] value) {
                String[] array = new String[2];
                array[0] = "1";
                array[1] = "2";

                return array;
            }
        });
    }

    @Test
    public void DoubleArrayAccess() {
        test(new DoubleScript() {

            public double act(double value) {
                double[] array = {1, value};

                return array[1];
            }
        });
    }

    @Test
    public void DoubleMultiDimensionArray() {
        test(new ObjectScript<double[][]>() {

            public double[][] act(double[][] value) {
                double[][] array = new double[3][2];
                array[0] = new double[] {1, 2};
                array[1] = new double[] {3, 4};
                array[2] = new double[] {5, 6};

                return array;
            }
        });
    }

    @Test
    public void DoubleMultiDimensionArrayByShorthand() {
        test(new ObjectScript<double[][]>() {

            public double[][] act(double[][] value) {
                return new double[][] { {0, 1}, {2, 3, 4}, {5, 6, 7, 8}};
            }
        });
    }

    @Test
    public void DoubleArrayLength() {
        test(1, 10, new IntScript() {

            public int act(int value) {
                return new double[value].length;
            }
        });
    }

    @Test
    public void DoubleArraySoMany() {
        test(new ObjectScript<double[]>() {

            public double[] act(double[] value) {
                return new double[] {0.1d, 0.2d, 0.3d, 0.4d, 0.5d, 0.6d, 0.7d, 0.8d, 0.9d};
            }
        });
    }

    @Test
    public void StringArrayWithExpression() {
        test(new ObjectScript<String[]>() {

            private String field = "value";

            public String[] act(String[] value) {
                String[] array = new String[4];
                array[0] = field + field;
                array[1] = field.substring(field.length() - 3);
                array[2] = field.concat(field);
                array[3] = field.replace('a', 'o');

                return array;
            }
        });
    }

    @Test
    public void StringArrayByShorthand() {
        test(new ObjectScript<String[]>() {

            public String[] act(String[] value) {
                return new String[] {"a", "b"};
            }
        });
    }

    @Test
    public void StringArrayByShorthandWithFirstNull() {
        test(new ObjectScript<String[]>() {

            public String[] act(String[] value) {
                return new String[] {null, "end"};
            }
        });
    }

    @Test
    public void StringArrayByShorthandWithlastNull() {
        test(new ObjectScript<String[]>() {

            public String[] act(String[] value) {
                return new String[] {"start", null};
            }
        });
    }

    @Test
    public void StringArrayByShorthandWithAllNull() {
        test(new ObjectScript<String[]>() {

            public String[] act(String[] value) {
                return new String[] {null, null};
            }
        });
    }

    @Test
    public void StringArrayWithExpressionByShorthand() {
        test(new ObjectScript<String[]>() {

            private String field = "value";

            public String[] act(String[] value) {
                return new String[] {field + field, field.substring(1), field.concat("@"), field.replace('a', 'e')};
            }
        });
    }

    @Test
    public void StringArraySoMany() {
        test(new ObjectScript<String[]>() {

            public String[] act(String[] value) {
                return new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
            }
        });
    }

    @Test
    public void StringMultiDimensionArray() {
        test(new ObjectScript<String[][]>() {

            public String[][] act(String[][] value) {
                String[][] array = new String[3][2];
                array[0] = new String[] {"a", "b"};
                array[1] = new String[] {"c", "d"};
                array[2] = new String[] {"e", "f"};

                return array;
            }
        });
    }

    @Test
    public void StringMultiDimensionArrayByShorthand() {
        test(new ObjectScript<String[][]>() {

            public String[][] act(String[][] value) {
                return new String[][] { {"a", "b"}, {"c", "d", "e"}};
            }
        });
    }

    @Test
    public void StringArrayAccess() {
        test("second", new ObjectScript<String>() {

            public String act(String value) {
                String[] array = {"first", value};

                return array[1];
            }
        });
    }

    @Test
    public void StringArrayLength() {
        test(1, 10, new IntScript() {

            public int act(int value) {
                return new String[value].length;
            }
        });
    }

    @Test
    public void StringArrayFor() {
        test(new ObjectScript<String>() {

            public String act(String value) {
                String sum = "";
                String[] array = {"a", "b", "c"};

                for (int i = 0; i < array.length; i++) {
                    sum += array[i];
                }
                return sum;
            }
        });
    }

    @Test
    public void StringArrayForEach() {
        test(new ObjectScript<String>() {

            public String act(String value) {
                String sum = "";
                String[] array = {"a", "b", "c"};

                for (String item : array) {
                    sum += item;
                }
                return sum;
            }
        });
    }
}
