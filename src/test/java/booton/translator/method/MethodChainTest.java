/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.method;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/12/11 13:10:42
 */
@SuppressWarnings("unused")
public class MethodChainTest extends ScriptTester {

    @Test
    public void chainInMultiLines() throws Exception {
        test(new Scriptable() {

            public String act() {
                String result = "long".replace("looooooooooooooooooooooooooooooooooooooooong", "short")
                        .replace("loooooooooooooooooooooooooooooooooooooooooooooooooooooooooong", "short");

                return result;
            }
        });
    }
}
