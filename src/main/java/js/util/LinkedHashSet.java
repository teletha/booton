/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import js.lang.NativeObject;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/25 11:27:12
 */
@JavaAPIProvider(LinkedHashSet.class)
class LinkedHashSet<E> implements Set<E> {

    /** The item count. */
    private int size = 0;

    /** The item pool. */
    private NativeObject items = new NativeObject();

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Object o) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean hasNext() {
                return false;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public E next() {
                return null;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void remove() {
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(E e) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object o) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
    }
}
