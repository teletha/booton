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

import java.lang.reflect.Method;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
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
    protected void runChild(FrameworkMethod method, RunNotifier notifier) {
        // execute as Java
        super.runChild(method, notifier);

        // execute as Javascript
        Description description = describeChild(method);
        notifier.fireTestStarted(description);

        try {
            Method test = method.getMethod();

            ScriptTester tester = new ScriptTester();
            tester.execute(test.getDeclaringClass(), test);
        } catch (Throwable e) {
            notifier.fireTestFailure(new Failure(describeChild(method), e));
        } finally {
            notifier.fireTestFinished(description);
        }

    }
}
