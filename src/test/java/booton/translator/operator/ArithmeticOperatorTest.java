/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.operator;

import org.junit.Test;

import booton.soeur.Param;
import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2013/03/27 23:00:37
 */
@SuppressWarnings("unused")
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

            public int act(@Param(from = 1, to = 10) int value) {
                return 40 % value;
            }
        });
    }

    @Test
    public void Complex() {
        test(new Scriptable() {

            public int act(@Param(from = 1, to = 10) int value) {
                return (value + 2) * 2;
            }
        });
    }

    @Test
    public void Negative() {
        test(new Scriptable() {

            public int act(int value) {
                return -value;
            }
        });
    }
}
