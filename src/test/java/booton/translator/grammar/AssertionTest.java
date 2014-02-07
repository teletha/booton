/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.grammar;

import org.junit.Test;

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;
import booton.translator.Debuggable;

/**
 * @version 2014/02/07 13:10:32
 */
@SuppressWarnings("unused")
public class AssertionTest extends ScriptTester {

    @Test
    public void single() throws Exception {
        test(new Scriptable() {

            void act(int value) {
                assert value != 10;
            }
        });
    }

    @Test
    public void multiple() throws Exception {
        test(new Scriptable() {

            @Debuggable
            void act(int value) {
                assert value != 10 || value != 20;
            }
        });
    }

    // @Test
    // public void testname() throws Exception {
    // test(new Scriptable() {
    //
    // @Debuggable
    // void act(int value) {
    // if (value != 10 || value != 20) {
    // throw new Error();
    // }
    // }
    // });
    // }
}
