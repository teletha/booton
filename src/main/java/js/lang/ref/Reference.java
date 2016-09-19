/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.ref;

import java.lang.ref.ReferenceQueue;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/02/26 14:23:09
 */
@JavaAPIProvider(java.lang.ref.Reference.class)
class Reference<T> {

    private T referent;

    /**
     * <p>
     * Hide constructor.
     * </p>
     * 
     * @param referent
     */
    Reference(T referent) {
        this(referent, null);
    }

    /**
     * <p>
     * Hide constructor.
     * </p>
     * 
     * @param referent
     * @param queue
     */
    Reference(T referent, ReferenceQueue<? super T> queue) {
        this.referent = referent;
    }

    /**
     * Returns this reference object's referent. If this reference object has been cleared, either
     * by the program or by the garbage collector, then this method returns <code>null</code>.
     *
     * @return The object to which this reference refers, or <code>null</code> if this reference
     *         object has been cleared
     */
    public T get() {
        return referent;
    }
}
