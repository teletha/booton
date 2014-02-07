/*
 * Copyright (C) 2014 Nameless Production Committee
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
 * @version 2014/02/07 12:59:18
 */
@SuppressWarnings("unused")
public class DoubleArrayTest extends ScriptTester {

    @Test
    public void base() {
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
    public void multipleAssign() throws Exception {
        test(new Scriptable() {

            public double[] act() {
                double[] array = new double[3];
                array[0] = array[1] = array[2] = 3.2d;

                return array;
            }
        });
    }

    @Test
    public void withExpression() {
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
    public void shorthand() {
        test(new Scriptable() {

            public double[] act() {
                return new double[] {1.5d, -1.5d};
            }
        });
    }

    @Test
    public void shorthandWithFirstZero() {
        test(new Scriptable() {

            public double[] act() {
                return new double[] {0.0d, 0.3d};
            }
        });
    }

    @Test
    public void shorthandWithlastZero() {
        test(new Scriptable() {

            public double[] act() {
                return new double[] {0.1d, 0d};
            }
        });
    }

    @Test
    public void shorthandWithAllZero() {
        test(new Scriptable() {

            public double[] act() {
                return new double[] {0.0d, -0.0d};
            }
        });
    }

    @Test
    public void expressionByShorthand() {
        test(new Scriptable() {

            private double field = 0.002000023d;

            public double[] act() {
                return new double[] {field + field, field - field, field * field, field / field};
            }
        });
    }

    @Test
    public void access() {
        test(new Scriptable() {

            public double act(double value) {
                double[] array = {1, value};

                return array[1];
            }
        });
    }

    @Test
    public void multiDimensionArray() {
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
    public void multiDimensionArrayByShorthand() {
        test(new Scriptable() {

            public double[][] act() {
                return new double[][] { {0, 1}, {2, 3, 4}, {5, 6, 7, 8}};
            }
        });
    }

    @Test
    public void length() {
        test(new Scriptable() {

            public int act(@Param(ints = {0, 1, 10}) int value) {
                return new double[value].length;
            }
        });
    }

    @Test
    public void many() {
        test(new Scriptable() {

            public double[] act() {
                return new double[] {0.1d, 0.2d, 0.3d, 0.4d, 0.5d, 0.6d, 0.7d, 0.8d, 0.9d};
            }
        });
    }

    @Test
    public void withShorthandExpression() {
        test(new Scriptable() {

            public double act() {
                double[] array = {1};
                array[0] += 10;

                return array[0];
            }
        });
    }
}
