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

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;
import java.util.RandomAccess;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/09/10 15:01:59
 */
@RunWith(ScriptRunner.class)
public class GenericMethodTest {

    @Test
    public void parameterVariable() throws Exception {
        Method method = SingleVariable.class.getDeclaredMethod("method", Object.class);
        assert method.getParameterTypes()[0] == Object.class;

        Type[] types = method.getGenericParameterTypes();
        assert types.length == 1;

        TypeVariable variable = (TypeVariable) types[0];
        assert variable.getGenericDeclaration() == SingleVariable.class;
        assert variable.getName().equals("T");
        assert variable.getBounds()[0] == Object.class;
    }

    @Test
    public void parameterVariables() throws Exception {
        Method method = MultipleVariables.class.getDeclaredMethod("method", Runnable.class, CharSequence.class, List.class);
        Class[] classes = method.getParameterTypes();
        assert classes[0] == Runnable.class;
        assert classes[1] == CharSequence.class;
        assert classes[2] == List.class;

        Type[] types = method.getGenericParameterTypes();
        TypeVariable first = (TypeVariable) types[0];
        assert first.getGenericDeclaration() == MultipleVariables.class;
        assert first.getName().equals("A");
        assert first.getBounds()[0] == Runnable.class;

        TypeVariable second = (TypeVariable) types[1];
        assert second.getGenericDeclaration() == MultipleVariables.class;
        assert second.getName().equals("B");
        assert second.getBounds()[0] == CharSequence.class;

        TypeVariable third = (TypeVariable) types[2];
        assert third.getGenericDeclaration() == MultipleVariables.class;
        assert third.getName().equals("C");
        assert third.getBounds()[1] == RandomAccess.class;

        ParameterizedType parameterized = (ParameterizedType) third.getBounds()[0];
        assert parameterized.getRawType() == List.class;
        assert parameterized.getOwnerType() == null;
        assert parameterized.getActualTypeArguments().length == 1;

        TypeVariable variable = (TypeVariable) parameterized.getActualTypeArguments()[0];
        assert variable == second;
    }

    @Test
    public void returnVariable() throws Exception {
        Method method = SingleVariable.class.getDeclaredMethod("method", Object.class);
        assert method.getReturnType() == Object.class;

        Type type = method.getGenericReturnType();
        assert type instanceof TypeVariable;

        TypeVariable variable = (TypeVariable) type;
        assert variable.getGenericDeclaration() == SingleVariable.class;
        assert variable.getName().equals("T");
        assert variable.getBounds()[0] == Object.class;
    }

    /**
     * @version 2013/09/10 15:02:50
     */
    private static abstract class SingleVariable<T> {

        abstract T method(T value);
    }

    /**
     * @version 2013/09/10 15:02:50
     */
    private static abstract class MultipleVariables<A extends Runnable, B extends CharSequence, C extends List<B> & RandomAccess> {

        abstract void method(A a, B b, C c);
    }

    @Test
    public void throwVariables() throws Exception {
        Method method = ThrowType.class.getDeclaredMethod("method");
        Class[] classes = method.getExceptionTypes();
        assert classes[0] == Error.class;
        assert classes[1] == Throwable.class;
        assert classes[2] == Exception.class;
        assert classes[3] == RuntimeException.class;

        Type[] types = method.getGenericExceptionTypes();
        TypeVariable first = (TypeVariable) types[0];
        assert first.getGenericDeclaration() == ThrowType.class;
        assert first.getName().equals("E");
        assert first.getBounds()[0] == Error.class;

        TypeVariable second = (TypeVariable) types[1];
        assert second.getGenericDeclaration() == ThrowType.class;
        assert second.getName().equals("T");
        assert second.getBounds()[0] == Throwable.class;

        TypeVariable third = (TypeVariable) types[2];
        assert third.getGenericDeclaration() == ThrowType.class;
        assert third.getName().equals("X");
        assert third.getBounds()[0] == Exception.class;

        TypeVariable forth = (TypeVariable) types[3];
        assert forth.getGenericDeclaration() == ThrowType.class;
        assert forth.getName().equals("R");
        assert forth.getBounds()[0] == RuntimeException.class;
    }

    /**
     * @version 2013/09/10 15:02:50
     */
    private static abstract class ThrowType<E extends Error, T extends Throwable, X extends Exception, R extends RuntimeException> {

        abstract void method() throws E, T, X, R;
    }

    @Test
    public void parameterArray() throws Exception {
        Method method = ArrayType.class.getDeclaredMethod("method", Object[].class);
        assert method.getParameterTypes()[0] == Object[].class;

        Type[] types = method.getGenericParameterTypes();
        assert types.length == 1;

        GenericArrayType array = (GenericArrayType) types[0];
        assert array.getGenericComponentType() instanceof TypeVariable;

        TypeVariable variable = (TypeVariable) array.getGenericComponentType();
        assert variable.getGenericDeclaration() == ArrayType.class;
        assert variable.getName().equals("T");
        assert variable.getBounds()[0] == Object.class;
    }

    /**
     * @version 2013/09/10 23:16:44
     */
    private static abstract class ArrayType<T> {

        abstract void method(T[] values);
    }

    @Test
    public void getTypeParameters() throws Exception {
        Method method = Declaration.class.getDeclaredMethod("method", Object.class);
        TypeVariable[] variables = method.getTypeParameters();
        assert variables.length == 1;

        TypeVariable variable = variables[0];
        assert variable.getName().equals("T");
        assert variable.getGenericDeclaration() == method;
        assert variable.getBounds()[0] == Object.class;
    }

    /**
     * @version 2013/09/11 8:29:24
     */
    private static abstract class Declaration {

        abstract <T> T method(T value);
    }
}
