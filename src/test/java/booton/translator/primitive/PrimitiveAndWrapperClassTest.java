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
 * @version 2013/04/13 14:40:19
 */
@SuppressWarnings("unused")
public class PrimitiveAndWrapperClassTest extends ScriptTester {

    @Test
    public void IntegerPrimitive() throws Exception {
        test(new Scriptable() {

            Class act() {
                return int.class;
            }
        });
    }

    @Test
    public void IntegerWrapper() throws Exception {
        test(new Scriptable() {

            Class act() {
                return Integer.class;
            }
        });
    }

    @Test
    public void IntegerPrimitiveAndWrapper() throws Exception {
        test(new Scriptable() {

            boolean act() {
                assert Integer.class != int.class;
                return Integer.class == int.class;
            }
        });
    }

    @Test
    public void DoublePrimitive() throws Exception {
        test(new Scriptable() {

            Class act() {
                return double.class;
            }
        });
    }

    @Test
    public void DoubleWrapper() throws Exception {
        test(new Scriptable() {

            Class act() {
                return Double.class;
            }
        });
    }

    @Test
    public void DoublePrimitiveAndWrapper() throws Exception {
        test(new Scriptable() {

            boolean act() {
                assert Double.class != double.class;
                return Double.class == double.class;
            }
        });
    }
}
