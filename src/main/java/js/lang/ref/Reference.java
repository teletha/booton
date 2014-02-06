/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.ref;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/02/06 9:34:27
 */
@JavaAPIProvider(java.lang.ref.Reference.class)
class Reference<T> {

    private T reference;

    /**
     * Returns this reference object's referent. If this reference object has been cleared, either
     * by the program or by the garbage collector, then this method returns <code>null</code>.
     *
     * @return The object to which this reference refers, or <code>null</code> if this reference
     *         object has been cleared
     */
    public T get() {
        return reference;
    }
}
