/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.invoke;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/24 23:04:31
 */
@JavaAPIProvider(MethodHandles.class)
class JSMethodHandles {

    /**
     * Returns a {@link Lookup lookup object} on the caller, which has the capability to access any
     * method handle that the caller has access to, including direct method handles to private
     * fields and methods. This lookup object is a <em>capability</em> which may be delegated to
     * trusted agents. Do not store it in place where untrusted code can access it.
     */
    public static Lookup lookup() {
        return (Lookup) (Object) new JSLookup();
    }
}
