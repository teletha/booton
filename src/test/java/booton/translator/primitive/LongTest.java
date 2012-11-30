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
package booton.translator.primitive;

import org.junit.Test;

import booton.translator.api.ScriptTester;
import booton.translator.api.Scriptable;

/**
 * @version 2012/12/01 2:12:27
 */
@SuppressWarnings("unused")
public class LongTest extends ScriptTester {

    @Test
    public void zero() {
        test(new Scriptable() {

            long act(long value) {
                return 0;
            }
        });
    }

    @Test
    public void one() {
        test(new Scriptable() {

            long act(long value) {
                return 1;
            }
        });
    }

    @Test
    public void two() {
        test(new Scriptable() {

            long act(long value) {
                return 2;
            }
        });
    }

    @Test
    public void three() {
        test(new Scriptable() {

            long act(long value) {
                return 3;
            }
        });
    }

    @Test
    public void minus() {
        test(new Scriptable() {

            long act(long value) {
                return -1;
            }
        });
    }

    @Test
    public void max() {
        test(new Scriptable() {

            long act(long value) {
                return Long.MAX_VALUE;
            }
        });
    }

    @Test
    public void min() {
        test(new Scriptable() {

            long act(long value) {
                return Long.MIN_VALUE;
            }
        });
    }

    @Test
    public void add() {
        test(new Scriptable() {

            long act(long value) {
                return value + 1;
            }
        });
    }

    @Test
    public void addAssignable() {
        test(new Scriptable() {

            long act(long value) {
                return value += 2;
            }
        });
    }

    @Test
    public void subtract() {
        test(new Scriptable() {

            long act(long value) {
                return value - 1;
            }
        });
    }

    @Test
    public void subtractAssignable() {
        test(new Scriptable() {

            long act(long value) {
                return value -= 2;
            }
        });
    }

    @Test
    public void multiply() {
        test(new Scriptable() {

            long act(long value) {
                return value * 2;
            }
        });
    }

    @Test
    public void multiplyAssignable() {
        test(new Scriptable() {

            long act(long value) {
                return value *= 2;
            }
        });
    }

    @Test
    public void divide() {
        test(new Scriptable() {

            long act(long value) {
                return value / 2;
            }
        });
    }

    @Test
    public void divideAssignable() {
        test(new Scriptable() {

            long act(long value) {
                return value /= 2;
            }
        });
    }

    @Test
    public void modulo() {
        test(new Scriptable() {

            long act(long value) {
                return value % 2;
            }
        });
    }

    @Test
    public void moduloAssignable() {
        test(new Scriptable() {

            long act(long value) {
                return value %= 2;
            }
        });
    }

    @Test
    public void bitAnd() {
        test(new Scriptable() {

            long act(long value) {
                return value & 0x010101;
            }
        });
    }

    @Test
    public void bitOr() {
        test(new Scriptable() {

            long act(long value) {
                return value | 0x010101;
            }
        });
    }

    @Test
    public void bitOrAssignable() {
        test(new Scriptable() {

            long act(long value) {
                return value |= 0x010101;
            }
        });
    }

    @Test
    public void bitXor() {
        test(new Scriptable() {

            long act(long value) {
                return value ^ 0x010101;
            }
        });
    }

    @Test
    public void bitXorAssignable() {
        test(new Scriptable() {

            long act(long value) {
                return value ^= 0x010101;
            }
        });
    }

    @Test
    public void bitNot() {
        test(new Scriptable() {

            long act(long value) {
                return ~value;
            }
        });
    }

    @Test
    public void shiftLeft() {
        test(new Scriptable() {

            long act(long value) {
                return value << 1;
            }
        });
    }

    @Test
    public void shiftLeftAssignable() {
        test(new Scriptable() {

            long act(long value) {
                return value <<= 1;
            }
        });
    }

    @Test
    public void shiftRight() {
        test(new Scriptable() {

            long act(long value) {
                return value >> 1;
            }
        });
    }

    @Test
    public void shiftRightAssignable() {
        test(new Scriptable() {

            long act(long value) {
                return value >>= 1;
            }
        });
    }

    /**
     * @TODO Implement arbitrary-precision integers for Javascript.
     */
    public void unsignedShiftRight() {
        test(new Scriptable() {

            long act(long value) {
                return value >>> 1;
            }
        });
    }

    /**
     * @TODO Implement arbitrary-precision integers for Javascript.
     */
    public void unsignedShiftRightAssignable() {
        test(new Scriptable() {

            long act(long value) {
                return value >>>= 1;
            }
        });
    }

    @Test
    public void postIncrement() {
        test(new Scriptable() {

            long act(long value) {
                return value++;
            }
        });
    }

    @Test
    public void postIncrementValue() {
        test(new Scriptable() {

            long act(long value) {
                long next = value++;
                return value + next;
            }
        });
    }

    @Test
    public void postIncrementLike() {
        test(new Scriptable() {

            long act(long value) {
                return value + 1;
            }
        });
    }

    @Test
    public void preIncrement() {
        test(new Scriptable() {

            long act(long value) {
                return ++value;
            }
        });
    }
}
