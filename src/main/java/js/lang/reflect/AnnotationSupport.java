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

import java.lang.annotation.Annotation;
import java.util.Map;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/11/17 14:08:22
 */
@JavaAPIProvider(sun.reflect.annotation.AnnotationSupport.class)
class AnnotationSupport {

    public static Annotation[] getDirectlyAndIndirectlyPresent(Map map, Class type) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
