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

import booton.translator.Debuggable;
import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/05/13 11:58:55
 */
@SuppressWarnings("unused")
public class CharTest extends ScriptTester {

    @Test
    public void Char() {
        test(new Scriptable() {

            char act(char value) {
                return value;
            }
        });
    }

    @Test
    public void Equal() {
        test(new Scriptable() {

            @Debuggable
            boolean act(char value) {
                return value == 'a';
            }
        });
    }

    @Test
    public void EqualNumber() {
        test(new Scriptable() {

            @Debuggable
            boolean act(char value) {
                return value == 97; // a
            }
        });
    }

    @Test
    public void add() {
        test(new Scriptable() {

            int act(char value) {
                return value + 1;
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
}
