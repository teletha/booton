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
 * @version 2013/02/17 15:09:01
 */
@SuppressWarnings("unused")
public class LongIncrementTest extends ScriptTester {

    @Test
    public void incrementFieldInMethodCall() throws Exception {
        test(new Scriptable() {

            private long index = 0;

            public long act() {
                return call(index++);
            }

            private long call(long value) {
                return index + value * 10;
            }
        });
    }

    @Test
    public void decrementFieldInMethodCall() throws Exception {
        test(new Scriptable() {

            private long index = 0;

            public long act() {
                return call(index--);
            }

            private long call(long value) {
                return index + value * 10;
            }
        });
    }

    @Test
    public void preincrementFieldInMethodCall() throws Exception {
        test(new Scriptable() {

            private long index = 0;

            public long act() {
                return call(++index);
            }

            private long call(long value) {
                return index + value * 10;
            }
        });
    }

    @Test
    public void predecrementFieldInMethodCall() throws Exception {
        test(new Scriptable() {

            private long index = 0;

            public long act() {
                return call(--index);
            }

            private long call(long value) {
                return index + value * 10;
            }
        });
    }

    @Test
    public void incrementFieldInFieldAccess() throws Exception {
        test(new Scriptable() {

            private long index = 1;

            private long count = 2;

            public long act() {
                index = count++;

                return count + index * 10;
            }
        });
    }

    @Test
    public void decrementFieldInFieldAccess() throws Exception {
        test(new Scriptable() {

            private long index = 1;

            private long count = 2;

            public long act() {
                index = count--;

                return count + index * 10;
            }
        });
    }

    @Test
    public void preincrementFieldInFieldAccess() throws Exception {
        test(new Scriptable() {

            private long index = 1;

            private long count = 2;

            public long act() {
                index = ++count;

                return count + index * 10;
            }
        });
    }

    @Test
    public void predecrementFieldInFieldAccess() throws Exception {
        test(new Scriptable() {

            private long index = 1;

            private long count = 2;

            public long act() {
                index = --count;

                return count + index * 10;
            }
        });
    }
}
