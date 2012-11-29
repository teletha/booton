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
package booton.translator.array;

import org.junit.Test;

import booton.translator.ScriptTranslatorTestcase;
import booton.translator.api.DoubleScript;
import booton.translator.api.FloatScript;
import booton.translator.api.IntScript;
import booton.translator.api.LongScript;
import booton.translator.api.ObjectScript;

/**
 * @version 2009/08/18 20:19:16
 */
public class ArrayTest extends ScriptTranslatorTestcase {

    @Test
    public void IntArray() {
        assertScript(new ObjectScript<int[]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public int[] execute(int[] value) {
                int[] array = new int[2];
                array[0] = 1;
                array[1] = 2;

                return array;
            }
        });
    }

    @Test
    public void IntArrayWithExpression() {
        assertScript(new ObjectScript<int[]>() {

            private int field = 10;

            public int[] execute(int[] value) {
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
    public void IntArrayByShorthand() {
        assertScript(new ObjectScript<int[]>() {

            public int[] execute(int[] value) {
                return new int[] {1, 2};
            }
        });
    }

    @Test
    public void IntArrayByShorthandWithFirstZero() {
        assertScript(new ObjectScript<int[]>() {

            public int[] execute(int[] value) {
                return new int[] {0, -1};
            }
        });
    }

    @Test
    public void IntArrayByShorthandWithlastZero() {
        assertScript(new ObjectScript<int[]>() {

            public int[] execute(int[] value) {
                return new int[] {-2, 0};
            }
        });
    }

    @Test
    public void IntArrayByShorthandWithAllZero() {
        assertScript(new ObjectScript<int[]>() {

            public int[] execute(int[] value) {
                return new int[] {0, 0};
            }
        });
    }

    @Test
    public void IntArrayWithExpressionByShorthand() {
        assertScript(new ObjectScript<int[]>() {

            private int field = 10;

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public int[] execute(int[] value) {
                return new int[] {field + field, field - field, field * field, field / field};
            }
        });
    }

    @Test
    public void IntArraySoMany() {
        assertScript(new ObjectScript<int[]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public int[] execute(int[] value) {
                return new int[] {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
            }
        });
    }

    @Test
    public void IntMultiDimensionArray() {
        assertScript(new ObjectScript<int[][]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public int[][] execute(int[][] value) {
                int[][] array = new int[3][2];
                array[0] = new int[] {1, 2};
                array[1] = new int[] {3, 4};
                array[2] = new int[] {5, 6};

                return array;
            }
        });
    }

    @Test
    public void IntMultiDimensionArrayByShorthand() {
        assertScript(new ObjectScript<int[][]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public int[][] execute(int[][] value) {
                return new int[][] { {0, 1}, {2, 3, 4}, {5, 6, 7, 8}};
            }
        });
    }

    @Test
    public void IntThreeDimensionArray() {
        assertScript(new ObjectScript<int[][][]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public int[][][] execute(int[][][] value) {
                int[][][] array = new int[2][3][1];
                array[0] = new int[][] { {0}, {2}, {1}};
                array[1] = new int[][] { {3}, {-1}, {1, 0, 1}};

                return array;
            }
        });
    }

    @Test
    public void IntThreeDimensionArrayWithoutNeedlessDeclaration() {
        assertScript(new ObjectScript<int[][][]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public int[][][] execute(int[][][] value) {
                int[][][] array = new int[2][][];
                array[0] = new int[][] { {0}, {2}, {1}};
                array[1] = new int[][] { {3}, {-1}, {1, 0, 1}};

                return array;
            }
        });
    }

    @Test
    public void IntArrayAccess() {
        assertScript(new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                int[] array = {1, value};

                return array[1];
            }
        });
    }

    @Test
    public void IntArrayLength() {
        assertScript(1, 10, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                return new int[value].length;
            }
        });
    }

    @Test
    public void IntArrayFor() {
        assertScript(1, 10, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
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
    public void LongArray() {
        assertScript(new ObjectScript<long[]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public long[] execute(long[] value) {
                long[] array = new long[2];
                array[0] = 1;
                array[1] = 2;

                return array;
            }
        });
    }

    @Test
    public void LongArrayWithExpression() {
        assertScript(new ObjectScript<long[]>() {

            private long field = 12345678L;

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public long[] execute(long[] value) {
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
        assertScript(new ObjectScript<long[]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public long[] execute(long[] value) {
                return new long[] {1, 2};
            }
        });
    }

    @Test
    public void LongArrayByShorthandWithFirstZero() {
        assertScript(new ObjectScript<long[]>() {

            public long[] execute(long[] value) {
                return new long[] {0L, -1L};
            }
        });
    }

    @Test
    public void LongArrayByShorthandWithlastZero() {
        assertScript(new ObjectScript<long[]>() {

            public long[] execute(long[] value) {
                return new long[] {-2L, 0L};
            }
        });
    }

    @Test
    public void LongArrayByShorthandWithAllZero() {
        assertScript(new ObjectScript<long[]>() {

            public long[] execute(long[] value) {
                return new long[] {0L, 0L};
            }
        });
    }

    @Test
    public void LongArrayWithExpressionByShorthand() {
        assertScript(new ObjectScript<long[]>() {

            private long field = 10;

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public long[] execute(long[] value) {
                return new long[] {field + field, field - field, field * field, field / field};
            }
        });
    }

    @Test
    public void LongArraySoMany() {
        assertScript(new ObjectScript<long[]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public long[] execute(long[] value) {
                return new long[] {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
            }
        });
    }

    @Test
    public void LongMultiDimensionArray() {
        assertScript(new ObjectScript<long[][]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public long[][] execute(long[][] value) {
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
        assertScript(new ObjectScript<long[][]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public long[][] execute(long[][] value) {
                return new long[][] { {0, 1}, {2, 3, 4}, {5, 6, 7, 8}};
            }
        });
    }

    @Test
    public void LongArrayAccess() {
        assertScript(new LongScript() {

            public long execute(long value) {
                long[] array = {1, value};

                return array[1];
            }
        });
    }

    @Test
    public void LongArrayLength() {
        assertScript(1, 10, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                return new long[value].length;
            }
        });
    }

    @Test
    public void FloatArray() {
        assertScript(new ObjectScript<float[]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public float[] execute(float[] value) {
                float[] array = new float[2];
                array[0] = 1.1f;
                array[1] = 2.2f;

                return array;
            }
        });
    }

    @Test
    public void FloatArrayWithExpression() {
        assertScript(new ObjectScript<float[]>() {

            private float field = 3.14f;

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public float[] execute(float[] value) {
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
        assertScript(new ObjectScript<float[]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public float[] execute(float[] value) {
                return new float[] {1.5f, -1.5f};
            }
        });
    }

    @Test
    public void FloatArrayByShorthandWithFirstZero() {
        assertScript(new ObjectScript<float[]>() {

            public float[] execute(float[] value) {
                return new float[] {0.0f, 0.3f};
            }
        });
    }

    @Test
    public void FloatArrayByShorthandWithlastZero() {
        assertScript(new ObjectScript<float[]>() {

            public float[] execute(float[] value) {
                return new float[] {0.1f, 0f};
            }
        });
    }

    @Test
    public void FloatArrayByShorthandWithAllZero() {
        assertScript(new ObjectScript<float[]>() {

            public float[] execute(float[] value) {
                return new float[] {0.0f, -0.0f};
            }
        });
    }

    @Test
    public void FloatArrayWithExpressionByShorthand() {
        assertScript(new ObjectScript<float[]>() {

            private float field = 0.002f;

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public float[] execute(float[] value) {
                return new float[] {field + field, field - field, field * field, field / field};
            }
        });
    }

    @Test
    public void FloatArraySoMany() {
        assertScript(new ObjectScript<float[]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public float[] execute(float[] value) {
                return new float[] {0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f};
            }
        });
    }

    @Test
    public void FloatArrayAccess() {
        assertScript(new FloatScript() {

            public float execute(float value) {
                float[] array = {1, value};

                return array[1];
            }
        });
    }

    @Test
    public void FloatMultiDimensionArray() {
        assertScript(new ObjectScript<float[][]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public float[][] execute(float[][] value) {
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
        assertScript(new ObjectScript<float[][]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public float[][] execute(float[][] value) {
                return new float[][] { {0, 1}, {2, 3, 4}, {5, 6, 7, 8}};
            }
        });
    }

    @Test
    public void FloatArrayLength() {
        assertScript(1, 10, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                return new float[value].length;
            }
        });
    }

    @Test
    public void DoubleArray() {
        assertScript(new ObjectScript<double[]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public double[] execute(double[] value) {
                double[] array = new double[2];
                array[0] = 1.1d;
                array[1] = 2.2d;

                return array;
            }
        });
    }

    @Test
    public void DoubleArrayWithExpression() {
        assertScript(new ObjectScript<double[]>() {

            private double field = 3.14d;

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public double[] execute(double[] value) {
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
        assertScript(new ObjectScript<double[]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public double[] execute(double[] value) {
                return new double[] {1.5d, -1.5d};
            }
        });
    }

    @Test
    public void DoubleArrayByShorthandWithFirstZero() {
        assertScript(new ObjectScript<double[]>() {

            public double[] execute(double[] value) {
                return new double[] {0.0d, 0.3d};
            }
        });
    }

    @Test
    public void DoubleArrayByShorthandWithlastZero() {
        assertScript(new ObjectScript<double[]>() {

            public double[] execute(double[] value) {
                return new double[] {0.1d, 0d};
            }
        });
    }

    @Test
    public void DoubleArrayByShorthandWithAllZero() {
        assertScript(new ObjectScript<double[]>() {

            public double[] execute(double[] value) {
                return new double[] {0.0d, -0.0d};
            }
        });
    }

    @Test
    public void DoubleArrayWithExpressionByShorthand() {
        assertScript(new ObjectScript<double[]>() {

            private double field = 0.002000023d;

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public double[] execute(double[] value) {
                return new double[] {field + field, field - field, field * field, field / field};
            }
        });
    }

    @Test
    public void StringArray() {
        assertScript(new ObjectScript<String[]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.String)
             */
            public String[] execute(String[] value) {
                String[] array = new String[2];
                array[0] = "1";
                array[1] = "2";

                return array;
            }
        });
    }

    @Test
    public void DoubleArrayAccess() {
        assertScript(new DoubleScript() {

            public double execute(double value) {
                double[] array = {1, value};

                return array[1];
            }
        });
    }

    @Test
    public void DoubleMultiDimensionArray() {
        assertScript(new ObjectScript<double[][]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public double[][] execute(double[][] value) {
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
        assertScript(new ObjectScript<double[][]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public double[][] execute(double[][] value) {
                return new double[][] { {0, 1}, {2, 3, 4}, {5, 6, 7, 8}};
            }
        });
    }

    @Test
    public void DoubleArrayLength() {
        assertScript(1, 10, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                return new double[value].length;
            }
        });
    }

    @Test
    public void DoubleArraySoMany() {
        assertScript(new ObjectScript<double[]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public double[] execute(double[] value) {
                return new double[] {0.1d, 0.2d, 0.3d, 0.4d, 0.5d, 0.6d, 0.7d, 0.8d, 0.9d};
            }
        });
    }

    @Test
    public void StringArrayWithExpression() {
        assertScript(new ObjectScript<String[]>() {

            private String field = "value";

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.String)
             */
            public String[] execute(String[] value) {
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
        assertScript(new ObjectScript<String[]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.String)
             */
            public String[] execute(String[] value) {
                return new String[] {"a", "b"};
            }
        });
    }

    @Test
    public void StringArrayByShorthandWithFirstNull() {
        assertScript(new ObjectScript<String[]>() {

            public String[] execute(String[] value) {
                return new String[] {null, "end"};
            }
        });
    }

    @Test
    public void StringArrayByShorthandWithlastNull() {
        assertScript(new ObjectScript<String[]>() {

            public String[] execute(String[] value) {
                return new String[] {"start", null};
            }
        });
    }

    @Test
    public void StringArrayByShorthandWithAllNull() {
        assertScript(new ObjectScript<String[]>() {

            public String[] execute(String[] value) {
                return new String[] {null, null};
            }
        });
    }

    @Test
    public void StringArrayWithExpressionByShorthand() {
        assertScript(new ObjectScript<String[]>() {

            private String field = "value";

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.String)
             */
            public String[] execute(String[] value) {
                return new String[] {field + field, field.substring(1), field.concat("@"), field.replace('a', 'e')};
            }
        });
    }

    @Test
    public void StringArraySoMany() {
        assertScript(new ObjectScript<String[]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.String)
             */
            public String[] execute(String[] value) {
                return new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
            }
        });
    }

    @Test
    public void StringMultiDimensionArray() {
        assertScript(new ObjectScript<String[][]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public String[][] execute(String[][] value) {
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
        assertScript(new ObjectScript<String[][]>() {

            /**
             * @see booton.translator.api.ObjectScript#execute(java.lang.Object)
             */
            public String[][] execute(String[][] value) {
                return new String[][] { {"a", "b"}, {"c", "d", "e"}};
            }
        });
    }

    @Test
    public void StringArrayAccess() {
        assertScript("second", new ObjectScript<String>() {

            public String execute(String value) {
                String[] array = {"first", value};

                return array[1];
            }
        });
    }

    @Test
    public void StringArrayLength() {
        assertScript(1, 10, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                return new String[value].length;
            }
        });
    }

    @Test
    public void StringArrayFor() {
        assertScript(new ObjectScript<String>() {

            public String execute(String value) {
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
        assertScript(new ObjectScript<String>() {

            public String execute(String value) {
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
