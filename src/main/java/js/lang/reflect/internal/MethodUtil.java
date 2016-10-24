/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect.internal;

import java.lang.reflect.Method;

import booton.translator.JavaAPIProvider;
import kiss.I;

/**
 * @version 2014/02/07 9:18:34
 */
@JavaAPIProvider(sun.reflect.misc.MethodUtil.class)
class MethodUtil {

    public Object invoke(Method method, Object instance, Object[] params) {
        try {
            return method.invoke(instance, params);
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }
}
