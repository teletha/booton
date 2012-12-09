/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.js;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/12/09 15:49:21
 */
@SuppressWarnings("unused")
public class NativeArrayTest extends ScriptTester {

    @Test
    public void push() throws Exception {
        test(new Scriptable() {

            public int act() {
                NativeArray<String> array = new NativeArray();
                assert array.length() == 0;

                array.push("1");
                assert array.length() == 1;

                return array.length();
            }
        });
    }

    @Test
    public void indexOf() throws Exception {
        test(new Scriptable() {

            public int act() {
                NativeArray<String> array = new NativeArray();
                assert array.length() == 0;

                array.push("1");
                assert array.length() == 1;

                int index = array.indexOf("1");
                assert index == 0;

                return index;
            }
        });
    }

    @Test
    public void remove() throws Exception {
        test(new Scriptable() {

            public int act() {
                NativeArray<String> array = new NativeArray();
                assert array.length() == 0;

                array.push("1");
                assert array.length() == 1;

                int index = array.indexOf("1");
                assert index == 0;

                array.remove(index);
                assert array.length() == 0;

                return array.length();
            }
        });
    }
}
