/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.method;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/01/21 16:49:37
 */
@SuppressWarnings("unused")
public class LocalVariableTest extends ScriptTester {

    @Test
    public void parallel() {
        test(new Scriptable() {

            public int act(int value) {
                if (value < 1) {
                    int x = value;

                    value = value - 1;
                    value = x * value;
                } else {
                    int y = value;

                    value = value + 1;
                    value = y * value;
                }
                return value;
            }
        });
    }

    @Test
    public void PrimitiveLongAndDoubleUses2Stacks() {
        test(new Scriptable() {

            double act(double value) {
                return calc(20, value, 10);
            }

            double calc(double one, double two, long three) {
                return one * two + three;
            }
        });
    }

    @Test
    public void CompilerGeneratedCodeDoesntProduceLocalVariableOperand() {
        test(new CompilerGenerator());
    }

    /**
     * @version 2013/01/21 16:51:53
     */
    private static class CompilerGenerator implements Scriptable {

        double act() {
            return new CompilerGeneratedCode().calc(10, 10);
        }

        /**
         * @version 2013/01/21 16:52:11
         */
        private static class CompilerGeneratedCode {

            private double calc(double one, double two) {
                return one * two;
            }
        }
    }
}
