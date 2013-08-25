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

import booton.translator.JavaAPIProvider;
import booton.translator.JavascriptAPIProvider;

/**
 * @version 2013/08/21 9:32:59
 */
@JavaAPIProvider(Object.class)
@JavascriptAPIProvider("Object")
class JSObject {

    /** The global counter for hash. */
    private static int counter = 0;

    /** The cached hash. */
    private int hash = 0;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void finalize() throws Throwable {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        if (hash == 0) {
            hash = ++counter;
        }
        return hash;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getClass().getName() + "#" + hashCode();
    }

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
    public Class<?> $getClass() {
        return ((NativeObject) (Object) this).getPropertyAs(NativeObject.class, "$").getPropertyAs(Class.class, "$");
    }
}
