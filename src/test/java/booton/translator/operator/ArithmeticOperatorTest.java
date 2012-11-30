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

import booton.translator.api.Param;
import booton.translator.api.ScriptTester;
import booton.translator.api.Scriptable;

/**
 * @version 2012/12/01 3:19:44
 */
public class ArithmeticOperatorTest extends ScriptTester {

    @Test
    public void AdditionLeft() {
        test(new Scriptable() {

            public int act(int value) {
                return 1 + value;
            }
        });
    }

    @Test
    public void AdditonRight() {
        test(new Scriptable() {

            public int act(int value) {
                return value + 1;
            }
        });
    }

    @Test
    public void SubtractionLeft() {
        test(new Scriptable() {

            public int act(int value) {
                return 10 - value;
            }
        });
    }

    @Test
    public void SubtractionRight() {
        test(new Scriptable() {

            public int act(int value) {
                return value - 10;
            }
        });
    }

    @Test
    public void MultiplicationLeft() {
        test(new Scriptable() {

            public double act(double value) {
                return value * 3;
            }
        });
    }

    @Test
    public void MultiplicationRight() {
        test(new Scriptable() {

            public double act(double value) {
                return -3 * value;
            }
        });
    }

    @Test
    public void DivisionLeft() {
        test(new Scriptable() {

            public double act(double value) {
                return value / 2;
            }
        });
    }

    @Test
    public void DivisionRight() {
        test(new Scriptable() {

            public double act(@Param(doubles = {1, 3, 4}) double value) {
                return 12 / value;
            }
        });
    }

    @Test
    public void ReminderLeft() {
        test(new Scriptable() {

            public int act(int value) {
                return value % 7;
            }
        });
    }

    @Test
    public void ReminderRight() {
        test(new Scriptable() {

            public int act(int value) {
                return 40 % value;
            }
        });
    }
}
