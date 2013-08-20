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

import js.lang.NativeObject;
import booton.translator.JavascriptAPIProvider;

/**
 * @version 2013/08/20 15:59:22
 */
@JavascriptAPIProvider("Array")
class NativeArrayExtension {

    public Class $getClass() {
        Object object = ((NativeObject) (Object) this).getProperty("$");

        if (object instanceof Class) {
            return (Class) object;
        } else {
            try {
                Class clazz = Class.forName(object.toString());

                ((NativeObject) (Object) this).setProperty("$", clazz);

                return clazz;
            } catch (ClassNotFoundException e) {
                // If this exception will be thrown, it is bug of this program. So we must rethrow
                // the wrapped error in here.
                throw new Error(e);
            }
        }
    }
}
