/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import booton.translator.JavaAPIProvider;

/**
 * <p>
 * {@link Void} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/04/12 12:58:25
 */
@JavaAPIProvider(Void.class)
class JSVoid {

    /** The primitive void class. */
    public static final Class TYPE = Primitive.class;

    /**
     * 
     */
    private JSVoid() {
    }

    /**
     * @version 2013/04/16 23:01:24
     */
    @JavaAPIProvider(void.class)
    private static class Primitive {
    }
}
