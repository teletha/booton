/*
 * Copyright (C) 2015 Nameless Production Committee
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
 * @version 2013/06/28 21:20:39
 */
@JavaAPIProvider(java.util.concurrent.CopyOnWriteArrayList.class)
class CopyOnWriteArrayList<E> implements List<E> {

    /** The actual items. */
    private volatile transient Object[] items;

    /**
     * Create an empty list.
     */
    public CopyOnWriteArrayList() {
        this.items = new Object[0];
    }

    /**
     * <p>
     * Create with collection items.
     * </p>
     * 
     * @param collection
     */
    public CopyOnWriteArrayList(Collection<? extends E> collection) {
        this.items = collection.toArray();
    }

    /**
     * Creates a list holding a copy of the given array.
     * 
     * @param items the array (a copy of this array is used as the internal array)
     * @throws NullPointerException if the specified array is null
     */
    public CopyOnWriteArrayList(E[] items) {
        this.items = Arrays.copyOf(items, items.length, Object[].class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return items.length;
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
        return indexOf(item, this.items, 0, this.items.length) >= 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new View(this.items, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, items.length);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T[] toArray(T[] destination) {
        Object[] items = this.items;
        int length = items.length;

        if (destination.length < length) {
            return (T[]) Arrays.copyOf(items, length, (Class) destination.getClass());
        } else {
            System.arraycopy(items, 0, destination, 0, length);

            if (length < destination.length) {
                destination[length] = null;
            }
            return destination;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsAll(Collection<?> collection) {
        Object[] items = this.items;
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

        Object[] items = this.items;
        int length = items.length;
        Object[] newItems = Arrays.copyOf(items, length + additions.length);
        System.arraycopy(additions, 0, newItems, length, additions.length);
        this.items = newItems;

        return true;
    }

    /**
     * <p>
     * Appends all of the elements in the specified collection that are not already contained in
     * this list, to the end of this list, in the order that they are returned by the specified
     * collection's iterator.
     * </p>
     * 
     * @param collection collection containing elements to be added to this list
     * @return the number of elements added
     * @throws NullPointerException if the specified collection is null
     * @see #addIfAbsent(Object)
     */
    public int addAllAbsent(Collection<? extends E> collection) {
        Object[] collectionItems = collection.toArray();

        if (collectionItems.length == 0) {
            return 0;
        }

        Object[] unique = new Object[collectionItems.length];
        Object[] items = this.items;
        int length = items.length;
        int added = 0;

        // search duplications
        for (int i = 0; i < collectionItems.length; ++i) {
            Object item = collectionItems[i];

            if (indexOf(item, items, 0, length) < 0 && indexOf(item, unique, 0, added) < 0) {
                unique[added++] = item;
            }
        }

        if (0 < added) {
            Object[] newItems = Arrays.copyOf(items, length + added);
            System.arraycopy(unique, 0, newItems, length, added);
            this.items = newItems;
        }
        return added;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        Object[] additions = collection.toArray();

        Object[] items = this.items;
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
        this.items = newItems;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeAll(Collection<?> collection) {
        Object[] items = this.items;
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
                this.items = Arrays.copyOf(temporary, newLength);
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
        Object[] items = this.items;
        int length = items.length;

        if (length != 0) {
            int newLength = 0;
            Object[] temporary = new Object[length];

            for (int i = 0; i < length; ++i) {
                Object item = items[i];

                if (c.contains(item)) temporary[newLength++] = item;
            }

            if (newLength != length) {
                this.items = Arrays.copyOf(temporary, newLength);
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
        this.items = new Object[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E get(int index) {
        return (E) items[index];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E set(int index, E element) {
        Object[] items = this.items;
        E old = (E) items[index];

        if (old != element) {
            Object[] newItems = Arrays.copyOf(items, items.length);
            newItems[index] = element;
            this.items = newItems;
        }
        return old;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(E item) {
        add(items.length, item);

        // API definition
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(int index, E item) {
        Object[] items = this.items;
        int length = items.length;

        if (index < 0 || length < index) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
        }

        Object[] newItems = new Object[length + 1];
        System.arraycopy(items, 0, newItems, 0, index);
        System.arraycopy(items, index, newItems, index + 1, length - index);
        newItems[index] = item;

        this.items = newItems;
    }

    /**
     * <p>
     * Append the element if not present.
     * </p>
     * 
     * @param item element to be added to this list, if absent
     * @return <tt>true</tt> if the element was added
     */
    public boolean addIfAbsent(E item) {
        return indexOf(item) != -1 ? false : add(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E remove(int index) {
        Object[] items = this.items;
        E old = (E) items[index];
        int newLength = items.length - 1;

        Object[] newItems = new Object[newLength];
        System.arraycopy(items, 0, newItems, 0, index);
        System.arraycopy(items, index + 1, newItems, index, newLength - index);
        this.items = newItems;

        return old;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object item) {
        int index = indexOf(item);

        if (index == -1) {
            return false;
        } else {
            remove(index);
            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int indexOf(Object item) {
        return indexOf(item, this.items, 0, this.items.length);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int lastIndexOf(Object item) {
        return lastIndexOf(item, this.items, this.items.length - 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListIterator<E> listIterator() {
        return new View(this.items, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        Object[] items = this.items;
        int length = items.length;

        if (index < 0 || length < index) {
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
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return Arrays.toString(toArray());
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
