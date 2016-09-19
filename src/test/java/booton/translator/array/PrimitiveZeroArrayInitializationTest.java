/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.array;

import org.junit.Test;

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * <p>
 * In Java, initial value is 0 for primitives array. But in Javascript, initial value is undefined.
 * </p>
 * 
 * @version 2013/02/12 0:03:51
 */
@SuppressWarnings("unused")
public class PrimitiveZeroArrayInitializationTest extends ScriptTester {

    @Test
    public void Integer() throws Exception {
        test(new Scriptable() {

            private int[] zero = {0, 0, 0};

            public int act() {
                return zero[0] + 1;
            }
        });
    }

    @Test
    public void Long() throws Exception {
        test(new Scriptable() {

            private long[] zero = {0, 0, 0};

            public long act() {
                return zero[0] + 1;
            }
        });
    }

    @Test
    public void Float() throws Exception {
        test(new Scriptable() {

            private float[] zero = {0, 0, 0};

            public float act() {
                return zero[0] + 1;
            }
        });
    }

    @Test
    public void Double() throws Exception {
        test(new Scriptable() {

            private double[] zero = {0, 0, 0};

            public double act() {
                return zero[0] + 1;
            }
        });
    }
}
