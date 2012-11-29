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
package booton.translator.operator;

import org.junit.Test;

import booton.translator.ScriptTranslatorTestcase;
import booton.translator.api.DoubleScript;
import booton.translator.api.IntScript;

/**
 * @version 2009/06/27 13:51:44
 */
public class ArithmeticOperatorTest extends ScriptTranslatorTestcase {

    @Test
    public void AdditionLeft() {
        assertScript(-20, 20, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                return 1 + value;
            }
        });
    }

    @Test
    public void AdditonRight() {
        assertScript(-20, 20, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                return value + 1;
            }
        });
    }

    @Test
    public void SubtractionLeft() {
        assertScript(-20, 20, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                return 10 - value;
            }
        });
    }

    @Test
    public void SubtractionRight() {
        assertScript(-20, 20, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                return value - 10;
            }
        });
    }

    @Test
    public void MultiplicationLeft() {
        assertScript(-20, 20, new DoubleScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public double execute(double value) {
                return value * 3;
            }
        });
    }

    @Test
    public void MultiplicationRight() {
        assertScript(-20, 20, new DoubleScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public double execute(double value) {
                return -3 * value;
            }
        });
    }

    @Test
    public void DivisionLeft() {
        assertScript(-20, 20, new DoubleScript() {

            /**
             * @see booton.translator.api.DoubleScript#execute(double)
             */
            public double execute(double value) {
                return value / 2;
            }
        });
    }

    @Test
    public void DivisionRight() {
        assertScript(1, 20, new DoubleScript() {

            /**
             * @see booton.translator.api.DoubleScript#execute(double)
             */
            public double execute(double value) {
                return 12 / value;
            }
        });
    }

    @Test
    public void ReminderLeft() {
        assertScript(-20, 20, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                return value % 7;
            }
        });
    }

    @Test
    public void ReminderRight() {
        assertScript(1, 20, new IntScript() {

            /**
             * @see booton.translator.api.IntScript#execute(int)
             */
            public int execute(int value) {
                return 40 % value;
            }
        });
    }
}
