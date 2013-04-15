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

import booton.translator.Debuggable;
import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/04/15 16:37:18
 */
@SuppressWarnings("unused")
public class JSStringBuilderTest extends ScriptTester {

    @Test
    public void constructorEmpty() throws Exception {
        test(new Scriptable() {

            String act() {
                JSStringBuilder builder = new JSStringBuilder();
                return builder.toString();
            }
        });
    }

    @Test
    public void constructorString() throws Exception {
        test(new Scriptable() {

            String act() {
                JSStringBuilder builder = new JSStringBuilder("init");
                return builder.toString();
            }
        });
    }

    @Test
    public void appendString() throws Exception {
        test(new Scriptable() {

            String act() {
                JSStringBuilder builder = new JSStringBuilder();
                builder.append("add");

                return builder.toString();
            }
        });
    }

    @Test
    public void appendObject() throws Exception {
        test(new Scriptable() {

            @Debuggable
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
}
