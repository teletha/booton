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
 * @version 2013/02/17 12:07:49
 */
@SuppressWarnings("unused")
public class BooleanTest extends ScriptTester {

    @Test
    public void Boolean() {
        test(new Scriptable() {

            boolean act(boolean value) {
                return value;
            }
        });
    }

    @Test
    public void Negative() {
        test(new Scriptable() {

            boolean act(boolean value) {
                return !value;
            }
        });
    }

    @Test
    public void Dual() {
        test(new Scriptable() {

            boolean act(boolean value) {
                return !!value;
            }
        });
    }

    @Test
    public void VariableNegative() {
        test(new Scriptable() {

            boolean act(boolean value) {
                value = !value;

                return value;
            }
        });
    }

    @Test
    public void VariableDual() {
        test(new Scriptable() {

            boolean act(boolean value) {
                value = !!value;

                return value;
            }
        });
    }

    @Test
    public void clazz() {
        test(new Scriptable() {

            Class act() {
                return boolean.class;
            }
        });
    }

    @Test
    public void classEquality() {
        test(new Scriptable() {

            boolean act() {
                return boolean.class == boolean.class;
            }
        });
    }

    @Test
    public void array() {
        test(new Scriptable() {

            Class act() {
                return boolean[].class;
            }
        });
    }

    @Test
    public void arrayClassEquality() {
        test(new Scriptable() {

            boolean act() {
                boolean[] array = {};
                return boolean[].class == array.getClass();
            }
        });
    }
}
