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
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

/**
 * @version 2013/08/04 9:26:13
 */
public class ScriptRunner extends BlockJUnit4ClassRunner {

    /** The test listener. */
    private Listener listener = new Listener();

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
    protected void runChild(FrameworkMethod method, RunNotifier notifier) {
        if (method instanceof JavascriptMethod) {
            notifier.removeListener(listener);

            // chech Java result
            if (listener.ignore) {
                listener.ignore = false;
                notifier.fireTestIgnored(describeChild(method));
                return;
            }
        } else {
            notifier.addListener(listener);
        }
        super.runChild(method, notifier);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> doubles = new ArrayList();

        for (FrameworkMethod method : super.computeTestMethods()) {
            doubles.add(method);
            doubles.add(new JavascriptMethod(method.getMethod()));
        }
        return doubles;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void filter(final Filter filter) throws NoTestsRemainException {
        super.filter(new Filter() {

            @Override
            public boolean shouldRun(Description description) {
                return filter.shouldRun(description) || filter.shouldRun(Description.createTestDescription(description.getTestClass(), description.getMethodName()
                        .replace("JS", "")));
            }

            @Override
            public String describe() {
                return "Accept JS";
            }
        });
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

    /**
     * @version 2013/08/08 13:12:06
     */
    private static class Listener extends RunListener {

        /** The state of previous processing test method for Java. */
        private boolean ignore = false;

        /**
         * {@inheritDoc}
         */
        @Override
        public void testFailure(Failure failure) throws Exception {
            ignore = true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void testAssumptionFailure(Failure failure) {
            ignore = true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void testIgnored(Description description) throws Exception {
            ignore = true;
        }
    }
}
