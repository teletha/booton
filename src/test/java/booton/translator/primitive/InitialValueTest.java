/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.primitive;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * <p>
 * In Java, initial value is 0 for primitives. But in Javascript, initial value is undefined.
 * </p>
 * 
 * @version 2013/01/24 15:37:03
 */
@SuppressWarnings("unused")
public class InitialValueTest extends ScriptTester {

    @Test
    public void Interger() {
        test(new Scriptable() {

            private int uninitialized;

            int act() {
                return uninitialized;
            }
        });
    }

    @Test
    public void Long() {
        test(new Scriptable() {

            private long uninitialized;

            long act() {
                return uninitialized;
            }
        });
    }

    @Test
    public void Float() {
        test(new Scriptable() {

            private float uninitialized;

            float act() {
                return uninitialized;
            }
        });
    }

    @Test
    public void Double() {
        test(new Scriptable() {

            private double uninitialized;

            double act() {
                return uninitialized;
            }
        });
    }

    @Test
    public void Byte() {
        test(new Scriptable() {

            private byte uninitialized;

            byte act() {
                return uninitialized;
            }
        });
    }

    @Test
    public void Short() {
        test(new Scriptable() {

            private short uninitialized;

            short act() {
                return uninitialized;
            }
        });
    }

    @Test
    public void Char() {
        test(new Scriptable() {

            private char uninitialized;

            char act() {
                return uninitialized;
            }
        });
    }

    @Test
    public void Boolean() {
        test(new Scriptable() {

            private boolean uninitialized;

            boolean act() {
                return uninitialized;
            }
        });
    }
}
