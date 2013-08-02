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

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/12/01 1:56:22
 */
@SuppressWarnings("unused")
public class IntTest extends ScriptTester {

    @Test
    public void max() {
        test(new Scriptable() {

            int act(int value) {
                return Integer.MAX_VALUE;
            }
        });
    }

    @Test
    public void min() {
        test(new Scriptable() {

            int act(int value) {
                return Integer.MIN_VALUE;
            }
        });
    }

    @Test
    public void add() {
        test(new Scriptable() {

            int act(int value) {
                return value + 1;
            }
        });
    }

    @Test
    public void addAssignable() {
        test(new Scriptable() {

            int act(int value) {
                return value += 2;
            }
        });
    }

    @Test
    public void subtract() {
        test(new Scriptable() {

            int act(int value) {
                return value - 1;
            }
        });
    }

    @Test
    public void subtractAssignable() {
        test(new Scriptable() {

            int act(int value) {
                return value -= 2;
            }
        });
    }

    @Test
    public void multiply() {
        test(new Scriptable() {

            int act(int value) {
                return value * 2;
            }
        });
    }

    @Test
    public void multiplyAssignable() {
        test(new Scriptable() {

            int act(int value) {
                return value *= 2;
            }
        });
    }

    @Test
    public void divide() {
        test(new Scriptable() {

            int act(int value) {
                return value / 2;
            }
        });
    }

    @Test
    public void divideAssignable() {
        test(new Scriptable() {

            int act(int value) {
                return value /= 2;
            }
        });
    }

    @Test
    public void modulo() {
        test(new Scriptable() {

            int act(int value) {
                return value % 2;
            }
        });
    }

    @Test
    public void moduloAssignable() {
        test(new Scriptable() {

            int act(int value) {
                return value %= 2;
            }
        });
    }

    @Test
    public void bitFlag() {
        test(new Scriptable() {

            boolean act(int value) {
                return (value & 1) == 0;
            }
        });
    }

    @Test
    public void bitAnd() {
        test(new Scriptable() {

            int act(int value) {
                return value & 0x010101;
            }
        });
    }

    @Test
    public void bitOr() {
        test(new Scriptable() {

            int act(int value) {
                return value | 0x010101;
            }
        });
    }

    @Test
    public void bitOrAssignable() {
        test(new Scriptable() {

            int act(int value) {
                return value |= 0x010101;
            }
        });
    }

    @Test
    public void bitXor() {
        test(new Scriptable() {

            int act(int value) {
                return value ^ 0x010101;
            }
        });
    }

    @Test
    public void bitXorAssignable() {
        test(new Scriptable() {

            int act(int value) {
                return value ^= 0x010101;
            }
        });
    }

    @Test
    public void bitNot() {
        test(new Scriptable() {

            int act(int value) {
                return ~value;
            }
        });
    }

    @Test
    public void shiftLeft() {
        test(new Scriptable() {

            int act(int value) {
                return value << 1;
            }
        });
    }

    @Test
    public void shiftLeftAssignable() {
        test(new Scriptable() {

            int act(int value) {
                return value <<= 1;
            }
        });
    }

    @Test
    public void shiftRight() {
        test(new Scriptable() {

            int act(int value) {
                return value >> 1;
            }
        });
    }

    @Test
    public void shiftRightAssignable() {
        test(new Scriptable() {

            int act(int value) {
                return value >>= 1;
            }
        });
    }

    @Test
    public void unsignedShiftRight() {
        test(new Scriptable() {

            int act(int value) {
                return value >>> 1;
            }
        });
    }

    @Test
    public void unsignedShiftRightAssignable() {
        test(new Scriptable() {

            int act(int value) {
                return value >>>= 1;
            }
        });
    }

    @Test
    public void postIncrement() {
        test(new Scriptable() {

            int act(int value) {
                return value++;
            }
        });
    }

    @Test
    public void postIncrementValue() {
        test(new Scriptable() {

            int act(int value) {
                int next = value++;
                return value + next;
            }
        });
    }

    @Test
    public void postIncrementLike() {
        test(new Scriptable() {

            int act(int value) {
                return value + 1;
            }
        });
    }

    @Test
    public void preIncrement() {
        test(new Scriptable() {

            int act(int value) {
                return ++value;
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

        private static int index = 1;

        private static int count = 2;

        public int act() {
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

        private static int index = 1;

        private static int count = 2;

        public int act() {
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

        private static int index = 1;

        private static int count = 2;

        public int act() {
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

        private static int index = 1;

        private static int count = 2;

        public int act() {
            index = --count;

            return count + index * 10;
        }
    }
}
