/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.AbstractCollection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import booton.translator.JavaAPIProvider;
import js.lang.NativeArray;

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

        int index = items.indexOf(o);

        if (index == -1) {
            return false;
        } else {
            items.remove(index);

            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeLastOccurrence(Object o) {
        if (o == null) {
            return false;
        }

        int index = items.lastIndexOf(o);

        if (index == -1) {
            return false;
        } else {
            items.remove(index);

            return true;
        }
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
        return removeFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E poll() {
        return pollFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E element() {
        return getFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E peek() {
        return peekFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(E e) {
        addFirst(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E pop() {
        return removeFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object o) {
        return removeFirstOccurrence(o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Object o) {
        return items.indexOf(o) != -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return items.length();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new Sequence(-1, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> descendingIterator() {
        return new Sequence(size(), -1);
    }

    /**
     * @version 2013/09/25 18:38:17
     */
    private class Sequence implements Iterator<E> {

        /** The current index. */
        private int current;

        /** The diff for move. */
        private int diff;

        /** The remove flag. */
        private boolean removed = false;

        /**
         * @param current
         * @param diff
         */
        private Sequence(int current, int diff) {
            this.current = current;
            this.diff = diff;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            int next = current + diff;

            return 0 <= next && next < items.length();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E next() {
            removed = false;
            return items.get(current += diff);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void remove() {
            if (removed) {
                throw new IllegalStateException();
            } else {
                items.remove(current);
                removed = true;
            }
        }
    }
}
