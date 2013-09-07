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

import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/09/07 16:50:21
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

    /**
     * @version 2013/09/03 15:04:55
     */
    private static class Methods {

        /**
         * 
         */
        public native void publicMethod();

        /**
         * 
         */
        private native void privateMethod(int value);
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
        public native void protectedMethod();
    }

    /**
     * @version 2013/09/07 16:57:54
     */
    private static @interface Mark {

        int intValue() default 10;

        double doubleValue();

        String stringValue() default "default";
    }
}
