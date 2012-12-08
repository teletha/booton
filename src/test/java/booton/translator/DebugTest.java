/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import org.junit.Test;

/**
 * @version 2012/12/08 13:42:54
 */
public class DebugTest extends ScriptTester {

    @Test
    public void debug() throws Exception {
        test(new Scriptable() {

            int act(int key) {
                int dummy;

                if (key != 1 && (dummy = key * key) != key) {
                    return key;
                }
                return key;
            }
        });
    }

    @Test
    public void debug2() throws Exception {
        test(new Scriptable() {

            int act(int key) {
                int dummy = 1;

                if (key != 2 && (key = dummy) == key) {
                    return key;
                }
                return key;
            }
        });
    }
}
