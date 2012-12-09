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
 * @version 2012/12/09 2:00:49
 */
@SuppressWarnings("unused")
public class NativeObjectTest extends ScriptTester {

    @Test
    public void property() throws Exception {
        test(new Scriptable() {

            Object act(String value) {
                NativeObject object = new NativeObject();
                assert object.getProperty("key") == null;

                object.setProperty("key", value);

                // assert object != null;
                return object.getProperty("key");
            }
        });
    }

    // @Test
    // public void propertyIntKey() throws Exception {
    // test(new Scriptable() {
    //
    // Object act(int key) {
    // NativeObject object = new NativeObject();
    // object.setProperty(key, "value");
    //
    // // assert object != null;
    // return object.getProperty(key);
    // }
    // });
    // }
}
