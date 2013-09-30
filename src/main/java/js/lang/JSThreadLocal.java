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

/**
 * @version 2013/09/24 23:26:18
 */
@JavaAPIProvider(ThreadLocal.class)
class JSThreadLocal<T> {

    /** The value store. */
    private T value;

    /**
     * Returns the value in the current thread's copy of this thread-local variable. If the variable
     * has no value for the current thread, it is first initialized to the value returned by an
     * invocation of the {@link #initialValue} method.
     * 
     * @return the current thread's value of this thread-local
     */
    public T get() {
        return value;
    }

    /**
     * Sets the current thread's copy of this thread-local variable to the specified value. Most
     * subclasses will have no need to override this method, relying solely on the
     * {@link #initialValue} method to set the values of thread-locals.
     * 
     * @param value the value to be stored in the current thread's copy of this thread-local.
     */
    public void set(T value) {
        this.value = value;
    }
}
