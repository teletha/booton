/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/06/26 11:22:27
 */
@JavaAPIProvider(java.util.concurrent.ThreadLocalRandom.class)
class ThreadLocalRandom {

    /** The singleton. */
    private static final ThreadLocalRandom instance = new ThreadLocalRandom();

    /**
     * Returns the current thread's {@code ThreadLocalRandom}.
     *
     * @return the current thread's {@code ThreadLocalRandom}
     */
    public static ThreadLocalRandom current() {
        return instance;
    }
}
