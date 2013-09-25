/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.flow;

import org.junit.Test;

import booton.translator.Debuggable;
import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/11/30 18:53:43
 */
@SuppressWarnings("unused")
public class ForTest extends ScriptTester {

    @Test
    public void noneReturnCodeAfterLoopWillConfuseCompiler() throws Exception {
        test(new Scriptable() {

            String act() {
                int m = 0;

                for (int i = 0; i < 3; i++) {
                    m++;
                }
                String.valueOf(m); // noise

                return String.valueOf(m);
            }
        });
    }

    @Test
    public void nestContinue() throws Exception {
        test(new Scriptable() {

            @Debuggable
            int act(int value) {
                root: for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (j == 3) {
                            continue root;
                        }
                    }
                    value++;
                }
                return value;
            }
        });
    }
}
