/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/12/31 17:07:39
 */
@JavaAPIProvider(java.util.concurrent.locks.ReentrantReadWriteLock.class)
class ReentrantReadWriteLock implements ReadWriteLock {

    /**
     * {@inheritDoc}
     */
    @Override
    public Lock readLock() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lock writeLock() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
