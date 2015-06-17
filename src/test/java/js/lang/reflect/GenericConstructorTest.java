/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;
import java.util.RandomAccess;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/09/10 16:33:12
 */
@RunWith(ScriptRunner.class)
public class GenericConstructorTest {

    @Test
    public void parameterVariable() throws Exception {
        Constructor constructor = SingleVariable.class.getDeclaredConstructor(Object.class);
        Class[] parameters = constructor.getParameterTypes();
        assert parameters.length == 1;
        assert parameters[0] == Object.class;

        Type[] types = constructor.getGenericParameterTypes();
        assert types.length == 1;

        TypeVariable type = (TypeVariable) types[0];
        assert type.getName().equals("T");
        assert type.getGenericDeclaration() == SingleVariable.class;
        assert type.getBounds().length == 1;
        assert type.getBounds()[0] == Object.class;
    }

    @Test
    public void parameterVariables() throws Exception {
        Constructor constructor = MultipleVariables.class.getDeclaredConstructor(Runnable.class, CharSequence.class, List.class);
        Class[] classes = constructor.getParameterTypes();
        assert classes[0] == Runnable.class;
        assert classes[1] == CharSequence.class;
        assert classes[2] == List.class;

        Type[] types = constructor.getGenericParameterTypes();
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
    public void throwVariables() throws Exception {
        Constructor constructor = ThrowType.class.getDeclaredConstructor();
        Class[] classes = constructor.getExceptionTypes();
        assert classes[0] == Error.class;
        assert classes[1] == Throwable.class;
        assert classes[2] == Exception.class;
        assert classes[3] == RuntimeException.class;

        Type[] types = constructor.getGenericExceptionTypes();
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
     * @version 2013/09/10 16:33:47
     */
    @SuppressWarnings("unused")
    private static class SingleVariable<T> {

        /**
         * 
         */

        SingleVariable(T value) {
        }
    }

    /**
     * @version 2013/09/10 15:02:50
     */
    @SuppressWarnings("unused")
    private static class MultipleVariables<A extends Runnable, B extends CharSequence, C extends List<B> & RandomAccess> {

        MultipleVariables(A a, B b, C c) {
        }
    }

    /**
     * @version 2013/09/10 15:02:50
     */
    @SuppressWarnings("unused")
    private static class ThrowType<E extends Error, T extends Throwable, X extends Exception, R extends RuntimeException> {

        /**
         * 
         */
        public ThrowType() throws E, T, X, R {
        }
    }
}
