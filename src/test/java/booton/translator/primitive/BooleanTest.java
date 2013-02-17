/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.primitive;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/02/17 12:07:49
 */
@SuppressWarnings("unused")
public class BooleanTest extends ScriptTester {

    @Test
    public void Boolean() {
        test(new Scriptable() {

            int act(boolean value) {
                value = !value;

                if (value) {
                    return 1;
                } else {
                    return 2;
                }
            }
        });
    }

    @Test
    public void Boolean2() {
        test(new Scriptable() {

            boolean act(boolean value) {
                value = !value;

                return !value;
            }
        });
    }
}
