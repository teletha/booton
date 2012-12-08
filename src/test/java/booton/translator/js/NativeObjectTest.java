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
public class NativeObjectTest extends ScriptTester {

    @Test
    public void object() throws Exception {
        test(new Scriptable() {

            void act() {
                NativeObject object = new NativeObject();

                assert object != null;
            }
        });
    }
}
