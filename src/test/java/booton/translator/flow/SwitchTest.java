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

import org.junit.Ignore;
import org.junit.Test;

import booton.translator.Param;
import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/01/22 20:36:50
 */
@SuppressWarnings("unused")
public class SwitchTest extends ScriptTester {

    @Test
    public void Return() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                switch (value) {
                case 0:
                    return 0;

                case 1:
                    return 1;

                default:
                    return value + 5;
                }
            }
        });
    }

    @Test
    public void Sparse() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                switch (value) {
                case 0:
                    return 0;

                case 2:
                    return 1;

                case 4:
                    return 10;

                default:
                    return value + 5;
                }
            }
        });
    }

    @Test
    public void NoDefault() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                switch (value) {
                case 0:
                    return 0;

                case 2:
                    value++;
                    break;

                case 4:
                    return 10;
                }
                return value + 10;
            }
        });
    }

    @Test
    @Ignore
    public void SwitchReturnWithOrder() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                switch (value) {
                default:
                    return value + 5;

                case 1:
                    return 1;

                case 0:
                    return 0;
                }
            }
        });
    }

    @Test
    @Ignore
    public void SwitchBreak() {
        test(new Scriptable() {

            public int act(@Param(from = 0, to = 5) int value) {
                int result;

                switch (value) {
                case 0:
                    result = -1;
                    break;

                case 1:
                    result = 10;
                    break;

                default:
                    result = value;
                    break;
                }

                return result;
            }
        });
    }
}
