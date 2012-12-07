/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.flow;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/12/07 11:28:35
 */
@SuppressWarnings("unused")
public class ConditionTest extends ScriptTester {

    @Test
    public void IFEQ() throws Exception {
        test(new Scriptable() {

            public boolean act(int value) {
                return value != 0;
            }
        });
    }

    @Test
    public void IFNE() throws Exception {
        test(new Scriptable() {

            public boolean act(int value) {
                return value == 0;
            }
        });
    }

    @Test
    public void IFGE() throws Exception {
        test(new Scriptable() {

            public boolean act(int value) {
                return value < 0;
            }
        });
    }

    @Test
    public void IFLE() throws Exception {
        test(new Scriptable() {

            public boolean act(int value) {
                return value > 0;
            }
        });
    }

    @Test
    public void IF_ICMPNE() throws Exception {
        test(new Scriptable() {

            public boolean act(int value) {
                return value == 1;
            }
        });
    }

    @Test
    public void IF_ICMPEQ() throws Exception {
        test(new Scriptable() {

            public boolean act(int value) {
                return value != 1;
            }
        });
    }

    @Test
    public void IF_ICMPGE() throws Exception {
        test(new Scriptable() {

            public boolean act(int value) {
                return value < 1;
            }
        });
    }

    @Test
    public void IF_ICMPLE() throws Exception {
        test(new Scriptable() {

            public boolean act(int value) {
                return value > 1;
            }
        });
    }
}
