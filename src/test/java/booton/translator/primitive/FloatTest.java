/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.primitive;

import org.junit.Test;

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2013/01/24 14:38:31
 */
@SuppressWarnings("unused")
public class FloatTest extends ScriptTester {

    @Test
    public void zero() {
        test(new Scriptable() {

            float act(float value) {
                return 0;
            }
        });
    }

    @Test
    public void one() {
        test(new Scriptable() {

            float act(float value) {
                return 1;
            }
        });
    }

    @Test
    public void two() {
        test(new Scriptable() {

            float act(float value) {
                return 2;
            }
        });
    }

    @Test
    public void three() {
        test(new Scriptable() {

            float act(float value) {
                return 3;
            }
        });
    }

    @Test
    public void minus() {
        test(new Scriptable() {

            float act(float value) {
                return -1;
            }
        });
    }

    @Test
    public void max() {
        test(new Scriptable() {

            float act(float value) {
                return Float.MAX_VALUE;
            }
        });
    }

    @Test
    public void min() {
        test(new Scriptable() {

            float act(float value) {
                return Float.MIN_VALUE;
            }
        });
    }

    @Test
    public void add() {
        test(new Scriptable() {

            float act(float value) {
                return value + 1;
            }
        });
    }

    @Test
    public void addAssignable() {
        test(new Scriptable() {

            float act(float value) {
                return value += 2;
            }
        });
    }

    @Test
    public void subtract() {
        test(new Scriptable() {

            float act(float value) {
                return value - 1;
            }
        });
    }

    @Test
    public void subtractAssignable() {
        test(new Scriptable() {

            float act(float value) {
                return value -= 2;
            }
        });
    }

    @Test
    public void multiply() {
        test(new Scriptable() {

            float act(float value) {
                return value * 2;
            }
        });
    }

    @Test
    public void multiplyAssignable() {
        test(new Scriptable() {

            float act(float value) {
                return value *= 2;
            }
        });
    }

    @Test
    public void divide() {
        test(new Scriptable() {

            float act(float value) {
                return value / 2;
            }
        });
    }

    @Test
    public void divideAssignable() {
        test(new Scriptable() {

            float act(float value) {
                return value /= 2;
            }
        });
    }

    @Test
    public void modulo() {
        test(new Scriptable() {

            float act(float value) {
                return value % 2;
            }
        });
    }

    @Test
    public void moduloAssignable() {
        test(new Scriptable() {

            float act(float value) {
                return value %= 2;
            }
        });
    }

    @Test
    public void postIncrement() {
        test(new Scriptable() {

            float act(float value) {
                return value++;
            }
        });
    }

    @Test
    public void postIncrementValue() {
        test(new Scriptable() {

            float act(float value) {
                float next = value++;
                return value + next;
            }
        });
    }

    @Test
    public void postIncrementLike() {
        test(new Scriptable() {

            float act(float value) {
                return value + 1;
            }
        });
    }

    @Test
    public void preIncrement() {
        test(new Scriptable() {

            float act(float value) {
                return ++value;
            }
        });
    }

    @Test
    public void equal() {
        test(new Scriptable() {

            boolean act(float value) {
                return value == 0;
            }
        });
    }

    @Test
    public void notEqual() {
        test(new Scriptable() {

            boolean act(float value) {
                return value != 0;
            }
        });
    }

    @Test
    public void less() {
        test(new Scriptable() {

            boolean act(float value) {
                return value < 1;
            }
        });
    }

    @Test
    public void lessEqual() {
        test(new Scriptable() {

            boolean act(float value) {
                return value <= 1;
            }
        });
    }

    @Test
    public void greater() {
        test(new Scriptable() {

            boolean act(float value) {
                return value > 1;
            }
        });
    }

    @Test
    public void greaterEqual() {
        test(new Scriptable() {

            boolean act(float value) {
                return value >= 1;
            }
        });
    }

    @Test
    public void incrementStatiFieldInFieldAccess() throws Exception {
        test(new IncrementStaticField());
    }

    /**
     * @version 2013/03/13 17:21:44
     */
    private static class IncrementStaticField implements Scriptable {

        private static float index = 1;

        private static float count = 2;

        public float act() {
            index = count++;

            return count + index * 10;
        }
    }

    @Test
    public void decrementStatiFieldInFieldAccess() throws Exception {
        test(new DecrementStaticField());
    }

    /**
     * @version 2013/03/13 17:21:44
     */
    private static class DecrementStaticField implements Scriptable {

        private static float index = 1;

        private static float count = 2;

        public float act() {
            index = count--;

            return count + index * 10;
        }
    }

    @Test
    public void preincrementStatiFieldInFieldAccess() throws Exception {
        test(new PreincrementStaticField());
    }

    /**
     * @version 2013/03/13 17:21:44
     */
    private static class PreincrementStaticField implements Scriptable {

        private static float index = 1;

        private static float count = 2;

        public float act() {
            index = ++count;

            return count + index * 10;
        }
    }

    @Test
    public void predecrementStatiFieldInFieldAccess() throws Exception {
        test(new PredecrementStaticField());
    }

    /**
     * @version 2013/03/13 17:21:44
     */
    private static class PredecrementStaticField implements Scriptable {

        private static float index = 1;

        private static float count = 2;

        public float act() {
            index = --count;

            return count + index * 10;
        }
    }
}
