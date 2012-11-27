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
package booton.translator;

import org.junit.Test;

/**
 * @version 2009/08/06 10:54:50
 */
public class PrimitiveLongTest extends ScriptTranslatorTestcase {

    @Test
    public void zero() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return 0;
            }
        });
    }

    @Test
    public void one() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return 1;
            }
        });
    }

    @Test
    public void two() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return 2;
            }
        });
    }

    @Test
    public void three() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return 3;
            }
        });
    }

    @Test
    public void minus() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return -1;
            }
        });
    }

    @Test
    public void max() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return Long.MAX_VALUE;
            }
        });
    }

    @Test
    public void min() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return Long.MIN_VALUE;
            }
        });
    }

    @Test
    public void add() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value + 1;
            }
        });
    }

    @Test
    public void addAssignable() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value += 2;
            }
        });
    }

    @Test
    public void subtract() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value - 1;
            }
        });
    }

    @Test
    public void subtractAssignable() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value -= 2;
            }
        });
    }

    @Test
    public void multiply() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value * 2;
            }
        });
    }

    @Test
    public void multiplyAssignable() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value *= 2;
            }
        });
    }

    @Test
    public void divide() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value / 2;
            }
        });
    }

    @Test
    public void divideAssignable() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value /= 2;
            }
        });
    }

    @Test
    public void modulo() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value % 2;
            }
        });
    }

    @Test
    public void moduloAssignable() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value %= 2;
            }
        });
    }

    @Test
    public void bitAnd() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value & 0x010101;
            }
        });
    }

    @Test
    public void bitOr() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value | 0x010101;
            }
        });
    }

    @Test
    public void bitOrAssignable() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value |= 0x010101;
            }
        });
    }

    @Test
    public void bitXor() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value ^ 0x010101;
            }
        });
    }

    @Test
    public void bitXorAssignable() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value ^= 0x010101;
            }
        });
    }

    @Test
    public void bitNot() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return ~value;
            }
        });
    }

    @Test
    public void shiftLeft() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value << 1;
            }
        });
    }

    @Test
    public void shiftLeftAssignable() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value <<= 1;
            }
        });
    }

    @Test
    public void shiftRight() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value >> 1;
            }
        });
    }

    @Test
    public void shiftRightAssignable() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value >>= 1;
            }
        });
    }

    /**
     * @TODO Implement arbitrary-precision integers for Javascript.
     */
    public void unsignedShiftRight() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value >>> 1;
            }
        });
    }

    /**
     * @TODO Implement arbitrary-precision integers for Javascript.
     */
    public void unsignedShiftRightAssignable() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value >>>= 1;
            }
        });
    }

    @Test
    public void postIncrement() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value++;
            }
        });
    }

    @Test
    public void postIncrementValue() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                long next = value++;
                return value + next;
            }
        });
    }

    @Test
    public void postIncrementLike() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return value + 1;
            }
        });
    }

    @Test
    public void preIncrement() {
        assertScript(new ScriptForLong() {

            public long execute(long value) {
                return ++value;
            }
        });
    }
}
