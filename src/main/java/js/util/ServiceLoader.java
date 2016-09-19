/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Iterator;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/04/25 11:20:53
 */
@JavaAPIProvider(java.util.ServiceLoader.class)
class ServiceLoader<S> implements Iterable<S> {

    /** The target service. */
    private final Class service;

    /**
     * @param service
     */
    private ServiceLoader(Class service) {
        this.service = service;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<S> iterator() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Creates a new service loader for the given service type, using the current thread's
     * {@linkplain java.lang.Thread#getContextClassLoader context class loader}.
     * <p>
     * An invocation of this convenience method of the form <blockquote>
     * 
     * <pre>
     * ServiceLoader.load(<i>service</i>)</pre>
     * </blockquote> is equivalent to <blockquote>
     * 
     * <pre>
     * ServiceLoader.load(<i>service</i>,
     *                    Thread.currentThread().getContextClassLoader())</pre>
     * </blockquote>
     *
     * @param <S> the class of the service type
     * @param service The interface or abstract class representing the service
     * @return A new service loader
     */
    public static <S> java.util.ServiceLoader<S> load(Class<S> service) {
        return load(service, null);
    }

    /**
     * Creates a new service loader for the given service type and class loader.
     *
     * @param <S> the class of the service type
     * @param service The interface or abstract class representing the service
     * @param loader The class loader to be used to load provider-configuration files and provider
     *            classes, or <tt>null</tt> if the system class loader (or, failing that, the
     *            bootstrap class loader) is to be used
     * @return A new service loader
     */
    public static <S> java.util.ServiceLoader<S> load(Class<S> service, ClassLoader loader) {
        return (java.util.ServiceLoader) (Object) new ServiceLoader(service);
    }
}
