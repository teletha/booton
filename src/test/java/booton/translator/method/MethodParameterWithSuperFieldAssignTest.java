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
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;
import booton.translator.Debuggable;

/**
 * @version 2015/01/21 14:59:25
 */
@RunWith(ScriptRunner.class)
public class MethodParameterWithSuperFieldAssignTest {

    private static int superValue;

    @Test
    public void assign() {
        Accessor accessor = new Accessor();
        assert accessor.compute(10) == 100;
    }

    /**
     * @version 2015/01/21 15:00:28
     */
    private static class Accessor {

        @Debuggable
        private int compute(int value) {
            return computeActually(superValue = value);
        }

        private static int computeActually(int value) {
            return value * 10;
        }
    }
}
