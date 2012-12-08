/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.js;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import booton.translator.Substitutable;

/**
 * <p>
 * ArrayList implementation for Javascript.
 * </p>
 * 
 * @version 2012/12/07 9:25:50
 */
public class JsList<T> implements List<T>, Substitutable<ArrayList> {

    /** The actual container. */
    private final NativeArray<T> array = new NativeArray();

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return array.length();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return array.length() == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Object o) {
        return array.indexOf(o) != -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return array.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public native Object[] toArray();

    /**
     * {@inheritDoc}
     */
    @Override
    public native <T> T[] toArray(T[] a);

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(T e) {
        array.push(e);

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object o) {
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
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
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
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(int index) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T set(int index, T element) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(int index, T element) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(int index) {
        checkRange(index);

        return (T) array.remove(index, 1).get(0);
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
    public ListIterator<T> listIterator() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    /**
     * <p>
     * Helper method to check index range,
     * </p>
     * 
     * @param index
     */
    private void checkRange(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index is unacceptable. Size: " + size() + "  Index: " + index);
        }

        if (size() <= index) {
            throw new IndexOutOfBoundsException("Index is overflowed. Size: " + size() + "  Index: " + index);
        }
    }
}
