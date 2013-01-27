/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import booton.translator.Translator;

/**
 * @version 2012/12/08 11:08:56
 */
public class NativeArray<T> extends NativeObject implements Iterable<T> {

    /** The java emulation. */
    private final ArrayList<T> list = new ArrayList();

    /**
     * 
     */
    public NativeArray() {
    }

    /**
     * 
     */
    public NativeArray(T[] initial) {
        for (T item : initial) {
            list.add(item);
        }
    }

    /**
     * 
     */
    public NativeArray(Set<T> initial) {
        list.addAll(initial);
    }

    /**
     * <p>
     * Retrieve the item at the specified index.
     * </p>
     * 
     * @param index A array index;
     * @return A item at index.
     */
    public T get(int index) {
        ensureSize(index + 1);

        return list.get(index);
    }

    /**
     * <p>
     * Set the item at the specified index.
     * </p>
     * 
     * @param index A array index;
     * @param value A value to set.
     * @return A value to set.
     */
    public T set(int index, T value) {
        ensureSize(index + 1);

        return list.set(index, value);
    }

    /**
     * <p>
     * Ensure list size.
     * </p>
     * 
     * @param min A minmum size.
     */
    private void ensureSize(int min) {
        for (int i = list.size(); i < min; i++) {
            list.add(null);
        }
    }

    /**
     * <p>
     * Reflects the number of elements in an array.
     * </p>
     * 
     * @return A array size.
     */
    public int length() {
        return list.size();
    }

    /**
     * <p>
     * Adds one or more elements to the end of an array and returns the new length of the array.
     * </p>
     * 
     * @param item The elements to add to the end of the array.
     * @return The new length property of the object upon which the method was called.
     */
    public int push(T item) {
        list.add(item);

        return list.size();
    }

    /**
     * <p>
     * The pop method removes the last element from an array and returns that value to the caller.
     * </p>
     * 
     * @return A removed item.
     */
    public T pop() {
        return list.isEmpty() ? null : list.remove(list.size() - 1);
    }

    /**
     * <p>
     * Removes the first element from an array and returns that element. This method changes the
     * length of the array.
     * </p>
     * 
     * @return A removed item.
     */
    public T shift() {
        return list.isEmpty() ? null : list.remove(0);
    }

    /**
     * <p>
     * Adds one or more elements to the front of an array and returns the new length of the array.
     * </p>
     * 
     * @return The new length property of the object upon which the method was called.
     */
    public int unshift(T item) {
        list.add(0, item);

        return list.size();
    }

    /**
     * <p>
     * Returns the first (least) index of an element within the array equal to the specified value,
     * or -1 if none is found.
     * </p>
     * 
     * @param item A search item.
     * @return A first index or -1 if none is found.
     */
    public int indexOf(Object item) {
        return list.indexOf(item);
    }

    /**
     * <p>
     * Returns the last (greatest) index of an element within the array equal to the specified
     * value, or -1 if none is found.
     * </p>
     * 
     * @param item A search item.
     * @return A last index or -1 if none is found.
     */
    public int lastIndexOf(Object item) {
        return list.lastIndexOf(item);
    }

    /**
     * <p>
     * Changes the content of an array, adding new elements while removing old elements.
     * </p>
     */
    public void add(int index, T item) {
        list.add(index, item);
    }

    /**
     * <p>
     * Changes the content of an array, adding new elements while removing old elements.
     * </p>
     */
    public T remove(int index) {
        return list.remove(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    /**
     * <p>
     * Convert type to Java array.
     * </p>
     * 
     * @return
     */
    public Object[] toArray() {
        return list.toArray();
    }

    /**
     * <p>
     * Convert type to Java array.
     * </p>
     * 
     * @return
     */
    public T[] toArray(T[] container) {
        return list.toArray(container);
    }

    /**
     * @version 2012/12/08 11:09:31
     */
    @SuppressWarnings("unused")
    private static class Coder<T> extends Translator<NativeArray> {

        /**
         * <p>
         * Create array.
         * </p>
         * 
         * @return
         */
        public String NativeArray() {
            return "[]";
        }

        /**
         * <p>
         * Create array.
         * </p>
         * 
         * @return
         */
        public String NativeArray(T[] initial) {
            return param(0);
        }

        /**
         * <p>
         * Retrieve the item at the specified index.
         * </p>
         * 
         * @param index A array index;
         * @return A item at index.
         */
        public String get(int index) {
            return that + "[" + param(0) + "]";
        }

        /**
         * <p>
         * Set the item at the specified index.
         * </p>
         * 
         * @param index A array index;
         * @param value A value to set.
         * @return A value to set.
         */
        public String set(int index, Object value) {
            return that + "[" + param(0) + "]=" + param(1);
        }

        /**
         * <p>
         * Reflects the number of elements in an array.
         * </p>
         * 
         * @return A array size.
         */
        public String length() {
            return that + ".length";
        }

        /**
         * <p>
         * Adds one or more elements to the end of an array and returns the new length of the array.
         * </p>
         * 
         * @param item The elements to add to the end of the array.
         * @return The new length property of the object upon which the method was called.
         */
        public String push(Object param0) {
            return that + ".push(" + param(0) + ")";
        }

        /**
         * <p>
         * Returns the first (least) index of an element within the array equal to the specified
         * value, or -1 if none is found.
         * </p>
         * 
         * @param item A search item.
         * @return A first index or -1 if none is found.
         */
        public String indexOf(Object item) {
            return that + ".indexOf(" + param(0) + ")";
        }

        /**
         * <p>
         * Returns the last (greatest) index of an element within the array equal to the specified
         * value, or -1 if none is found.
         * </p>
         * 
         * @param item A search item.
         * @return A last index or -1 if none is found.
         */
        public String lastIndexOf(Object item) {
            return that + ".lastIndexOf(" + param(0) + ")";
        }

        /**
         * <p>
         * Changes the content of an array, adding new elements while removing old elements.
         * </p>
         */
        public String add(int index, Object item) {
            return that + ".splice(" + param(0) + ",0," + param(1) + ")";
        }

        /**
         * <p>
         * Changes the content of an array, adding new elements while removing old elements.
         * </p>
         */
        public String remove(int param0) {
            return that + ".splice(" + param(0) + ",1)[0]";
        }

        /**
         * <p>
         * Changes the content of an array, adding new elements while removing old elements.
         * </p>
         */
        public String splice(int param0, int param1, NativeArray param2) {
            return that + ".splice(" + param(0) + "," + param(1) + "," + param(2) + ")";
        }

        /**
         * {@inheritDoc}
         */
        public String iterator() {
            return that + ".it()";
        }

        /**
         * <p>
         * Convert type to Java array.
         * </p>
         * 
         * @return
         */
        public String toArray() {
            return that;
        }

        /**
         * <p>
         * Convert type to Java array.
         * </p>
         * 
         * @return
         */
        public String toArray(Object[] container) {
            return that;
        }
    }
}
