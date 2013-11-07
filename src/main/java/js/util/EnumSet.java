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

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/02/20 13:45:51
 */
@JavaAPIProvider(java.util.EnumSet.class)
class EnumSet<E extends Enum<E>> extends AbstractSet<E> {

    /** The target enum. */
    private final Class<E> type;

    /** The size. */
    private int size = 0;

    /** The items. */
    private boolean[] items;

    /**
     * Hide constructor.
     */
    private EnumSet(Class<E> type) {
        this.type = type;
        this.items = new boolean[type.getEnumConstants().length];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Object o) {
        if (o instanceof Enum) {
            return items[((Enum) o).ordinal()];
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return Arrays.asList(type.getEnumConstants()).iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(E e) {
        int index = e.ordinal();

        if (items[index]) {
            return false;
        }
        size++;
        items[index] = true;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object o) {
        if (o instanceof Enum) {
            int index = ((Enum) o).ordinal();

            if (!items[index]) {
                return false;
            }
            size--;
            items[index] = false;
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        size = 0;
        Arrays.fill(items, false);
    }

    /**
     * Creates an empty enum set with the specified element type.
     * 
     * @param <E> The class of the elements in the set
     * @param elementType the class object of the element type for this enum set
     * @return An empty enum set of the specified type.
     * @throws NullPointerException if <tt>elementType</tt> is null
     */
    public static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType) {
        return new EnumSet(elementType);
    }

    /**
     * Creates an enum set containing all of the elements in the specified element type.
     * 
     * @param <E> The class of the elements in the set
     * @param elementType the class object of the element type for this enum set
     * @return An enum set containing all the elements in the specified type.
     * @throws NullPointerException if <tt>elementType</tt> is null
     */
    public static <E extends Enum<E>> EnumSet<E> allOf(Class<E> elementType) {
        EnumSet<E> set = new EnumSet(elementType);
        set.size = set.items.length;
        Arrays.fill(set.items, true);

        return set;
    }
}
