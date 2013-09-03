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
import java.lang.reflect.Modifier;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/09/01 23:29:05
 */
@RunWith(ScriptRunner.class)
public class ClassTest {

    @Test
    public void modifierPrivate() throws Exception {
        int modifier = Private.class.getModifiers();
        assert Modifier.isPrivate(modifier);
    }

    @Test
    public void modifierPackage() throws Exception {
        int modifier = Package.class.getModifiers();
        assert !Modifier.isPrivate(modifier);
        assert !Modifier.isProtected(modifier);
        assert !Modifier.isPublic(modifier);
    }

    @Test
    public void modifierProtected() throws Exception {
        int modifier = Protected.class.getModifiers();
        assert Modifier.isProtected(modifier);
    }

    @Test
    public void modifierPublic() throws Exception {
        int modifier = Public.class.getModifiers();
        assert Modifier.isPublic(modifier);
    }

    /**
     * @version 2013/08/03 0:25:14
     */
    private static class Private {
    }

    /**
     * @version 2013/08/03 0:25:14
     */
    static class Package {
    }

    /**
     * @version 2013/08/03 0:25:14
     */
    protected static class Protected {
    }

    /**
     * @version 2013/08/03 0:25:14
     */
    public static class Public {
    }

    @Test
    public void getSuperclass() throws Exception {
        assert Child.class.getSuperclass() == Parent.class;
        assert Parent.class.getSuperclass() == Object.class;
        assert Object.class.getSuperclass() == null;
    }

    /**
     * @version 2013/08/03 2:49:26
     */
    private static class Parent {
    }

    /**
     * @version 2013/08/03 2:49:45
     */
    private static class Child extends Parent {
    }

    @Test
    public void getMethods() throws Exception {
        Method[] methods = Methods.class.getMethods();
        assert methods != null;
        assert methods.length == 10;

        methods = ExtendedMethods.class.getMethods();
        assert methods != null;
        assert methods.length == 12;

        // check defensive copy
        methods[0] = methods[1];
        assert methods[0] == methods[1];

        methods = ExtendedMethods.class.getMethods();
        assert methods[0] != methods[1];

    }

    @Test
    public void getDeclaredMethods() throws Exception {
        Method[] methods = Methods.class.getDeclaredMethods();
        assert methods != null;
        assert methods.length == 4;
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
        protected native void protectedMethod();

        /**
         * 
         */
        native void packageMethod();

        /**
         * 
         */
        private native void privateMethod();
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
         * {@inheritDoc}
         */
        @Override
        public void publicMethod() {
            super.publicMethod();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void protectedMethod() {
            super.protectedMethod();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        void packageMethod() {
            super.packageMethod();
        }
    }
}
