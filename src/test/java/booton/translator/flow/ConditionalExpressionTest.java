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

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/12/07 14:54:26
 */
@SuppressWarnings("unused")
public class ConditionalExpressionTest extends ScriptTester {

    @Test
    public void withExpression() throws Exception {
        test(new Scriptable() {

            public int act(String value) {
                return 31 + (value == null ? 0 : value.length());
            }
        });
    }
}
