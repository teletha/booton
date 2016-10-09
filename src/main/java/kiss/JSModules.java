/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package kiss;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/03/07 20:21:02
 */
@JavaAPIProvider(Modules.class)
class JSModules extends ClassVariable<Lifestyle> implements Decoder<Class>, Encoder<Class> {

    /** The module list. */
    final List<Object> modules = new CopyOnWriteArrayList();

    /**
     * The two length class array for class load listener. (0 : ClassLoadListener class, 1 : Target
     * class to listen)
     */
    final List<Object[]> types = new CopyOnWriteArrayList();

    /**
     * <p>
     * Find a service provider class associated with the service provider interface.
     * </p>
     * 
     * @param <S> A type of service provider interface.
     * @param spi A service provider interface to find. An abstract class is only accepted.
     * @return A finded service provider class.
     */
    <S> Class<S> find(Class<S> spi) {
        throw new Error();
    }

    /**
     * <p>
     * Load the path as an additional classpath into JVM. If the file indicates the classpath which
     * is already loaded, that will be reloaded. The classpath can accept directory or archive (like
     * Jar). If it is <code>null</code> or a file, this method does nothing.
     * </p>
     * 
     * @param path A module path to load. Directory or archive path (like Jar) can be accepted.
     */
    ClassLoader load(Path path, String pattern) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class decode(String value) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String encode(Class value) {
        return null;
    }
}
