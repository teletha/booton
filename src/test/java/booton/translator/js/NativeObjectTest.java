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
 * @version 2012/12/09 13:14:54
 */
@SuppressWarnings("unused")
public class NativeObjectTest extends ScriptTester {

    @Test
    public void property() throws Exception {
        test(new Scriptable() {

            public Object act() {
                String value = "value";

                NativeObject instance = new NativeObject();
                assert instance.getProperty("key") == null;

                instance.setProperty("key", value);
                assert instance.getProperty("key") == value;
                assert instance.getProperty("key").equals(value);

                return instance.getProperty("key");
            }
        });
    }

    @Test
    public void propertyNull() throws Exception {
        test(new Scriptable() {

            public Object act() {
                NativeObject instance = new NativeObject();
                assert instance.getProperty("key") == null;

                instance.setProperty("key", null);
                assert instance.getProperty("key") == null;

                return instance.getProperty("key");
            }
        });
    }

    @Test
    public void hasProperty() throws Exception {
        test(new Scriptable() {

            public boolean act() {
                NativeObject instance = new NativeObject();
                assert instance.hasProperty("key") == false;
                assert instance.hasProperty("null") == false;

                instance.setProperty("key", "value");
                instance.setProperty("null", null);
                assert instance.hasProperty("key") == true;
                assert instance.hasProperty("null") == true;

                return instance.hasProperty("null");
            }
        });
    }

    @Test
    public void deleteProperty() throws Exception {
        test(new Scriptable() {

            public boolean act() {
                Object key = "key";

                NativeObject instance = new NativeObject();
                assert instance.hasProperty(key) == false;
                assert instance.getProperty(key) == null;

                Object value = instance.setProperty(key, "value");
                assert instance.hasProperty(key) == true;
                assert instance.getProperty(key) == value;

                boolean result = instance.deleteProperty(key);
                assert instance.hasProperty(key) == false;
                assert instance.getProperty(key) == null;

                return result;
            }
        });
    }

    @Test
    public void nullKey() throws Exception {
        test(new Scriptable() {

            public Object act() {
                Object key1 = null;
                Object key2 = "null";

                NativeObject instance = new NativeObject();
                assert instance.hasProperty(key1) == false;
                assert instance.hasProperty(key2) == false;

                Object value1 = instance.setProperty(key1, "value1");
                Object value2 = instance.setProperty(key2, "value2");
                assert instance.hasProperty(key1) == true;
                assert instance.hasProperty(key2) == true;
                assert instance.getProperty(key1) == value2;
                assert instance.getProperty(key2) == value2;

                return instance.getProperty(key1);
            }
        });
    }

    @Test
    public void keys() throws Exception {
        test(new Scriptable() {

            public int act() {
                Object key1 = "1";
                Object key2 = "2";
                Object key3 = "3";

                NativeObject instance = new NativeObject();
                NativeArray<String> set1 = new NativeArray(instance.keys());
                assert set1.length() == 0;

                Object value1 = instance.setProperty(key1, "value1");
                Object value2 = instance.setProperty(key2, "value2");
                Object value3 = instance.setProperty(key3, "value3");

                NativeArray<String> set2 = new NativeArray(instance.keys());
                assert set2.length() == 3;
                assert set2.indexOf(key1) != -1;
                assert set2.indexOf(key2) != -1;
                assert set2.indexOf(key3) != -1;
                assert set2.indexOf("4") == -1;

                instance.deleteProperty(key1);
                instance.deleteProperty(key3);

                NativeArray<String> set3 = new NativeArray(instance.keys());
                assert set3.length() == 1;
                assert set3.indexOf(key1) == -1;
                assert set3.indexOf(key2) != -1;
                assert set3.indexOf(key3) == -1;

                return set2.toArray().length;
            }
        });
    }
}
