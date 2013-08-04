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

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

import booton.translator.JavaAPIProvider;

/**
 * @version 2012/12/08 22:08:28
 */
@JavaAPIProvider(java.util.AbstractCollection.class)
abstract class AbstractCollection<E> implements Collection<E> {

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
    public Object[] toArray() {
        return toArray(new Object[] {});
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T[] toArray(T[] array) {
        int size = size();

        if (array.length < size) {
            array = (T[]) Array.newInstance(array.getClass(), size);
        }

        Iterator<E> iterator = iterator();

        for (int i = 0; iterator.hasNext(); i++) {
            E item = iterator.next();

            array[i] = (T) item;
        }
        return array;
    }

    /**
     * {@inheritDoc}
     */
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    public boolean remove(Object object) {
        Iterator<E> iterator = iterator();

        while (iterator.hasNext()) {
            if (Objects.equals(iterator.next(), object)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        Iterator<E> iterator = iterator();

        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }
}
