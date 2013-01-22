/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.sdk;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/01/22 15:57:17
 */
@SuppressWarnings("unused")
public class SystemArrayCopyTest extends ScriptTester {

    @Test
    public void object() throws Exception {
        test(new Scriptable() {

            private Object[] source = {"a", "b", "c"};

            Object[] act() {
                Object[] copy = new Object[source.length];
                assert copy.length == 3;
                assert copy[0] == null;
                assert copy[1] == null;
                assert copy[2] == null;

                System.arraycopy(source, 0, copy, 0, source.length);
                assert copy[0] == "a";
                assert copy[1] == "b";
                assert copy[2] == "c";

                return copy;
            }
        });
    }
}
