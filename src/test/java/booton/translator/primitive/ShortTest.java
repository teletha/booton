/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.primitive;

import org.junit.Test;

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2012/12/01 2:07:31
 */
@SuppressWarnings("unused")
public class ShortTest extends ScriptTester {

    @Test
    public void zero() {
        test(new Scriptable() {

            short act(short value) {
                return 0;
            }
        });
    }

    @Test
    public void one() {
        test(new Scriptable() {

            short act(short value) {
                return 1;
            }
        });
    }

    @Test
    public void two() {
        test(new Scriptable() {

            short act(short value) {
                return 2;
            }
        });
    }

    @Test
    public void three() {
        test(new Scriptable() {

            short act(short value) {
                return 3;
            }
        });
    }

    @Test
    public void minus() {
        test(new Scriptable() {

            short act(short value) {
                return -1;
            }
        });
    }

    @Test
    public void max() {
        test(new Scriptable() {

            short act(short value) {
                return Short.MAX_VALUE;
            }
        });
    }

    @Test
    public void min() {
        test(new Scriptable() {

            short act(short value) {
                return Short.MIN_VALUE;
            }
        });
    }
}
