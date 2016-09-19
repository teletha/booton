/*
 * Copyright (C) 2016 Nameless Production Committee
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

/**
 * @version 2015/01/21 14:59:25
 */
@RunWith(ScriptRunner.class)
public class MethodParameterWithSuperFieldAssignTest {

    private static int superStaticValue;

    private int superValue;

    @Test
    public void staticValue() {
        Accessor accessor = new Accessor();
        assert accessor.computeStatic(10) == 110;
    }

    @Test
    public void normalValue() {
        Accessor accessor = new Accessor();
        assert accessor.computeNormal(10) == 110;
    }

    @Test
    public void innerStaticField() {
        InnerAccessor accessor = new InnerAccessor();
        assert accessor.computeStatic(10) + InnerAccessor.staticValue == 110;
    }

    /**
     * @version 2015/01/21 15:00:28
     */
    private class Accessor {

        private int computeStatic(int value) {
            return computeActually(superStaticValue = value) + superStaticValue;
        }

        private int computeNormal(int value) {
            return computeActually(superValue = value) + superValue;
        }

        private int computeActually(int value) {
            return value * 10;
        }

    }

    /**
     * @version 2015/02/06 10:01:28
     */
    private static class InnerAccessor {

        private static int staticValue;

        private int computeStatic(int value) {
            return computeActually(staticValue = value);
        }

        private static int computeActually(int value) {
            return value * 10;
        }
    }
}
