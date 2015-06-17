/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.emulate.sun.reflect;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/06/27 16:51:53
 */
@JavaAPIProvider(sun.reflect.Reflection.class)
class Reflection {

    public Class getCallerClass() {
        // // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
