/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.operator;

import org.junit.Test;

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2013/08/14 10:23:29
 */
@SuppressWarnings("unused")
public class AssignmentTest extends ScriptTester {

    @Test
    public void onelineInExpresion() {
        test(new Scriptable() {

            public int act(int value) {
                boolean result = (value = value + 3) % 2 == 0;

                return result ? value : value + 1;
            }
        });
    }

    @Test
    public void dual() {
        test(new Scriptable() {

            public int act(int value) {
                int a, b;

                a = b = value + 1;

                return a * b;
            }
        });
    }

    @Test
    public void multiple() {
        test(new Scriptable() {

            public int act(int value) {
                int a, b, c;

                a = b = c = value + 1;

                return a * b * c;
            }
        });
    }

    @Test
    public void fieldDual() {
        test(new Scriptable() {

            private int a;

            private int b;

            public int act(int value) {
                a = b = value;

                return a + b;
            }
        });
    }

    @Test
    public void fieldMultiple() {
        test(new Scriptable() {

            private double a;

            private double b;

            private double c;

            public double act(double value) {
                a = b = c = value;

                return a + b + c;
            }
        });
    }

    @Test
    public void fieldMix() {
        test(new Scriptable() {

            private long a;

            public long act(long value) {
                long a = this.a = value;

                return a + this.a;
            }
        });
    }
}
