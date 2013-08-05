/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.internal.runners.model.ReflectiveCallable;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

/**
 * @version 2013/08/04 9:26:13
 */
public class ScriptRunner extends BlockJUnit4ClassRunner {

    /**
     * @param klass
     * @throws InitializationError
     */
    public ScriptRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> doubles = new ArrayList();
        List<FrameworkMethod> methods = super.computeTestMethods();

        for (FrameworkMethod method : methods) {
            doubles.add(method);
            doubles.add(new JavascriptMethod(method.getMethod()));
        }
        return doubles;
    }

    /**
     * @version 2013/08/05 14:34:15
     */
    private static class JavascriptMethod extends FrameworkMethod {

        /** The test method. */
        private Method method;

        /**
         * @param method
         */
        private JavascriptMethod(Method method) {
            super(method);

            this.method = method;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getName() {
            return super.getName() + "JS";
        }

        /**
         * Returns the result of invoking this method on {@code target} with parameters
         * {@code params}. {@link InvocationTargetException}s thrown are unwrapped, and their causes
         * rethrown.
         */
        public Object invokeExplosively(final Object target, final Object... params) throws Throwable {
            return new ReflectiveCallable() {

                @Override
                protected Object runReflectiveCall() throws Throwable {
                    ScriptTester tester = new ScriptTester();
                    return tester.executeAsJavascript(method);
                }
            }.run();
        }
    }
}
