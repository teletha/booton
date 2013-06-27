/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/06/28 3:59:10
 */
@JavaAPIProvider(java.util.concurrent.CopyOnWriteArrayList.class)
public class CopyOnWriteArrayList<E> implements List<E> {

    /** The array, accessed only via getArray/setArray. */
    private volatile transient Object[] array;

    /**
     * Creates an empty list.
     */
    public CopyOnWriteArrayList() {
        setArray(new Object[0]);
    }

    /**
     * Gets the array. Non-private so as to also be accessible from CopyOnWriteArraySet class.
     */
    final Object[] getArray() {
        return array;
    }

    /**
     * Sets the array.
     */
    final void setArray(Object[] array) {
        this.array = array;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return getArray().length;
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
        Object[] elements = getArray();
        return indexOf(o, elements, 0, elements.length) >= 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new View<E>(getArray(), 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        Object[] elements = getArray();
        return Arrays.copyOf(elements, elements.length);
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
        Object[] elements = getArray();
        int len = elements.length;
        Object[] newElements = Arrays.copyOf(elements, len + 1);
        newElements[len] = e;
        setArray(newElements);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object o) {
        Object[] elements = getArray();
        int len = elements.length;
        if (len != 0) {
            // Copy while searching for element to remove
            // This wins in the normal case of element being present
            int newlen = len - 1;
            Object[] newElements = new Object[newlen];

            for (int i = 0; i < newlen; ++i) {
                if (eq(o, elements[i])) {
                    // found one; copy remaining and exit
                    for (int k = i + 1; k < len; ++k) {
                        newElements[k - 1] = elements[k];
                    }
                    setArray(newElements);
                    return true;
                } else
                    newElements[i] = elements[i];
            }

            // special handling for last cell
            if (eq(o, elements[newlen])) {
                setArray(newElements);
                return true;
            }
        }
        return false;
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
    public boolean addAll(int index, Collection<? extends E> c) {
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
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        setArray(new Object[0]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E get(int index) {
        return (E) getArray()[index];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E set(int index, E element) {
        Object[] elements = getArray();
        E oldValue = (E) elements[index];

        if (oldValue != element) {
            int len = elements.length;
            Object[] newElements = Arrays.copyOf(elements, len);
            newElements[index] = element;
            setArray(newElements);
        } else {
            // Not quite a no-op; ensures volatile write semantics
            setArray(elements);
        }
        return oldValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(int index, E element) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E remove(int index) {
        Object[] elements = getArray();
        int len = elements.length;
        E oldValue = (E) elements[index];
        int numMoved = len - index - 1;
        if (numMoved == 0) {
            setArray(Arrays.copyOf(elements, len - 1));
        } else {
            Object[] newElements = new Object[len - 1];
            System.arraycopy(elements, 0, newElements, 0, index);
            System.arraycopy(elements, index + 1, newElements, index, numMoved);
            setArray(newElements);
        }
        return oldValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int indexOf(Object o) {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    /**
     * static version of indexOf, to allow repeated calls without needing to re-acquire array each
     * time.
     * 
     * @param o element to search for
     * @param elements the array
     * @param index first index to search
     * @param fence one past last index to search
     * @return index of element, or -1 if absent
     */
    private static int indexOf(Object o, Object[] elements, int index, int fence) {
        if (o == null) {
            for (int i = index; i < fence; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = index; i < fence; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Test for equality, coping with nulls.
     */
    private static boolean eq(Object o1, Object o2) {
        if (o1 == null) {
            return o2 == null;
        } else {
            return o1.equals(o2);
        }
    }

    /**
     * @version 2013/06/28 4:09:48
     */
    private static class View<E> implements ListIterator<E> {

        /** Snapshot of the array */
        private final Object[] snapshot;

        /** Index of element to be returned by subsequent call to next. */
        private int cursor;

        /**
         * @param elements
         * @param initialCursor
         */
        private View(Object[] elements, int initialCursor) {
            cursor = initialCursor;
            snapshot = elements;
        }

        /**
         * {@inheritDoc}
         */
        public boolean hasNext() {
            return cursor < snapshot.length;
        }

        /**
         * {@inheritDoc}
         */
        public boolean hasPrevious() {
            return cursor > 0;
        }

        /**
         * {@inheritDoc}
         */
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            return (E) snapshot[cursor++];
        }

        /**
         * {@inheritDoc}
         */
        public E previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            return (E) snapshot[--cursor];
        }

        /**
         * {@inheritDoc}
         */
        public int nextIndex() {
            return cursor;
        }

        /**
         * {@inheritDoc}
         */
        public int previousIndex() {
            return cursor - 1;
        }

        /**
         * {@inheritDoc}
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        /**
         * {@inheritDoc}
         */
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }
}
