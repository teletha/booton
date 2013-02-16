/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.operator;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/12/09 17:10:42
 */
@SuppressWarnings("unused")
public class IncrementTest extends ScriptTester {

    @Test
    public void incrementFieldInMethodCall() throws Exception {
        test(new Scriptable() {

            private int index = 0;

            public int act() {
                return call(index++);
            }

            private int call(int value) {
                return value;
            }
        });
    }

    @Test
    public void preincrementFieldInMethodCall() throws Exception {
        test(new Scriptable() {

            private int index = 0;

            public int act() {
                return call(--index);
            }

            private int call(int value) {
                return value;
            }
        });
    }

    @Test
    public void incrementFieldInFieldAccess() throws Exception {
        test(new Scriptable() {

            private int index = 0;

            private int count = 0;

            public int act() {
                index = count++;

                return count;
            }
        });
    }
}
