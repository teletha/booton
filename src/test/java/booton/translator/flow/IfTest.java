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
 * @version 2012/12/05 13:19:40
 */
@SuppressWarnings("unused")
public class IfTest extends ScriptTester {

    @Test
    public void integer() throws Exception {
        test(new Scriptable() {

            public boolean act(int value) {
                if (value == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    @Test
    public void object() throws Exception {
        test(new Scriptable() {

            public boolean act(Object o) {
                if (o == null) {
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    @Test
    public void object2() throws Exception {
        test(new Scriptable() {

            public boolean act(Object o) {
                if (o != null) {
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    @Test
    public void shorthand22() throws Exception {
        test(new Scriptable() {

            public boolean act(int o) {
                while (o < 4) {
                    o = o + 2;
                    if (o == 2) return true;
                }
                return false;
            }
        });
    }

    @Test
    public void object4() throws Exception {
        test(new Scriptable() {

            public boolean act(int o) {
                while (o < 4) {
                    o = o + 2;
                    if (o == 2) {
                        return true;
                    }
                }
                return false;
            }
        });
    }

    @Test
    public void shorthand() throws Exception {
        test(new Scriptable() {

            public int act(int o) {
                if (o == 2) return o + 3;
                return o;
            }
        });
    }

    @Test
    public void shorthand3() throws Exception {
        test(new Scriptable() {

            public boolean act(int o) {
                return o == 3;
            }
        });
    }

    @Test
    public void shorthand2() throws Exception {
        test(new Scriptable() {

            public int act(int o) {
                if (o == 2) {
                    return o + 3;
                }
                return o;
            }
        });
    }
}
