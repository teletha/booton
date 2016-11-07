/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.invoke;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2016/11/07 12:35:34
 */
@RunWith(ScriptRunner.class)
public class SpecialCallTest {

    @Test
    public void speciallCall() throws Throwable {
        Implementation implementation = new Implementation();

        // reflection
        Method method = API.class.getMethod("name");
        assert method.invoke(implementation).equals("Implementation");

        // invoke dynamic
        Object object = MethodHandles.lookup()
                .in(API.class)
                .unreflectSpecial(method, API.class)
                .bindTo(implementation)
                .invokeWithArguments();
        assert object.equals("Interface");
    }

    /**
     * @version 2016/11/07 12:36:09
     */
    private interface API {

        default String name() {
            return "Interface";
        }
    }

    /**
     * @version 2016/11/07 12:37:01
     */
    private static class Implementation implements API {

        /**
         * {@inheritDoc}
         */
        @Override
        public String name() {
            return "Implementation";
        }
    }
}
