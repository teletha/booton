/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.flow;

import org.junit.Test;

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2013/11/20 10:27:08
 */
@SuppressWarnings("unused")
public class SynchronizedTest extends ScriptTester {

    @Test
    public void base() throws Exception {
        test(new Scriptable() {

            int act() {
                synchronized (this) {
                    return 10;
                }
            }
        });
    }
}
