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

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/09/02 2:12:10
 */
@RunWith(ScriptRunner.class)
public class GenericClassTest {

    @Test
    public void getTypeParameters() throws Exception {
        TypeVariable[] types = SingleTypeVariable.class.getTypeParameters();
        assert types != null;
        assert types.length == 1;
        assert types[0].getGenericDeclaration() == SingleTypeVariable.class;
        assert types[0].getName().equals("T");
    }

    @Test
    public void genericSuperClass1() throws Exception {
        Type type = OtherParameterizedType.class.getGenericSuperclass();
        assert type != null;
        assert type instanceof ParameterizedType;

        ParameterizedType parameterized = (ParameterizedType) type;
        Type[] types = parameterized.getActualTypeArguments();
        assert types != null;
        assert types.length == 1;
        assert types[0] instanceof TypeVariable;

        TypeVariable variable = (TypeVariable) types[0];
        Type[] bounds = variable.getBounds();
        assert bounds != null;
        assert bounds.length == 1;
        assert bounds[0] == Object.class;
    }

    /**
     * @version 2013/09/02 2:13:16
     */
    private static class SingleTypeVariable<T> {
    }

    /**
     * @version 2013/09/02 2:13:16
     */
    private static class OtherParameterizedType<U> extends SingleTypeVariable<U> {
    }

    /**
     * @version 2013/09/02 2:13:16
     */
    private static class NestParameterizedType<V> extends OtherParameterizedType<V> {
    }

    /**
     * @version 2013/09/02 2:13:16
     */
    private static class StringParameterizedType extends SingleTypeVariable<String> {
    }

    /**
     * @version 2013/09/02 2:14:44
     */
    private static class ListParameterizedType<Item> extends SingleTypeVariable<List<Item>> {
    }

    /**
     * @version 2013/09/02 2:14:44
     */
    private static class MapParameterizedType<K, V> extends SingleTypeVariable<Map<K, V>> {
    }

    /**
     * @version 2013/09/02 2:15:41
     */
    private static class ExtendsWildcardType<T extends List> {
    }

    /**
     * @version 2013/09/02 2:19:23
     */
    private static class LinkedListWildcardType extends ExtendsWildcardType<LinkedList> {
    }

    /**
     * @version 2013/09/02 2:15:41
     */
    private static class MultipleWildcardType<T extends List & RandomAccess> {
    }

    /**
     * @version 2013/09/02 2:19:23
     */
    private static class ArrayListWildcardType extends MultipleWildcardType<ArrayList> {
    }

}
