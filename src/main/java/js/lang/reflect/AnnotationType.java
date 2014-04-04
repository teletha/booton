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

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/11/17 14:18:05
 */
@JavaAPIProvider(sun.reflect.annotation.AnnotationType.class)
class AnnotationType {

    public static sun.reflect.annotation.AnnotationType getInstance(Class type) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    public boolean isInherited() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
