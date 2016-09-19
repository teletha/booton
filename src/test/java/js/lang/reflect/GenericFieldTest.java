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

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/09/10 23:59:01
 */
@RunWith(ScriptRunner.class)
public class GenericFieldTest {

    @Test
    public void type() throws Exception {
        Field field = Variable.class.getDeclaredField("value");
        assert field.getType() == Object.class;

        TypeVariable variable = (TypeVariable) field.getGenericType();
        assert variable.getGenericDeclaration() == Variable.class;
        assert variable.getName().equals("T");
        assert variable.getBounds()[0] == Object.class;
    }

    /**
     * @version 2013/09/11 0:00:25
     */
    @SuppressWarnings("unused")
    private static class Variable<T> {

        T value;
    }

    @Test
    public void extend() throws Exception {
        Field field = Extend.class.getDeclaredField("value");
        assert field.getType() == List.class;

        TypeVariable variable = (TypeVariable) field.getGenericType();
        assert variable.getGenericDeclaration() == Extend.class;
        assert variable.getName().equals("T");

        ParameterizedType parameterized = (ParameterizedType) variable.getBounds()[0];
        assert parameterized.getRawType() == List.class;
        assert parameterized.getOwnerType() == null;
        assert parameterized.getActualTypeArguments()[0] == variable;
    }

    /**
     * @version 2013/09/11 0:00:25
     */
    @SuppressWarnings("unused")
    private static class Extend<T extends List<T>> {

        T value;
    }
}
