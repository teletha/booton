/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import kiss.I;
import booton.translator.Translator;

/**
 * @version 2013/05/12 13:15:19
 */
public class NativeArray<T> extends NativeObject {

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
     * 
     */
    public NativeArray(List<T> initial) {
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
        return (T) get(index, Object.class);
    }

    /**
     * <p>
     * Retrieve the item at the specified index.
     * </p>
     * 
     * @param index A array index;
     * @return A item at index.
     */
    public int getAsInt(int index) {
        return get(index, Integer.class).intValue();
    }

    /**
     * <p>
     * Retrieve the item at the specified index.
     * </p>
     * 
     * @param index A array index;
     * @return A item at index.
     */
    public long getAsLong(int index) {
        return get(index, Long.class).longValue();
    }

    /**
     * <p>
     * Retrieve the item at the specified index.
     * </p>
     * 
     * @param index A array index;
     * @return A item at index.
     */
    public float getAsFloat(int index) {
        return get(index, Float.class).floatValue();
    }

    /**
     * <p>
     * Retrieve the item at the specified index.
     * </p>
     * 
     * @param index A array index;
     * @return A item at index.
     */
    public double getAsDouble(int index) {
        return get(index, Double.class).doubleValue();
    }

    /**
     * <p>
     * Retrieve the item at the specified index.
     * </p>
     * 
     * @param index A array index;
     * @return A item at index.
     */
    public boolean getAsBoolean(int index) {
        return get(index, Boolean.class).booleanValue();
    }

    /**
     * <p>
     * Retrieve the item at the specified index.
     * </p>
     * 
     * @param index A array index;
     * @return A item at index.
     */
    public short getAsShort(int index) {
        return get(index, Short.class).shortValue();
    }

    /**
     * <p>
     * Retrieve the item at the specified index.
     * </p>
     * 
     * @param index A array index;
     * @return A item at index.
     */
    public byte getAsByte(int index) {
        return get(index, Byte.class).byteValue();
    }

    /**
     * <p>
     * Retrieve the item at the specified index.
     * </p>
     * 
     * @param index A array index;
     * @return A item at index.
     */
    public char getAsChar(int index) {
        return get(index, Character.class).charValue();
    }

