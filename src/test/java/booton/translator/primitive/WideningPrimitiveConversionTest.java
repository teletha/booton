/*
 * Copyright (C) 2015 Nameless Production Committee
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
 * @version 2014/03/27 10:52:07
 */
@SuppressWarnings("unused")
public class WideningPrimitiveConversionTest extends ScriptTester {

    @Test
    public void longToDouble() throws Exception {
        test(new Scriptable() {

            double act(long value) {
                return value / 2;
            }
        });
    }
}
