/*
 * Copyright (C) 2012 Nameless Production Committee
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
import java.util.LinkedHashSet;
import java.util.Set;

import booton.translator.js.NativeArray;
import booton.translator.js.NativeMap;
import booton.translator.js.NativeSet;

/**
 * @version 2012/12/08 11:49:36
 */
public class HashSet<E> implements Set<E> {

    /** The native set. */
    private NativeMap<E, Integer> set = new NativeMap();

    /** The actual container. */
    private NativeArray values = new NativeArray();

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return set.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return set.size() == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Object o) {
        return set.has(o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return null;
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
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        } else {
            set.set(e, );
            values.push(e);
            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        } else {
            set.delete(o);
            values.remove(values.indexOf(o))
            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object item : collection) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean modified = false;

        for (E item : collection) {
            if (add(item)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean modified = false;

        for (Object item : this) {
            if (!collection.contains(item)) {
                modified = remove(item);
            }
        }
        return modified;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean modified = false;

        for (Object item : collection) {
            if (remove(item)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        set = new NativeSet();
    }
}
