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

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;
import booton.translator.annotation.PrimitiveMarker;

/**
 * @version 2016/04/07 21:17:58
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
    public void getReturnType() throws Exception {
        Method method = Methods.class.getMethod("publicMethod");
        assert method.getReturnType() == String.class;

        method = ExtendedMethods.class.getMethod("publicMethod");
        assert method.getReturnType() == String.class;

        method = ExtendedMethods.class.getMethod("protectedMethod");
        assert method.getReturnType() == int.class;

        method = ExtendedMethods.class.getMethod("extendedMethod");
        assert method.getReturnType() == void.class;

        method = Methods.class.getDeclaredMethod("packageMethod");
        assert method.getReturnType() == Object.class;
    }

    @Test
    public void parameterCount() throws Exception {
        Method method = Methods.class.getMethod("publicMethod");
        assert method.getParameterCount() == 0;

        method = Methods.class.getDeclaredMethod("privateMethod", int.class);
        assert method.getParameterCount() == 1;
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

        /**
         * 
         */
        private native Object packageMethod();
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

    @Test
    public void getDefaultValue() throws Exception {
        Method method = Methods.class.getMethod("publicMethod");
        assert method.getDefaultValue() == null;

        method = Mark.class.getMethod("intValue");
        assert method.getDefaultValue().equals(10);

        method = Mark.class.getMethod("stringValue");
        assert method.getDefaultValue().equals("default");

        method = Mark.class.getMethod("noDefault");
        assert method.getDefaultValue() == null;
    }

    @Test
    public void getDefaultValuePrimitives() throws Exception {
        assert PrimitiveMarker.class.getMethod("intValue").getDefaultValue().equals(10);
        assert PrimitiveMarker.class.getMethod("longValue").getDefaultValue().equals(10L);
        assert PrimitiveMarker.class.getMethod("floatValue").getDefaultValue().equals(10F);
        assert PrimitiveMarker.class.getMethod("doubleValue").getDefaultValue().equals(10D);
        assert PrimitiveMarker.class.getMethod("byteValue").getDefaultValue().equals((byte) 10);
        assert PrimitiveMarker.class.getMethod("shortValue").getDefaultValue().equals((short) 10);
        assert PrimitiveMarker.class.getMethod("booleanValue").getDefaultValue().equals(true);
        assert PrimitiveMarker.class.getMethod("charValue").getDefaultValue().equals('c');
    }

    /**
     * @version 2013/09/07 16:57:54
     */
    @Retention(RetentionPolicy.RUNTIME)
    private static @interface Mark {

        int intValue() default 10;

        double noDefault();

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
     * @version 2013/09/24 11:42:05
     */
    @SuppressWarnings("unused")
    private static class VarArg<T> {

        public void primitive(int... values) {
        }

        public void string(int some, @Mark(noDefault = 10, intValue = 200) String... values) {
        }

        public void variable(T... values) {
        }
    }

    @Test
    public void isDefault() throws Exception {
        Method method = DefaultMethod.class.getDeclaredMethod("def");
        assert method.isDefault();

        method = DefaultMethod.class.getDeclaredMethod("not");
        assert !method.isDefault();
    }

    /**
     * @version 2013/11/07 18:49:22
     */
    private static interface DefaultMethod {

        void not();

        default void def() {
        }
    }
}
