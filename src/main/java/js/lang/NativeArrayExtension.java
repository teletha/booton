/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import booton.translator.JavascriptAPIProvider;
import booton.translator.Require;

/**
 * @version 2013/08/20 15:59:22
 */
@Require
@JavascriptAPIProvider("Array")
class NativeArrayExtension {

    /** The cached type. */
    private Class type;

    /**
     * Returns the runtime class of this {@code Object}. The returned {@code Class} object is the
     * object that is locked by {@code static synchronized} methods of the represented class.
     * <p>
     * <b>The actual result type is {@code Class<? extends |X|>} where {@code |X|} is the erasure of
     * the static type of the expression on which {@code getClass} is called.</b> For example, no
     * cast is required in this code fragment:
     * </p>
     * <p>
     * {@code Number n = 0;                             }<br>
     * {@code Class<? extends Number> c = n.getClass(); }
     * </p>
     * 
     * @return The {@code Class} object that represents the runtime class of this object.
     * @see Class Literals, section 15.8.2 of <cite>The Java&trade; Language Specification</cite>.
     */
    public Class $alias$getClass() throws ClassNotFoundException {
        if (type == null) {
            type = Class.forName(NativeObject.by(this).getPropertyAs(String.class, "$"));
        }
        return type;
    }
}
