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

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

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

    @Test
    public void incrementStatiFieldInFieldAccess() throws Exception {
        test(new IncrementStaticField());
    }

    /**
     * @version 2013/03/13 17:21:44
     */
    private static class IncrementStaticField implements Scriptable {

        private static int index = 1;

        private static int count = 2;

        public int act() {
            index = count++;

            return count + index * 10;
        }
    }

    @Test
    public void decrementStatiFieldInFieldAccess() throws Exception {
        test(new DecrementStaticField());
    }

    /**
     * @version 2013/03/13 17:21:44
     */
    private static class DecrementStaticField implements Scriptable {

        private static int index = 1;

        private static int count = 2;

        public int act() {
            index = count--;

            return count + index * 10;
        }
    }

    @Test
    public void preincrementStatiFieldInFieldAccess() throws Exception {
        test(new PreincrementStaticField());
    }

    /**
     * @version 2013/03/13 17:21:44
     */
    private static class PreincrementStaticField implements Scriptable {

        private static int index = 1;

        private static int count = 2;

        public int act() {
            index = ++count;

            return count + index * 10;
        }
    }

    @Test
    public void predecrementStatiFieldInFieldAccess() throws Exception {
        test(new PredecrementStaticField());
    }

    /**
     * @version 2013/03/13 17:21:44
     */
    private static class PredecrementStaticField implements Scriptable {

        private static int index = 1;

        private static int count = 2;

        public int act() {
            index = --count;

            return count + index * 10;
        }
    }
}
