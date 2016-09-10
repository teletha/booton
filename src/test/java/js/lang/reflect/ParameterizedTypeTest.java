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

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2016/09/10 21:41:36
 */
@RunWith(ScriptRunner.class)
public class ParameterizedTypeTest {

    @Test
    public void argumentsAreCopySafe() throws Exception {
        Type parent = Base.class.getGenericSuperclass();
        assert parent instanceof ParameterizedType;

        ParameterizedType type = (ParameterizedType) parent;
        Type[] arguments = type.getActualTypeArguments();
        assert arguments.length == 1;
        Type arg = arguments[0];
        assert arg instanceof TypeVariable;
        TypeVariable variable = (TypeVariable) arg;
        assert variable.getName().equals("X");

        // destroy arguments
        arguments[0] = null;

        // re-take
        arguments = type.getActualTypeArguments();
        assert arguments.length == 1; // original aruguments are saved
    }

    /**
     * @version 2016/09/10 21:43:26
     */
    private static class Base<X> extends SingleTypeVariable<X> {
    }

    /**
     * @version 2013/09/02 2:13:16
     */
    private static class SingleTypeVariable<T> {
    }
}
