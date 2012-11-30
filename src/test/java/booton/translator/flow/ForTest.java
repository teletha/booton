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

import org.junit.Ignore;
import org.junit.Test;

import booton.translator.api.Scriptable;
import booton.translator.api.ScriptTester;

/**
 * @version 2012/11/30 8:36:59
 */
@SuppressWarnings("unused")
public class ForTest extends ScriptTester {

    @Test
    public void one() throws Exception {
        test(new Scriptable() {

            int act() {
                int m = 0;

                for (int i = 0; i < 3; i++) {
                    m++;
                }
                System.out.println(m);
                return m;
            }
        });
    }

    @Test
    @Ignore
    public void two() throws Exception {
        test(new Scriptable() {

            int act() {
                int m = 0;

                for (int i = 0; i < 3; i++) {
                    m++;
                }
                return m;
            }
        });
    }

    @Test
    public void three() throws Exception {
        testByBoolean(new Scriptable() {

            String act(boolean value) {
                return value ? "Q" : "P";
            }
        });
    }
}
