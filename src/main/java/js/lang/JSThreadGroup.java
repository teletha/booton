/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.lang.Thread.UncaughtExceptionHandler;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/01/28 23:00:34
 */
@JavaAPIProvider(ThreadGroup.class)
class JSThreadGroup implements UncaughtExceptionHandler {

    /** The parent group. */
    private ThreadGroup parent;

    /**
     * Returns the parent of this thread group.
     * <p>
     * First, if the parent is not <code>null</code>, the <code>checkAccess</code> method of the
     * parent thread group is called with no arguments; this may result in a security exception.
     *
     * @return the parent of this thread group. The top-level thread group is the only thread group
     *         whose parent is <code>null</code>.
     * @exception SecurityException if the current thread cannot modify this thread group.
     * @see java.lang.ThreadGroup#checkAccess()
     * @see java.lang.SecurityException
     * @see java.lang.RuntimePermission
     * @since JDK1.0
     */
    public final ThreadGroup getParent() {
        return parent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void uncaughtException(Thread thread, Throwable error) {
        Thread.UncaughtExceptionHandler handler = Thread.getDefaultUncaughtExceptionHandler();

        if (handler != null) {
            handler.uncaughtException(thread, error);
        } else {
            error.printStackTrace(System.err);
        }
    }
}
