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
import java.util.Set;

import booton.translator.js.NativeArray;
import booton.translator.js.NativeObject;

/**
 * @version 2012/12/08 11:49:36
 */
public class HashSet2<E> implements Set<E> {

    /** The native key set. */
    private NativeObject keys = new NativeObject();

    /** The actual value container. */
    private NativeArray values = new NativeArray();

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return values.length();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Object o) {
        return keys.hasProperty(hash(o));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return values.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        return values.toArray();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) values.toArray();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        } else {
            keys.setProperty(hash(e), (Integer) values.push(e));

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
            int hash = hash(o);
            int index = (int) keys.getProperty(hash);

            keys.deleteProperty(hash);
            values.remove(index, 1);
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
        keys = new NativeObject();
        values = new NativeArray();
    }

    /**
     * <p>
     * Compute hash.
     * </p>
     * 
     * @param key
     * @return
     */
    private int hash(Object key) {
        return key == null ? -1 : key.hashCode();
    }
}
