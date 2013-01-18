/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Iterator;

import booton.translator.js.NativeObject;

/**
 * @version 2012/12/08 11:49:36
 */
public class HashSet<E> extends AbstractSet<E> {

    /** The item count. */
    private int size = 0;

    /** The item pool. */
    private NativeObject items = new NativeObject();

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
    public boolean contains(Object item) {
        return items.hasProperty(hash(item));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(E item) {
        int hash = hash(item);

        if (items.hasProperty(hash)) {
            return false;
        } else {
            size++;
            items.setProperty(hash, item);
            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object item) {
        int hash = hash(item);

        if (!items.hasProperty(hash)) {
            return false;
        } else {
            size--;
            items.deleteProperty(hash);
            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        size = 0;
        items = new NativeObject();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new View(items.keys());
    }

    /**
     * <p>
     * Compute hash.
     * </p>
     * 
     * @param key
     * @return
     */
    private int hash(Object key) {
        return key == null ? -1 : key.hashCode();
    }

    /**
     * <p>
     * Find the item which is equals to the specified item.
     * </p>
     * 
     * @param item A item to find.
     * @return A found item in this set.
     */
    E find(Object item) {
        return (E) items.getProperty(hash(item));
    }

    /**
     * <p>
     * Add the item overwritely and return the previous item.
     * </p>
     * 
     * @param item A item to add.
     * @return A previous item or null.
     */
    E push(Object item) {
        E previous = null;
        int hash = hash(item);

        if (items.hasProperty(hash)) {
            previous = (E) items.getProperty(hash);
        } else {
            size++;
        }

        // assign property
        items.setProperty(hash, item);

        // API definition
        return previous;
    }

    /**
     * <p>
     * Remove the item and return it.
     * </p>
     * 
     * @param item A item to remove.
     * @return A removed item or null.
     */
    E pull(Object item) {
        E previous = null;
        int hash = hash(item);

        if (items.hasProperty(hash)) {
            previous = (E) items.getProperty(hash);

            size--;
            items.deleteProperty(hash);
        }

        // API definition
        return previous;
    }

    /**
     * @version 2012/12/09 19:25:43
     */
    class View implements Iterator<E> {

        /** The actual view. */
        private final String[] keys;

        /** The curren position. */
        private int index = 0;

        /** The current selected item. */
        private E current;

        /**
         * @param keys
         */
        private View(String[] keys) {
            this.keys = keys;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return index < keys.length;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E next() {
            current = (E) items.getProperty(keys[index++]);

            return current;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void remove() {
            if (0 < index) {
                HashSet.this.remove(current);
            }
        }
    }
}
