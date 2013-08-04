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
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import booton.translator.JavaAPIProvider;

/**
 * @version 2012/12/09 23:04:18
 */
@JavaAPIProvider(java.util.AbstractList.class)
abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {

    /**
     * {@inheritDoc}
     */
    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    public int indexOf(Object object) {
        ListIterator<E> iterator = listIterator();

        while (iterator.hasNext()) {
            if (Objects.equals(iterator.next(), object)) {
                return iterator.previousIndex();
            }
        }
        return -1;
    }

    /**
     * {@inheritDoc}
     */
    public int lastIndexOf(Object object) {
        ListIterator<E> iterator = listIterator(size());

        while (iterator.hasPrevious()) {
            if (Objects.equals(iterator.next(), object)) {
                return iterator.nextIndex();
            }
        }
        return -1;
    }

    /**
     * {@inheritDoc}
     */
    public boolean addAll(int index, Collection<? extends E> collection) {
        boolean modified = false;

        for (E item : collection) {
            add(index++, item);
            modified = true;
        }
        return modified;
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation returns {@code listIterator(0)}.
     * 
     * @see #listIterator(int)
     */
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }
}
