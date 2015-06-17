/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.security;

import java.security.AccessControlContext;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

import kiss.I;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/10/26 10:58:00
 */
@JavaAPIProvider(java.security.AccessController.class)
class AccessController {

    /**
     * Performs the specified {@code PrivilegedAction} with privileges enabled. The action is
     * performed with <i>all</i> of the permissions possessed by the caller's protection domain.
     * <p>
     * If the action's {@code run} method throws an (unchecked) exception, it will propagate through
     * this method.
     * <p>
     * Note that any DomainCombiner associated with the current AccessControlContext will be ignored
     * while the action is performed.
     * 
     * @param <T> the type of the value returned by the PrivilegedAction's {@code run} method.
     * @param action the action to be performed.
     * @return the value returned by the action's {@code run} method.
     * @exception NullPointerException if the action is {@code null}
     * @see #doPrivileged(PrivilegedAction,AccessControlContext)
     * @see #doPrivileged(PrivilegedExceptionAction)
     * @see #doPrivilegedWithCombiner(PrivilegedAction)
     * @see java.security.DomainCombiner
     */
    public static <T> T doPrivileged(PrivilegedAction<T> action) {
        return action.run();
    }

    /**
     * Performs the specified {@code PrivilegedExceptionAction} with privileges enabled. The action
     * is performed with <i>all</i> of the permissions possessed by the caller's protection domain.
     * <p>
     * If the action's {@code run} method throws an <i>unchecked</i> exception, it will propagate
     * through this method.
     * <p>
     * Note that any DomainCombiner associated with the current AccessControlContext will be ignored
     * while the action is performed.
     * 
     * @param <T> the type of the value returned by the PrivilegedExceptionAction's {@code run}
     *            method.
     * @param action the action to be performed
     * @return the value returned by the action's {@code run} method
     * @exception PrivilegedActionException if the specified action's {@code run} method threw a
     *                <i>checked</i> exception
     * @exception NullPointerException if the action is {@code null}
     * @see #doPrivileged(PrivilegedAction)
     * @see #doPrivileged(PrivilegedExceptionAction,AccessControlContext)
     * @see #doPrivilegedWithCombiner(PrivilegedExceptionAction)
     * @see java.security.DomainCombiner
     */
    public static <T> T doPrivileged(PrivilegedExceptionAction<T> action) throws PrivilegedActionException {
        try {
            return action.run();
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }
}
