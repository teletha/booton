/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.operator;

import org.junit.Test;

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2014/06/07 10:53:18
 */
@SuppressWarnings("unused")
public class NegateOperatorTest extends ScriptTester {

    @Test
    public void shiftInside() throws Exception {
        test(new Scriptable() {

            int act(int value) {
                return -value >> 2;
            }
        });
    }

    @Test
    public void shiftOutside() throws Exception {
        test(new Scriptable() {

            int act(int value) {
                return -(value >> 2);
            }
        });
    }
}
