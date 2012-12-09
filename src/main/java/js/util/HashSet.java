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
public class HashSet<E> implements Set<E> {

    /** The item count. */
    private int size = 0;

    /** The native key set. */
    private NativeObject values = new NativeObject();

    /** The actual value container. */
    private NativeArray items = new NativeArray();

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
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Object o) {
        return values.hasProperty(hash(o));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return items.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        return items.toArray();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) items.toArray();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(E e) {
        int hash = hash(e);

        if (values.hasProperty(hash)) {
            return false;
        } else {
            values.setProperty(hash, e);
            items.push(e);

            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object o) {
        int hash = hash(o);

        if (!values.hasProperty(hash)) {
            return false;
        } else {
            values.deleteProperty(hash);

            keys.deleteProperty(hash);
            values.remove(index);
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
