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

    /** Accessed only via accessor. */
    private volatile transient Object[] array;

    /**
     * Create an empty list.
     */
    public CopyOnWriteArrayList() {
        setArray(new Object[0]);
    }

    /**
     * <p>
     * Create with collection items.
     * </p>
     * 
     * @param collection
     */
    public CopyOnWriteArrayList(Collection<? extends E> collection) {
        setArray(collection.toArray());
    }

    /**
     * Creates a list holding a copy of the given array.
     * 
     * @param items the array (a copy of this array is used as the internal array)
     * @throws NullPointerException if the specified array is null
     */
    public CopyOnWriteArrayList(E[] items) {
        setArray(Arrays.copyOf(items, items.length, Object[].class));
    }

    /**
     * <p>
     * Getter for actual items.
     * </p>
     */
    protected final Object[] getArray() {
        return array;
    }

    /**
     * <p>
     * Setter for actual items.
     * </p>
     */
    protected final void setArray(Object[] array) {
        this.array = array;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return array.length;
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
    public boolean contains(Object item) {
        Object[] items = this.array;
        return indexOf(item, items, 0, items.length) >= 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new View(this.array, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, array.length);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T[] toArray(T[] destination) {
        Object[] items = this.array;
        int length = items.length;

        if (destination.length < length) {
            return (T[]) Arrays.copyOf(items, length, destination.getClass());
        } else {
            System.arraycopy(items, 0, destination, 0, length);

            if (destination.length > length) {
                destination[length] = null;
            }
            return destination;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(E item) {
        Object[] items = array;
        int length = items.length;

        Object[] copy = Arrays.copyOf(items, length + 1);
        copy[length] = item;
        array = copy;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object item) {
        Object[] items = this.array;
        int length = items.length;

        if (length != 0) {
            int newLength = length - 1;
            Object[] newItems = new Object[newLength];

            for (int i = 0; i < newLength; i++) {
                if (equal(item, items[i])) {
                    // found the specified item, copy remaining and exit
                    for (int k = i + 1; k < length; ++k) {
                        newItems[k - 1] = items[k];
                    }
                    array = newItems;
                    return true;
                } else {
                    newItems[i] = items[i];
                }
            }

            // special handling for last cell
            if (equal(item, items[newLength])) {
                array = newItems;
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsAll(Collection<?> collection) {
        Object[] items = this.array;
        int length = items.length;

        for (Object item : collection) {
            if (indexOf(item, items, 0, length) < 0) {
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
        Object[] additions = collection.toArray();

        if (additions.length == 0) {
            return false;
        }

        Object[] items = this.array;
        int length = items.length;
        Object[] newItems = Arrays.copyOf(items, length + additions.length);
        System.arraycopy(additions, 0, newItems, length, additions.length);
        this.array = newItems;
        return true;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        Object[] additions = collection.toArray();

        Object[] items = this.array;
        int length = items.length;

        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
        }

        if (additions.length == 0) {
            return false;
        }

        int numMoved = length - index;
        Object[] newItems;

        if (numMoved == 0) {
            newItems = Arrays.copyOf(items, length + additions.length);
        } else {
            newItems = new Object[length + additions.length];
            System.arraycopy(items, 0, newItems, 0, index);
            System.arraycopy(items, index, newItems, index + additions.length, numMoved);
        }
        System.arraycopy(additions, 0, newItems, index, additions.length);
        this.array = newItems;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeAll(Collection<?> collection) {
        Object[] items = this.array;
        int length = items.length;

        if (length != 0) {
            int newLength = 0;
            Object[] temporary = new Object[length];

            for (int i = 0; i < length; ++i) {
                Object item = items[i];

                if (!collection.contains(item)) {
                    temporary[newLength++] = item;
                }
            }

            if (newLength != length) {
                this.array = Arrays.copyOf(temporary, newLength);
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        Object[] items = this.array;
        int length = items.length;

        if (length != 0) {
            int newLength = 0;
            Object[] temporary = new Object[length];

            for (int i = 0; i < length; ++i) {
                Object item = items[i];

                if (c.contains(item)) temporary[newLength++] = item;
            }

            if (newLength != length) {
                this.array = Arrays.copyOf(temporary, newLength);
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        this.array = new Object[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E get(int index) {
        return (E) array[index];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E set(int index, E element) {
        Object[] items = this.array;
        E old = (E) items[index];

        if (old != element) {
            int length = items.length;
            Object[] newItems = Arrays.copyOf(items, length);
            newItems[index] = element;
            this.array = newItems;
        }
        return old;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(int index, E item) {
        Object[] items = this.array;
        int length = items.length;

        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
        }

        Object[] newItems;
        int numMoved = length - index;

        if (numMoved == 0)
            newItems = Arrays.copyOf(items, length + 1);
        else {
            newItems = new Object[length + 1];
            System.arraycopy(items, 0, newItems, 0, index);
            System.arraycopy(items, index, newItems, index + 1, numMoved);
        }
        newItems[index] = item;
        this.array = newItems;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E remove(int index) {
        Object[] items = this.array;
        int length = items.length;
        E old = (E) items[index];
        int numMoved = length - index - 1;

        if (numMoved == 0) {
            setArray(Arrays.copyOf(items, length - 1));
        } else {
            Object[] newItems = new Object[length - 1];
            System.arraycopy(items, 0, newItems, 0, index);
            System.arraycopy(items, index + 1, newItems, index, numMoved);
            this.array = newItems;
        }
        return old;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int indexOf(Object item) {
        return indexOf(item, this.array, 0, this.array.length);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int lastIndexOf(Object item) {
        return lastIndexOf(item, this.array, this.array.length - 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListIterator<E> listIterator() {
        return new View(this.array, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        Object[] items = this.array;
        int length = items.length;

        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return new View(items, index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Helper method to search item.
     * </p>
     * 
     * @param item The item to search for.
     * @param items The current item set.
     * @param index The first index to search.
     * @param fence The one past last index to search.
     * @return A index of element, or -1 if absent.
     */
    private static int indexOf(Object item, Object[] items, int index, int fence) {
        for (int i = index; i < fence; i++) {
            if (equal(items[i], item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * <p>
     * Helper method to search item.
     * </p>
     * 
     * @param item The item to search for.
     * @param items The current item set.
     * @param index The first index to search.
     * @return A index of element, or -1 if absent.
     */
    private static int lastIndexOf(Object item, Object[] items, int index) {
        for (int i = index; i >= 0; i--) {
            if (equal(items[i], item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * <p>
     * Helper method to test for equality, coping with nulls.
     * </p>
     * 
     * @param item1
     * @param item2
     * @return
     */
    private static boolean equal(Object item1, Object item2) {
        if (item1 == null) {
            return item2 == null;
        } else {
            return item1.equals(item2);
        }
    }

    /**
     * @version 2013/06/28 4:09:48
     */
    private static class View<E> implements ListIterator<E> {

        /** Snapshot of items. */
        private final Object[] snapshot;

        /** The index of element to be returned by subsequent call to next. */
        private int cursor;

        /**
         * @param items
         * @param cursor
         */
        private View(Object[] items, int cursor) {
            this.snapshot = items;
            this.cursor = cursor;
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
            return 0 < cursor;
        }

        /**
         * {@inheritDoc}
         */
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) snapshot[cursor++];
        }

        /**
         * {@inheritDoc}
         */
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
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
