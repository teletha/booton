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

import java.lang.ref.Reference;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/02/06 9:34:49
 */
@JavaAPIProvider(java.lang.ref.ReferenceQueue.class)
class ReferenceQueue<T> {

    /**
     * Polls this queue to see if a reference object is available. If one is available without
     * further delay then it is removed from the queue and returned. Otherwise this method
     * immediately returns <tt>null</tt>.
     *
     * @return A reference object, if one was immediately available, otherwise <code>null</code>
     */
    public Reference<? extends T> poll() {
        return null;
    }
}
