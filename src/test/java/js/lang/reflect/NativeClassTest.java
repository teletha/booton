/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect;

import js.lang.NativeArray;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2015/01/11 15:00:09
 */
@RunWith(ScriptRunner.class)
public class NativeClassTest {

    @Test
    public void loadNativeArray() throws Exception {
        Class clazz = Class.forName("js.lang.NativeArray");
        assert clazz == NativeArray.class;
    }
}
