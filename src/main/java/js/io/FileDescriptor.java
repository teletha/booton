/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.io;

import java.io.Closeable;
import java.io.IOException;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/04/25 10:02:25
 */
@JavaAPIProvider(java.io.FileDescriptor.class)
class FileDescriptor {

    /**
     * A handle to the standard input stream. Usually, this file descriptor is not used directly,
     * but rather via the input stream known as {@code System.in}.
     *
     * @see java.lang.System#in
     */
    public static final java.io.FileDescriptor in = null;

    /**
     * A handle to the standard output stream. Usually, this file descriptor is not used directly,
     * but rather via the output stream known as {@code System.out}.
     * 
     * @see java.lang.System#out
     */
    public static final java.io.FileDescriptor out = null;

    /**
     * A handle to the standard error stream. Usually, this file descriptor is not used directly,
     * but rather via the output stream known as {@code System.err}.
     *
     * @see java.lang.System#err
     */
    public static final java.io.FileDescriptor err = null;

    /**
     * Attach a Closeable to this FD for tracking. parent reference is added to otherParents when
     * needed to make closeAll simpler.
     */
    synchronized void attach(Closeable c) {
        // do nothing
    }

    /**
     * Cycle through all Closeables sharing this FD and call close() on each one. The caller
     * closeable gets to call close0().
     */
    synchronized void closeAll(Closeable releaser) throws IOException {
        // do nothing
    }
}
