/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import org.junit.Test;

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

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
    public void pushArray() throws Exception {
        test(new Scriptable() {

            public int act() {
                NativeArray<String> array1 = new NativeArray(new String[] {"a", "b"});
                assert array1.length() == 2;

                NativeArray<String> array2 = new NativeArray(new String[] {"c", "d"});
                assert array1.length() == 2;

                array1.push(array2);
                assert array1.length() == 4;

                return array1.length();
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

    @Test
    public void clear() throws Exception {
        test(new Scriptable() {

            public int act() {
                NativeArray<String> array = new NativeArray(new String[] {"a", "b"});
                assert array.length() == 2;

                array.clear();
                assert array.length() == 0;

                return array.length();
            }
        });
    }
}
