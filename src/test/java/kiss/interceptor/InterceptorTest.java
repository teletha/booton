/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package kiss.interceptor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.Necessary;
import booton.soeur.ScriptRunner;
import kiss.I;
import kiss.Interceptor;

/**
 * @version 2013/10/12 0:00:21
 */
@RunWith(ScriptRunner.class)
public class InterceptorTest {

    static {
        I.load(InterceptorTest.class, true);
    }

    @Test
    public void interceptor() throws Exception {
        InterceptedClass intercepted = I.make(InterceptedClass.class);
        assert intercepted.call("Yuigahama").equals("Hello Yuigahama!");
        assert intercepted.say("Yuigahama").equals("Goodby Yuigahama!");
    }

    /**
     * @version 2013/09/25 22:04:54
     */

    protected static class InterceptedClass {

        @Hello
        public String call(String name) {
            return name;
        }

        @Goodby
        public String say(String name) {
            return name;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return getClass().getName();
        }
    }

    /**
     * @version 2013/09/25 22:07:26
     */
    @Retention(RetentionPolicy.RUNTIME)
    private static @interface Hello {
    }

    /**
     * @version 2013/09/25 22:08:49
     */
    @Necessary
    protected static class HelloInterceptor extends Interceptor<Hello> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected Object invoke(Object... params) {
            return super.invoke("Hello " + params[0] + "!");
        }
    }

    /**
     * @version 2013/09/25 22:07:26
     */
    @Retention(RetentionPolicy.RUNTIME)
    private static @interface Goodby {
    }

    /**
     * @version 2013/09/25 22:08:49
     */
    @Necessary
    protected static class GoodbyInterceptor extends Interceptor<Goodby> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected Object invoke(Object... params) {
            return super.invoke("Goodby " + params[0] + "!");
        }
    }
}
