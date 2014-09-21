/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.versionable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.UnaryOperator;

/**
 * @version 2014/09/21 12:36:39
 */
public class VList<T> extends ArrayList<T> implements Versionable {

    /** The version of this instance. */
    private Version version = new Version(0);

    /**
     * {@inheritDoc}
     */
    @Override
    public Version version() {
        return version;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T set(int index, T element) {
        version = version.next();
        return super.set(index, element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(T e) {
        version = version.next();
        return super.add(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(int index, T element) {
        version = version.next();
        super.add(index, element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(int index) {
        version = version.next();
        return super.remove(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object o) {
        version = version.next();
        return super.remove(o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        version = version.next();
        super.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        version = version.next();
        return super.addAll(c);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        version = version.next();
        return super.addAll(index, c);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        version = version.next();
        super.removeRange(fromIndex, toIndex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        version = version.next();
        return super.removeAll(c);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        version = version.next();
        return super.retainAll(c);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        version = version.next();
        super.replaceAll(operator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sort(Comparator<? super T> c) {
        version = version.next();
        super.sort(c);
    }

}
