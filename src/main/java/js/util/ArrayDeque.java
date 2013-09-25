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

import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import js.lang.NativeArray;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/25 17:14:37
 */
@JavaAPIProvider(java.util.ArrayDeque.class)
class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E> {

    /** The actual item holder. */
    private NativeArray<E> items = new NativeArray();

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        items = new NativeArray();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addFirst(E e) {
        Objects.requireNonNull(e);

        items.unshift(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addLast(E e) {
        Objects.requireNonNull(e);

        items.push(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return pollFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return pollLast();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E pollFirst() {
        return items.shift();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E pollLast() {
        return items.pop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return peekFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return peekLast();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E peekFirst() {
        return items.get(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E peekLast() {
        return items.get(items.length() - 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeFirstOccurrence(Object o) {
        if (o == null) {
            return false;
        }

        Iterator<E> iterator = iterator();

        while (iterator.hasNext()) {
            if (o.equals(iterator.next())) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeLastOccurrence(Object o) {
        if (o == null) {
            return false;
        }

        Iterator<E> iterator = descendingIterator();

        while (iterator.hasNext()) {
            if (o.equals(iterator.next())) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(E e) {
        return offerLast(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean offer(E e) {
        return offerLast(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E remove() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E poll() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E element() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E peek() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(E e) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E pop() {
        return null;
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
    public boolean contains(Object o) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }
}
