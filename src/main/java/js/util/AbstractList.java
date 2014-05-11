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
     * The number of times this list has been <i>structurally modified</i>. Structural modifications
     * are those that change the size of the list, or otherwise perturb it in such a fashion that
     * iterations in progress may yield incorrect results.
     * <p>
     * This field is used by the iterator and list iterator implementation returned by the
     * {@code iterator} and {@code listIterator} methods. If the value of this field changes
     * unexpectedly, the iterator (or list iterator) will throw a
     * {@code ConcurrentModificationException} in response to the {@code next}, {@code remove},
     * {@code previous}, {@code set} or {@code add} operations. This provides <i>fail-fast</i>
     * behavior, rather than non-deterministic behavior in the face of concurrent modification
     * during iteration.
     * <p>
     * <b>Use of this field by subclasses is optional.</b> If a subclass wishes to provide fail-fast
     * iterators (and list iterators), then it merely has to increment this field in its
     * {@code add(int, E)} and {@code remove(int)} methods (and any other methods that it overrides
     * that result in structural modifications to the list). A single call to {@code add(int, E)} or
     * {@code remove(int)} must add no more than one to this field, or the iterators (and list
     * iterators) will throw bogus {@code ConcurrentModificationExceptions}. If an implementation
     * does not wish to provide fail-fast iterators, this field may be ignored.
     */
    protected transient int modCount = 0;

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
