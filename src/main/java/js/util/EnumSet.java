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

import java.util.Iterator;

/**
 * @version 2013/02/20 13:45:51
 */
public class EnumSet<E extends Enum<E>> extends AbstractSet<E> {

    /**
     * Hide constructor.
     */
    private EnumSet() {
    }

    /**
     * <p>
     * Creates an empty enum set with the specified element type.
     * </p>
     * 
     * @param elementType A class object of the element type for this enum set.
     * @return
     */
    public static <E extends Enum<E>> EnumSet<E> nonOf(Class<E> elementType) {
        return new EnumSet();
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
    public boolean contains(Object o) {
        return false;
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
    public boolean add(E e) {
        return false;
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
    public void clear() {
    }
}
