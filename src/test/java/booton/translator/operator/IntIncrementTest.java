/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.operator;

import org.junit.Test;

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2013/03/13 17:53:37
 */
@SuppressWarnings("unused")
public class IntIncrementTest extends ScriptTester {

    @Test
    public void incrementFieldInMethodCall() throws Exception {
        test(new Scriptable() {

            private int index = 0;

            public int act() {
                return call(index++);
            }

            private int call(int value) {
                return index + value * 10;
            }
        });
    }

    @Test
    public void decrementFieldInMethodCall() throws Exception {
        test(new Scriptable() {

            private int index = 0;

            public int act() {
                return call(index--);
            }

            private int call(int value) {
                return index + value * 10;
            }
        });
    }

    @Test
    public void preincrementFieldInMethodCall() throws Exception {
        test(new Scriptable() {

            private int index = 0;

            public int act() {
                return call(++index);
            }

            private int call(int value) {
                return index + value * 10;
            }
        });
    }

    @Test
    public void predecrementFieldInMethodCall() throws Exception {
        test(new Scriptable() {

            private int index = 0;

            public int act() {
                return call(--index);
            }

            private int call(int value) {
                return index + value * 10;
            }
        });
    }

    @Test
    public void incrementFieldInFieldAccess() throws Exception {
        test(new Scriptable() {

            private int index = 1;

            private int count = 2;

            public int act() {
                index = count++;

                return count + index * 10;
            }
        });
    }

    @Test
    public void decrementFieldInFieldAccess() throws Exception {
        test(new Scriptable() {

            private int index = 1;

            private int count = 2;

            public int act() {
                index = count--;

                return count + index * 10;
            }
        });
    }

    @Test
    public void preincrementFieldInFieldAccess() throws Exception {
        test(new Scriptable() {

            private int index = 1;

            private int count = 2;

            public int act() {
                index = ++count;

                return count + index * 10;
            }
        });
    }

    @Test
    public void predecrementFieldInFieldAccess() throws Exception {
        test(new Scriptable() {

            private int index = 1;

            private int count = 2;

            public int act() {
                index = --count;

                return count + index * 10;
            }
        });
    }
}
