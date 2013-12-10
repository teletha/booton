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

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/08/05 9:43:18
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
    @Override
    public String toString() {
        Stream<String> map = stream().map(item -> String.valueOf(item));
        return map.collect(Collectors.joining(", ", "[", "]"));
    }
}
