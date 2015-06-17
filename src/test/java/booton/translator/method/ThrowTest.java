/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.method;

import org.junit.Test;

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2012/12/07 10:51:19
 */
@SuppressWarnings("unused")
public class ThrowTest extends ScriptTester {

    @Test
    public void exception() {
        test(new Scriptable() {

            public int act() throws Exception {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    return 10;
                }
            }
        });
    }

    @Test
    public void exceptionWithParam() {
        test(new Scriptable() {

            public String act(String value) throws Exception {
                try {
                    throw new Exception("test");
                } catch (Exception e) {
                    return e.getMessage();
                }
            }
        });
    }

    @Test
    public void runtimeException() {
        test(new Scriptable() {

            public String act() {
                try {
                    throw new RuntimeException("test");
                } catch (RuntimeException e) {
                    return e.getMessage();
                }
            }
        });
    }

    @Test
    public void error() {
        test(new Scriptable() {

            public String act() {
                try {
                    throw new Error("test");
                } catch (Error e) {
                    return e.getMessage();
                }
            }
        });
    }
}
