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

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;
import booton.translator.Debuggable;

/**
 * @version 2013/08/31 22:21:41
 */
@SuppressWarnings("unused")
public class CharTest extends ScriptTester {

    @Test
    public void primitive() {
        test(new Scriptable() {

            char act(char value) {
                return value;
            }
        });
    }

    @Test
    public void equalToChar() {
        test(new Scriptable() {

            boolean act(char value) {
                return value == 'a';
            }
        });
    }

    @Test
    public void equalToNumber1() {
        test(new Scriptable() {

            boolean act(char value) {
                return value == 97; // a
            }
        });
    }

    @Test
    public void equalToNumber2() {
        test(new Scriptable() {

            boolean act(char value) {
                return 97 == value; // a
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
    public void subtract() {
        test(new Scriptable() {

            int act(char value) {
                return value - 10;
            }
        });
    }

    @Test
    public void codition() {
        test(new Scriptable() {

            boolean act(char value) {
                return value < 60;
            }
        });
    }

    @Test
    public void cast() {
        test(new Scriptable() {

            @Debuggable
            char act(char value) {
                return (char) (value + 1);
            }
        });
    }
}
