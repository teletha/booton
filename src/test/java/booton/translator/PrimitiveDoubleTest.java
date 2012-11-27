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
 * @version 2009/08/06 10:50:04
 */
public class PrimitiveDoubleTest extends ScriptTranslatorTestcase {

    @Test
    public void zero() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return 0;
            }
        });
    }

    @Test
    public void one() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return 1;
            }
        });
    }

    @Test
    public void two() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return 2;
            }
        });
    }

    @Test
    public void three() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return 3;
            }
        });
    }

    @Test
    public void minus() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return -1;
            }
        });
    }

    @Test
    public void max() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return Double.MAX_VALUE;
            }
        });
    }

    @Test
    public void min() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return Double.MIN_VALUE;
            }
        });
    }

    @Test
    public void add() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return value + 1;
            }
        });
    }

    @Test
    public void addAssignable() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return value += 2;
            }
        });
    }

    @Test
    public void subtract() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return value - 1;
            }
        });
    }

    @Test
    public void subtractAssignable() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return value -= 2;
            }
        });
    }

    @Test
    public void multiply() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return value * 2;
            }
        });
    }

    @Test
    public void multiplyAssignable() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return value *= 2;
            }
        });
    }

    @Test
    public void divide() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return value / 2;
            }
        });
    }

    @Test
    public void divideAssignable() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return value /= 2;
            }
        });
    }

    @Test
    public void modulo() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return value % 2;
            }
        });
    }

    @Test
    public void moduloAssignable() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return value %= 2;
            }
        });
    }

    @Test
    public void postIncrement() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return value++;
            }
        });
    }

    @Test
    public void postIncrementValue() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                double next = value++;
                return value + next;
            }
        });
    }

    @Test
    public void postIncrementLike() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return value + 1;
            }
        });
    }

    @Test
    public void preIncrement() {
        assertScript(new ScriptForDouble() {

            public double execute(double value) {
                return ++value;
            }
        });
    }
}
