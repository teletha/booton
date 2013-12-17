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

import booton.soeur.ScriptRunner;

/**
 * @version 2013/09/08 0:26:33
 */
@RunWith(ScriptRunner.class)
public class GenericClassTest {

    @Test
    public void parameter() throws Exception {
        TypeVariable[] types = SingleTypeVariable.class.getTypeParameters();
        assert types != null;
        assert types.length == 1;

        TypeVariable type = types[0];
        assert type instanceof Type;
        assert type instanceof TypeVariable;
        assert type.getGenericDeclaration() == SingleTypeVariable.class;
        assert type.getName().equals("T");
        assert type.getBounds().length == 1;
        assert type.getBounds()[0] == Object.class;

        types[0] = null;
        assert types[0] == null;
        assert SingleTypeVariable.class.getTypeParameters()[0] != null;

        // non single character
        types = ListParameterizedType.class.getTypeParameters();
        assert types != null;
        assert types.length == 1;

        type = types[0];
        assert type.getGenericDeclaration() == ListParameterizedType.class;
        assert type.getName().equals("Item");
        assert type.getBounds().length == 1;
        assert type.getBounds()[0] == Object.class;

    }

    @Test
    public void parameters() throws Exception {
        TypeVariable[] types = MapParameterizedType.class.getTypeParameters();
        assert types != null;
        assert types.length == 2;

        TypeVariable type = types[0];
        assert type.getGenericDeclaration() == MapParameterizedType.class;
        assert type.getName().equals("K");
        assert type.getBounds().length == 1;
        assert type.getBounds()[0] == Object.class;

        type = types[1];
        assert type.getGenericDeclaration() == MapParameterizedType.class;
        assert type.getName().equals("V");
        assert type.getBounds().length == 1;
        assert type.getBounds()[0] == Object.class;
    }

    @Test
    public void parameterWildcardList() throws Exception {
        TypeVariable[] types = WildcardListType.class.getTypeParameters();
        assert types != null;
        assert types.length == 1;

        TypeVariable type = types[0];
        assert type.getGenericDeclaration() == WildcardListType.class;
        assert type.getName().equals("T");
        assert type.getBounds().length == 1;
        assert type.getBounds()[0] == List.class;
    }

    @Test
    public void parameterWildcardStringList() throws Exception {
        TypeVariable[] types = WildcardStringListType.class.getTypeParameters();
        assert types != null;
        assert types.length == 1;

        TypeVariable type = types[0];
        assert type.getGenericDeclaration() == WildcardStringListType.class;
        assert type.getName().equals("T");
        assert type.getBounds().length == 1;

        Type bound = type.getBounds()[0];
        assert bound instanceof ParameterizedType;

        ParameterizedType parameterized = (ParameterizedType) bound;
        assert parameterized.getRawType() == List.class;
        assert parameterized.getActualTypeArguments().length == 1;
        assert parameterized.getActualTypeArguments()[0] == String.class;
        assert parameterized.getOwnerType() == null;
    }

    @Test
    public void parameterWildcardGenericList() throws Exception {
        TypeVariable[] types = WildcardGenericListType.class.getTypeParameters();
        assert types != null;
        assert types.length == 1;

        TypeVariable type = types[0];
        assert type.getGenericDeclaration() == WildcardGenericListType.class;
        assert type.getName().equals("T");
        assert type.getBounds().length == 1;

        Type bound = type.getBounds()[0];
        assert bound instanceof ParameterizedType;

        ParameterizedType parameterized = (ParameterizedType) bound;
        assert parameterized.getRawType() == List.class;
        assert parameterized.getOwnerType() == null;
        assert parameterized.getActualTypeArguments().length == 1;
        assert parameterized.getActualTypeArguments()[0].equals(type);
    }

    @Test
    public void parameterWildcardNestedGeneric() throws Exception {
        TypeVariable[] types = WildcardNestedType.class.getTypeParameters();
        assert types != null;
        assert types.length == 2;

        TypeVariable first = types[0];
        assert first.getGenericDeclaration() == WildcardNestedType.class;
        assert first.getName().equals("T");
        assert first.getBounds().length == 1;

        TypeVariable second = types[1];
        assert second.getGenericDeclaration() == WildcardNestedType.class;
        assert second.getName().equals("S");
        assert second.getBounds().length == 1;

        ParameterizedType firstParameter = (ParameterizedType) first.getBounds()[0];
        assert firstParameter.getRawType() == Map.class;
        assert firstParameter.getActualTypeArguments().length == 2;
        assert firstParameter.getActualTypeArguments()[0] == String.class;

        ParameterizedType firstNested = (ParameterizedType) firstParameter.getActualTypeArguments()[1];
        assert firstNested.getRawType() == Map.class;
        assert firstNested.getActualTypeArguments().length == 2;
        assert firstNested.getActualTypeArguments()[0] == first;
        assert firstNested.getActualTypeArguments()[1] == second;

        ParameterizedType secondParameter = (ParameterizedType) second.getBounds()[0];
        assert secondParameter.getRawType() == List.class;
        assert secondParameter.getActualTypeArguments().length == 1;
        assert secondParameter.getActualTypeArguments()[0].equals(first);
    }

    @Test
    public void parameterWildcards() throws Exception {
        TypeVariable[] types = MultipleWildcardType.class.getTypeParameters();
        assert types != null;
        assert types.length == 1;

        TypeVariable type = types[0];
        assert type.getGenericDeclaration() == MultipleWildcardType.class;
        assert type.getName().equals("T");
        assert type.getBounds().length == 2;
        assert type.getBounds()[0] == List.class;
        assert type.getBounds()[1] == RandomAccess.class;
    }

    @Test
    public void noParameters() throws Exception {
        TypeVariable[] types = ArrayListWildcardType.class.getTypeParameters();
        assert types != null;
        assert types.length == 0;
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

    @Test
    public void interfaces() throws Exception {
        Type[] types = MapType.class.getGenericInterfaces();
        assert types != null;
        assert types.length == 1;

        ParameterizedType type = (ParameterizedType) types[0];
        assert type.getRawType() == Map.class;
        assert type.getOwnerType() == null;

        Type[] params = type.getActualTypeArguments();
        assert params[0] == String.class;
        assert params[1] == Throwable.class;
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
     * @version 2013/09/08 22:44:13
     */
    private static abstract class MapType implements Map<String, Throwable> {
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
    private static class WildcardListType<T extends List> {
    }

    /**
     * @version 2013/09/02 2:15:41
     */
    private static class WildcardStringListType<T extends List<String>> {
    }

    /**
     * @version 2013/09/02 2:15:41
     */
    private static class WildcardGenericListType<T extends List<T>> {
    }

    /**
     * @version 2013/09/02 2:15:41
     */
    private static class WildcardNestedType<T extends Map<String, Map<T, S>>, S extends List<T>> {
    }

    /**
     * @version 2013/09/02 2:19:23
     */
    private static class LinkedListWildcardType extends WildcardListType<LinkedList> {
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