    /**
     * <p>
     * Helper method to get value.
     * </p>
     * 
     * @param index
     * @param type
     * @return
     */
    private <X> X get(int index, Class<X> type) {
        ensureSize(index + 1);

        return (X) list.get(index);
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
     * Joins all elements of an array into a string.
     * </p>
     * 
     * @param separator A separator text.
     * @return A built expression.
     */
    public String join(String separator) {
        return I.join(list, separator);
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
    public void add(int index, T[] items) {
        for (int i = 0; i < items.length; i++) {
            list.add(i + index, items[i]);
        }
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
     * <p>
     * Changes the content of an array, adding new elements while removing old elements.
     * </p>
     */
    public void remove(int index, int length) {
        for (int i = 0; i < length; i++) {
            list.remove(index);
        }
    }

    /**
     * <p>
     * Returns a shallow copy of a portion of an array.
     * </p>
     * 
     * @param begin Zero-based index at which to begin extraction. As a negative index, begin
     *            indicates an offset from the end of the sequence. slice(-2) extracts the
     *            second-to-last element and the last element in the sequence.
     * @return
     */
    public NativeArray<T> slice(int begin) {
        return slice(begin, list.size());
    }

    /**
     * <p>
     * Returns a shallow copy of a portion of an array.
     * </p>
     * 
     * @param begin Zero-based index at which to begin extraction. As a negative index, begin
     *            indicates an offset from the end of the sequence. slice(-2) extracts the
     *            second-to-last element and the last element in the sequence.
     * @param end Zero-based index at which to end extraction. slice extracts up to but not
     *            including end. slice(1,4) extracts the second element through the fourth element
     *            (elements indexed 1, 2, and 3). As a negative index, end indicates an offset from
     *            the end of the sequence. slice(2,-1) extracts the third element through the
     *            second-to-last element in the sequence. If end is omitted, slice extracts to the
     *            end of the sequence.
     * @return
     */
    public NativeArray<T> slice(int begin, int end) {
        return new NativeArray(list.subList(begin, end));
    }

    /**
     * <p>
     * Create new {@link NativeArray} with copied elements.
     * </p>
     * 
     * @return
     */
    public NativeArray<T> copy() {
        return new NativeArray(list.toArray());
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
     * <p>
     * Sorts the elements of an array in place and returns the array.
     * </p>
     * 
     * @param comparator Specifies a function that defines the sort order. If omitted, the array is
     *            sorted lexicographically (in dictionary order) according to the string conversion
     *            of each element.
     * @return
     */
    public NativeArray<T> sort(NativeFunction<? extends Comparator<? super T>> comparator) {
        Collections.sort(list, comparator.type);

        return this;
    }

    /**
     * @version 2013/05/01 19:40:46
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
         * Retrieve the item at the specified index.
         * </p>
         * 
         * @param index A array index;
         * @return A item at index.
         */
        public String getAsInt(int index) {
            return that + "[" + param(0) + "]";
        }

        /**
         * <p>
         * Retrieve the item at the specified index.
         * </p>
         * 
         * @param index A array index;
         * @return A item at index.
         */
        public String getAsLong(int index) {
            return that + "[" + param(0) + "]";
        }

        /**
         * <p>
         * Retrieve the item at the specified index.
         * </p>
         * 
         * @param index A array index;
         * @return A item at index.
         */
        public String getAsFloat(int index) {
            return that + "[" + param(0) + "]";
        }

        /**
         * <p>
         * Retrieve the item at the specified index.
         * </p>
         * 
         * @param index A array index;
         * @return A item at index.
         */
        public String getAsDouble(int index) {
            return that + "[" + param(0) + "]";
        }

        /**
         * <p>
         * Retrieve the item at the specified index.
         * </p>
         * 
         * @param index A array index;
         * @return A item at index.
         */
        public String getAsBoolean(int index) {
            return that + "[" + param(0) + "]";
        }

        /**
         * <p>
         * Retrieve the item at the specified index.
         * </p>
         * 
         * @param index A array index;
         * @return A item at index.
         */
        public String getAsShort(int index) {
            return that + "[" + param(0) + "]";
        }

        /**
         * <p>
         * Retrieve the item at the specified index.
         * </p>
         * 
         * @param index A array index;
         * @return A item at index.
         */
        public String getAsByte(int index) {
            return that + "[" + param(0) + "]";
        }

        /**
         * <p>
         * Retrieve the item at the specified index.
         * </p>
         * 
         * @param index A array index;
         * @return A item at index.
         */
        public String getAsChar(int index) {
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
         * Joins all elements of an array into a string.
         * </p>
         * 
         * @param separator A separator text.
         * @return A built expression.
         */
        public String join(String separator) {
            return that + ".join(" + param(0) + ")";
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
        public String add(int index, T item) {
            return that + ".splice(" + param(0) + ",0," + param(1) + ")";
        }

        /**
         * <p>
         * Changes the content of an array, adding new elements while removing old elements.
         * </p>
         */
        public String add(int index, T[] items) {
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
        public String remove(int index, int length) {
            return that + ".splice(" + param(0) + "," + param(1) + ")";
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
         * <p>
         * Returns a shallow copy of a portion of an array.
         * </p>
         * 
         * @param begin Zero-based index at which to begin extraction. As a negative index, begin
         *            indicates an offset from the end of the sequence. slice(-2) extracts the
         *            second-to-last element and the last element in the sequence.
         * @return
         */
        public String slice(int begin) {
            return that + ".slice(" + param(0) + ")";
        }

        /**
         * <p>
         * Returns a shallow copy of a portion of an array.
         * </p>
         * 
         * @param begin Zero-based index at which to begin extraction. As a negative index, begin
         *            indicates an offset from the end of the sequence. slice(-2) extracts the
         *            second-to-last element and the last element in the sequence.
         * @param end Zero-based index at which to end extraction. slice extracts up to but not
         *            including end. slice(1,4) extracts the second element through the fourth
         *            element (elements indexed 1, 2, and 3). As a negative index, end indicates an
         *            offset from the end of the sequence. slice(2,-1) extracts the third element
         *            through the second-to-last element in the sequence. If end is omitted, slice
         *            extracts to the end of the sequence.
         * @return
         */
        public String slice(int begin, int end) {
            return that + ".slice(" + param(0) + "," + param(1) + ")";
        }

        /**
         * {@inheritDoc}
         */
        public String iterator() {
            return that + ".it()";
        }

        /**
         * <p>
         * Create new {@link NativeArray} with copied elements.
         * </p>
         * 
         * @return
         */
        public String copy() {
            return that + ".slice(0)";
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

        /**
         * <p>
         * Sorts the elements of an array in place and returns the array.
         * </p>
         * 
         * @param comparator Specifies a function that defines the sort order. If omitted, the array
         *            is sorted lexicographically (in dictionary order) according to the string
         *            conversion of each element.
         * @return
         */
        public String sort(NativeFunction<? extends Comparator<? super T>> comparator) {
            return that + ".sort(" + param(0) + ")";
        }
    }
}
