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

import booton.translator.Param;
import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/01/25 12:57:02
 */
@SuppressWarnings("unused")
public class LookupSwitchTest extends ScriptTester {

    @Test
    public void Return() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                switch (value * 2000) {
                case 0:
                    return 0;

                case 10000:
                    return 1;

                default:
                    return value + 5;
                }
            }
        });
    }

    @Test
    public void StrangeOrder() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                switch (value * 2000) {
                case 2000:
                    return 0;

                case 0:
                    return 1;

                default:
                    return value + 5;
                }
            }
        });
    }

    @Test
    public void Multiple() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                switch (value * 2000) {
                case 0:
                case 10000:
                    return 1;

                default:
                    return value + 5;
                }
            }
        });
    }
}
