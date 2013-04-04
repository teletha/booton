/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import js.bind.Publisher;
import js.util.ArrayList;

/**
 * @version 2013/04/04 22:03:41
 */
public class SelectableModel<M> extends Publisher implements List<M> {

    /** The selectable model items. */
    private final List<M> models = new ArrayList();

    /**
     * {@inheritDoc}
     */
    public int size() {
        return models.size();
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        return models.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(Object o) {
        return models.contains(o);
    }

    /**
     * {@inheritDoc}
     */
    public Iterator<M> iterator() {
        return models.iterator();
    }

    /**
     * {@inheritDoc}
     */
    public Object[] toArray() {
        return models.toArray();
    }

    /**
     * {@inheritDoc}
     */
    public <T> T[] toArray(T[] a) {
        return models.toArray(a);
    }

    /**
     * {@inheritDoc}
     */
    public boolean add(M e) {
        boolean result = models.add(e);

        publish();

        return result;
    }

    /**
     * {@inheritDoc}
     */
    public boolean remove(Object o) {
        return models.remove(o);
    }

    /**
     * {@inheritDoc}
     */
    public boolean containsAll(Collection<?> c) {
        return models.containsAll(c);
    }

    /**
     * {@inheritDoc}
     */
    public boolean addAll(Collection<? extends M> c) {
        return models.addAll(c);
    }

    /**
     * {@inheritDoc}
     */
    public boolean addAll(int index, Collection<? extends M> c) {
        return models.addAll(index, c);
    }

    /**
     * {@inheritDoc}
     */
    public boolean removeAll(Collection<?> c) {
        return models.removeAll(c);
    }

    /**
     * {@inheritDoc}
     */
    public boolean retainAll(Collection<?> c) {
        return models.retainAll(c);
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        models.clear();
    }

    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o) {
        return models.equals(o);
    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return models.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    public M get(int index) {
        return models.get(index);
    }

    /**
     * {@inheritDoc}
     */
    public M set(int index, M element) {
        return models.set(index, element);
    }

    /**
     * {@inheritDoc}
     */
    public void add(int index, M element) {
        models.add(index, element);
    }

    /**
     * {@inheritDoc}
     */
    public M remove(int index) {
        return models.remove(index);
    }

    /**
     * {@inheritDoc}
     */
    public int indexOf(Object o) {
        return models.indexOf(o);
    }

    /**
     * {@inheritDoc}
     */
    public int lastIndexOf(Object o) {
        return models.lastIndexOf(o);
    }

    /**
     * {@inheritDoc}
     */
    public ListIterator<M> listIterator() {
        return models.listIterator();
    }

    /**
     * {@inheritDoc}
     */
    public ListIterator<M> listIterator(int index) {
        return models.listIterator(index);
    }

    /**
     * {@inheritDoc}
     */
    public List<M> subList(int fromIndex, int toIndex) {
        return models.subList(fromIndex, toIndex);
    }
}
