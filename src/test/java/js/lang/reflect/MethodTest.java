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

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;
import booton.translator.annotation.StringMarker;

/**
 * @version 2013/09/10 23:57:01
 */
@RunWith(ScriptRunner.class)
public class MethodTest {

    @Test
    public void getDeclaringClass() throws Exception {
        Method method = Methods.class.getMethod("publicMethod");
        assert method.getDeclaringClass() == Methods.class;

        method = ExtendedMethods.class.getMethod("publicMethod");
        assert method.getDeclaringClass() == Methods.class;

        method = ExtendedMethods.class.getMethod("protectedMethod");
        assert method.getDeclaringClass() == ExtendedMethods.class;

        method = ExtendedMethods.class.getMethod("extendedMethod");
        assert method.getDeclaringClass() == ExtendedMethods.class;
    }

    @Test
    public void getDefaultValue() throws Exception {
        Method method = Methods.class.getMethod("publicMethod");
        assert method.getDefaultValue() == null;

        method = Mark.class.getMethod("intValue");
        assert method.getDefaultValue().equals(10);

        method = Mark.class.getMethod("stringValue");
        assert method.getDefaultValue().equals("default");

        method = Mark.class.getMethod("doubleValue");
        assert method.getDefaultValue() == null;
    }

    @Test
    public void getReturnType() throws Exception {
        Method method = Methods.class.getMethod("publicMethod");
        assert method.getReturnType() == String.class;

        method = ExtendedMethods.class.getMethod("publicMethod");
        assert method.getReturnType() == String.class;

        method = ExtendedMethods.class.getMethod("protectedMethod");
        assert method.getReturnType() == int.class;

        method = ExtendedMethods.class.getMethod("extendedMethod");
        assert method.getReturnType() == void.class;
    }

    /**
     * @version 2013/09/03 15:04:55
     */
    private static class Methods {

        /**
         * 
         */
        public native String publicMethod();

        /**
         * 
         */
        private native Number privateMethod(int value);
    }

    /**
     * @version 2013/09/03 15:14:17
     */
    private static class ExtendedMethods extends Methods {

        /**
         * 
         */
        public native void extendedMethod();

        /**
         */
        public native int protectedMethod();
    }

    /**
     * @version 2013/09/07 16:57:54
     */
    private static @interface Mark {

        int intValue() default 10;

        double doubleValue();

        String stringValue() default "default";
    }

    @Test
    public void variableArgument() throws Exception {
        Method method = VarArg.class.getDeclaredMethod("primitive", int[].class);
        assert method.isVarArgs();
        assert method.getParameterTypes()[0] == int[].class;

        method = VarArg.class.getDeclaredMethod("string", int.class, String[].class);
        assert method.isVarArgs();
        assert method.getParameterTypes()[1] == String[].class;

        method = VarArg.class.getDeclaredMethod("variable", Object[].class);
        assert method.isVarArgs();
        assert method.getParameterTypes()[0] == Object[].class;

        GenericArrayType array = (GenericArrayType) method.getGenericParameterTypes()[0];
        assert array.getGenericComponentType().equals(VarArg.class.getTypeParameters()[0]);
    }

    /**
     * @version 2013/09/11 0:23:15
     */
    private static class VarArg<T> {

        public native void primitive(int... values);

        public native void string(int some, @StringMarker("aaa") String... values);

        public native void variable(T... values);
    }
}
