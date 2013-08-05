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
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/08/05 9:41:44
 */
@JavaAPIProvider(java.util.AbstractList.class)
abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {

    /**
     * {@inheritDoc}
     */
    @Override
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
    @Override
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
    @Override
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
     */
    @Override
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }
}
