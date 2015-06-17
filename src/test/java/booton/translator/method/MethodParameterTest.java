/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.method;

import org.junit.Test;

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2012/12/01 2:20:08
 */
@SuppressWarnings("unused")
public class MethodParameterTest extends ScriptTester {

    @Test
    public void Int() {
        test(new Scriptable() {

            int act(int value) {
                return value;
            }
        });
    }

    @Test
    public void Long() {
        test(new Scriptable() {

            long act(long value) {
                return value;
            }
        });
    }

    @Test
    public void Float() {
        test(new Scriptable() {

            float act(float value) {
                return value;
            }
        });
    }

    @Test
    public void Double() {
        test(new Scriptable() {

            double act(double value) {
                return value;
            }
        });
    }

    @Test
    public void Byte() {
        test(new Scriptable() {

            byte act(byte value) {
                return value;
            }
        });
    }

    @Test
    public void Short() {
        test(new Scriptable() {

            short act(short value) {
                return value;
            }
        });
    }

    @Test
    public void Boolean() {
        test(new Scriptable() {

            boolean act(boolean value) {
                return value;
            }
        });
    }

    @Test
    public void String() {
        test(new Scriptable() {

            String act(String value) {
                return value;
            }
        });
    }
}
