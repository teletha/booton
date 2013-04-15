/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/04/15 16:37:18
 */
@SuppressWarnings("unused")
public class StringBuilderTest extends ScriptTester {

    @Test
    public void constructorEmpty() throws Exception {
        test(new Scriptable() {

            String act() {
                StringBuilder builder = new StringBuilder();
                return builder.toString();
            }
        });
    }

    @Test
    public void constructorString() throws Exception {
        test(new Scriptable() {

            String act() {
                StringBuilder builder = new StringBuilder("init");
                return builder.toString();
            }
        });
    }

    @Test
    public void appendInt() throws Exception {
        test(new Scriptable() {

            String act() {
                StringBuilder builder = new StringBuilder();
                builder.append(1);

                assert builder.toString().equals("1");

                return builder.toString();
            }
        });
    }

    @Test
    public void appendDouble() throws Exception {
        test(new Scriptable() {

            String act() {
                StringBuilder builder = new StringBuilder();
                builder.append(0.1d);
                assert builder.toString().equals("0.1");

                return builder.toString();
            }
        });
    }

    @Test
    public void appendString() throws Exception {
        test(new Scriptable() {

            String act() {
                StringBuilder builder = new StringBuilder();
                builder.append("add");

                assert builder.toString().equals("add");

                return builder.toString();
            }
        });
    }

    @Test
    public void appendObject() throws Exception {
        test(new Scriptable() {

            String act() {
                StringBuilder builder = new StringBuilder();
                builder.append(this);

                assert builder.toString().equals("scriptable object");

                return builder.toString();
            }

            public String toString() {
                return "scriptable object";
            }
        });
    }

    @Test
    public void appendNull() throws Exception {
        test(new Scriptable() {

            String act() {
                StringBuilder builder = new StringBuilder();
                builder.append((Object) null);
                builder.append((String) null);

                assert builder.toString().equals("nullnull");

                return builder.toString();
            }
        });
    }

    @Test
    public void delete() throws Exception {
        test(new Scriptable() {

            String act() {
                StringBuilder builder = new StringBuilder();
                builder.append("test");
                builder.delete(0, 2);

                assert builder.toString().equals("st");

                return builder.toString();
            }
        });
    }

    @Test
    public void deleteCharAt() throws Exception {
        test(new Scriptable() {

            String act() {
                StringBuilder builder = new StringBuilder();
                builder.append("test");
                builder.deleteCharAt(1);

                assert builder.toString().equals("tst");

                return builder.toString();
            }
        });
    }
}
