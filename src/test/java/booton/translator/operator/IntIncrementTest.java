/*
 * Copyright (C) 2014 Nameless Production Committee
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
 * @version 2014/01/01 21:25:29
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

    @Test
    public void postIncrementParentFieldInLocalVariableAccess() throws Exception {
        test(new Scriptable() {

            public int act() {
                Parent parent = new Parent();
                int old = parent.child.postIncrement();
                return parent.value + old;
            }
        });
    }

    @Test
    public void preIncrementParentFieldInLocalVariableAccess() throws Exception {
        test(new Scriptable() {

            public int act() {
                Parent parent = new Parent();
                int old = parent.child.preIncrement();
                return parent.value + old;
            }
        });
    }

    @Test
    public void postDecrementParentFieldInLocalVariableAccess() throws Exception {
        test(new Scriptable() {

            public int act() {
                Parent parent = new Parent();
                int old = parent.child.postDecrement();
                return parent.value + old;
            }
        });
    }

    @Test
    public void preDecrementParentFieldInLocalVariableAccess() throws Exception {
        test(new Scriptable() {

            public int act() {
                Parent parent = new Parent();
                int old = parent.child.preDecrement();
                return parent.value + old;
            }
        });
    }

    /**
     * @version 2014/01/01 20:56:31
     */
    private static class Parent {

        int value = 10;

        private Child child = new Child();

        /**
         * @version 2014/01/01 20:56:39
         */
        private class Child {

            int postIncrement() {
                int old = value++;

                return old;
            }

            int preIncrement() {
                int old = ++value;

                return old;
            }

            int postDecrement() {
                int old = value--;

                return old;
            }

            int preDecrement() {
                int old = --value;

                return old;
            }
        }
    }
}
