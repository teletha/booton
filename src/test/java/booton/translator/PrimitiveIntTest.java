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
 * @version 2009/06/27 12:48:26
 */
public class PrimitiveIntTest extends ScriptTranslatorTestcase {

    @Test
    public void one() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return 1;
            }
        });
    }

    @Test
    public void two() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return 2;
            }
        });
    }

    @Test
    public void three() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return 3;
            }
        });
    }

    @Test
    public void four() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return 4;
            }
        });
    }

    @Test
    public void five() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return 5;
            }
        });
    }

    @Test
    public void six() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return 6;
            }
        });
    }

    @Test
    public void seven() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return 7;
            }
        });
    }

    @Test
    public void eight() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return 8;
            }
        });
    }

    @Test
    public void nine() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return 9;
            }
        });
    }

    @Test
    public void ten() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return 10;
            }
        });
    }

    @Test
    public void zero() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return 0;
            }
        });
    }

    @Test
    public void minusOne() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return -1;
            }
        });
    }

    @Test
    public void minusTwo() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return -2;
            }
        });
    }

    @Test
    public void minusThree() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return -3;
            }
        });
    }

    @Test
    public void max() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return Integer.MAX_VALUE;
            }
        });
    }

    @Test
    public void min() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return Integer.MIN_VALUE;
            }
        });
    }

    @Test
    public void add() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value + 1;
            }
        });
    }

    @Test
    public void addAssignable() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value += 2;
            }
        });
    }

    @Test
    public void subtract() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value - 1;
            }
        });
    }

    @Test
    public void subtractAssignable() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value -= 2;
            }
        });
    }

    @Test
    public void multiply() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value * 2;
            }
        });
    }

    @Test
    public void multiplyAssignable() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value *= 2;
            }
        });
    }

    @Test
    public void divide() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value / 2;
            }
        });
    }

    @Test
    public void divideAssignable() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value /= 2;
            }
        });
    }

    @Test
    public void modulo() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value % 2;
            }
        });
    }

    @Test
    public void moduloAssignable() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value %= 2;
            }
        });
    }

    @Test
    public void bitAnd() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value & 0x010101;
            }
        });
    }

    @Test
    public void bitOr() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value | 0x010101;
            }
        });
    }

    @Test
    public void bitOrAssignable() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value |= 0x010101;
            }
        });
    }

    @Test
    public void bitXor() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value ^ 0x010101;
            }
        });
    }

    @Test
    public void bitXorAssignable() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value ^= 0x010101;
            }
        });
    }

    @Test
    public void bitNot() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return ~value;
            }
        });
    }

    @Test
    public void shiftLeft() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value << 1;
            }
        });
    }

    @Test
    public void shiftLeftAssignable() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value <<= 1;
            }
        });
    }

    @Test
    public void shiftRight() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value >> 1;
            }
        });
    }

    @Test
    public void shiftRightAssignable() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value >>= 1;
            }
        });
    }

    @Test
    public void unsignedShiftRight() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value >>> 1;
            }
        });
    }

    @Test
    public void unsignedShiftRightAssignable() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value >>>= 1;
            }
        });
    }

    @Test
    public void postIncrement() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value++;
            }
        });
    }

    @Test
    public void postIncrementValue() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                int next = value++;
                return value + next;
            }
        });
    }

    @Test
    public void postIncrementLike() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return value + 1;
            }
        });
    }

    @Test
    public void preIncrement() {
        assertScript(new ScriptForInt() {

            public int execute(int value) {
                return ++value;
            }
        });
    }
}
