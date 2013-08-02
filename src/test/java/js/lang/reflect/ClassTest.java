/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect;

import java.lang.reflect.Modifier;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/08/02 22:51:26
 */
@SuppressWarnings("unused")
public class ClassTest extends ScriptTester {

    @Test
    public void getName() throws Exception {
        test(new Scriptable() {

            int act() {
                int modifier = Private.class.getModifiers();
                assert Modifier.isPrivate(modifier);

                return Private.class.getModifiers();
            }
        });
    }

    /**
     * @version 2013/08/03 0:25:14
     */
    private static class Private {
    }
}
