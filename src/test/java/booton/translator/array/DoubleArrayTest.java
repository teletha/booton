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

import booton.translator.Param;
import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/12/01 3:09:50
 */
@SuppressWarnings("unused")
public class DoubleArrayTest extends ScriptTester {

    @Test
    public void Array() {
        test(new Scriptable() {

            public double[] act() {
                double[] array = new double[2];
                array[0] = 1.1d;
                array[1] = 2.2d;

                return array;
            }
        });
    }

    @Test
    public void ArrayWithExpression() {
        test(new Scriptable() {

            private double field = 3.14d;

            public double[] act() {
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
    public void ArrayByShorthand() {
        test(new Scriptable() {

            public double[] act() {
                return new double[] {1.5d, -1.5d};
            }
        });
    }

    @Test
    public void ArrayByShorthandWithFirstZero() {
        test(new Scriptable() {

            public double[] act() {
                return new double[] {0.0d, 0.3d};
            }
        });
    }

    @Test
    public void ArrayByShorthandWithlastZero() {
        test(new Scriptable() {

            public double[] act() {
                return new double[] {0.1d, 0d};
            }
        });
    }

    @Test
    public void ArrayByShorthandWithAllZero() {
        test(new Scriptable() {

            public double[] act() {
                return new double[] {0.0d, -0.0d};
            }
        });
    }

    @Test
    public void ArrayWithExpressionByShorthand() {
        test(new Scriptable() {

            private double field = 0.002000023d;

            public double[] act() {
                return new double[] {field + field, field - field, field * field, field / field};
            }
        });
    }

    @Test
    public void ArrayAccess() {
        test(new Scriptable() {

            public double act(double value) {
                double[] array = {1, value};

                return array[1];
            }
        });
    }

    @Test
    public void MultiDimensionArray() {
        test(new Scriptable() {

            public double[][] act() {
                double[][] array = new double[3][2];
                array[0] = new double[] {1, 2};
                array[1] = new double[] {3, 4};
                array[2] = new double[] {5, 6};

                return array;
            }
        });
    }

    @Test
    public void MultiDimensionArrayByShorthand() {
        test(new Scriptable() {

            public double[][] act() {
                return new double[][] { {0, 1}, {2, 3, 4}, {5, 6, 7, 8}};
            }
        });
    }

    @Test
    public void ArrayLength() {
        test(new Scriptable() {

            public int act(@Param(ints = {0, 1, 10}) int value) {
                return new double[value].length;
            }
        });
    }

    @Test
    public void ArraySoMany() {
        test(new Scriptable() {

            public double[] act() {
                return new double[] {0.1d, 0.2d, 0.3d, 0.4d, 0.5d, 0.6d, 0.7d, 0.8d, 0.9d};
            }
        });
    }
}
