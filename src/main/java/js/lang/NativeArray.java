/*
 * Copyright (C) 2016 Nameless Production Committee
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

import booton.translator.JavascriptAPIProvider;
import booton.translator.Translator;
import kiss.I;

/**
 * @version 2015/01/13 10:48:46
 */
@JavascriptAPIProvider
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
    public NativeArray(int initialSize) {
        for (int i = 0; i < initialSize; i++) {
            list.add(null);
        }
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
        return retrieve(index, (T) null);
    }

    /**
     * <p>
     * Retrieve the item at the specified index.
     * </p>
     * 
     * @param index A array index;
     * @param defaultValue A default value.
     * @return A item at index.
     */
    public <S> S get(int index, S defaultValue) {
        T item = list.get(index);

        return item == null ? defaultValue : (S) item;
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
        return retrieve(index, 0);
    }

    /**
     * <p>
     * Retrieve the item at the specified index.
     * </p>
     * 
     * @param index A array index.
     * @param defaultValue A default value.
     * @return A item at index.
     */
    public int getAsInt(int index, int defaultValue) {
        return retrieve(index, defaultValue);
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
        return retrieve(index, 0L);
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
        return retrieve(index, 0F);
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
        return retrieve(index, 0D);
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
        return retrieve(index, false);
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
        return retrieve(index, 0).shortValue();
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
        return retrieve(index, 0).byteValue();
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
        return get(index, ' ');
    }

    /**
     * <p>
     * Helper method to get value.
     * </p>
     * 
     * @param index
     * @param action
     * @return
     */
    private <X> X retrieve(int index, X defaultValue) {
        ensureSize(index + 1);

        X value = (X) list.get(index);

        return value == null ? defaultValue : value;
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
     * Set the item at the specified index.
     * </p>
     * 
     * @param index A array index;
     * @param value A value to set.
     * @return A value to set.
     */
    public void set(int index, int value) {
        set(index, (T) Integer.valueOf(value));
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
    public void set(int index, long value) {
        set(index, (T) Long.valueOf(value));
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
    public void set(int index, float value) {
        set(index, (T) Float.valueOf(value));
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
    public void set(int index, double value) {
        set(index, (T) Double.valueOf(value));
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
    public void set(int index, byte value) {
        set(index, (T) Byte.valueOf(value));
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
    public void set(int index, short value) {
        set(index, (T) Short.valueOf(value));
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
    public void set(int index, boolean value) {
        set(index, (T) Boolean.valueOf(value));
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
    public void set(int index, char value) {
        set(index, (T) Character.valueOf(value));
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
     * Returns a new array comprised of this array joined with other array(s) and/or value(s).
     * </p>
     * 
     * @param values Arrays and/or values to concatenate to the resulting array.
     * @return
     */
    public NativeArray<T> concat(NativeArray<T> values) {
        List<T> items = new ArrayList();
        items.addAll(list);
        items.addAll(values.list);

        return new NativeArray(items);
    }

    /**
     * <p>
     * Returns a new array comprised of this array joined with other array(s) and/or value(s).
     * </p>
     * 
     * @param values Arrays and/or values to concatenate to the resulting array.
     * @return
     */
    public NativeArray<T> concat(T[] values) {
        List<T> items = new ArrayList();
        items.addAll(list);

        for (T item : items) {
            items.add(item);
        }
        return new NativeArray(items);
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
        return I.join(separator, list);
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
     * Adds one or more elements to the end of an array and returns the new length of the array.
     * </p>
     * 
     * @param item The elements to add to the end of the array.
     * @return The new length property of the object upon which the method was called.
     */
    public int push(NativeArray<T> items) {
        list.addAll(items.list);

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
     * The peek method get the last element from an array and returns that value to the caller.
     * </p>
     * 
     * @return The last item.
     */
    public T last() {
        return list.isEmpty() ? null : list.get(list.size() - 1);
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
     * Reverses an array in place. The first array element becomes the last and the last becomes the
     * first.
     * </p>
     * 
     * @return Chainable API.
     */
    public NativeArray<T> reverse() {
        Collections.reverse(list);

        return this;
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
     * @return
     */
    public <V extends Comparable<? super V>> NativeArray<T> sort() {
        ((List<V>) list).sort(Comparator.<V> naturalOrder());
        return this;
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
     * <p>
     * Clear all contents of an array.
     * </p>
     */
    public void clear() {
        list.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return list.toString();
    }

    /**
     * @version 2013/08/31 23:26:39
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
         */
        public String NativeArray(int initialSize) {
            return "new Array(" + param(0) + ")";
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
         * @param defaultValue A default value.
         * @return A item at index.
         */
        public String get(int index, Object defaultValue) {
            return "(" + that + "[" + param(0) + "]||" + param(1) + ")";
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
            return that + "[" + param(0) + "]||0";
        }

        /**
         * <p>
         * Retrieve the item at the specified index.
         * </p>
         * 
         * @param index A array index.
         * @param defaultValue A default value.
         * @return A item at index.
         */
        public String getAsInt(int index, int defaultValue) {
            return that + "[" + param(0) + "]||" + param(1);
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
            return that + "[" + param(0) + "]||0";
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
            return that + "[" + param(0) + "]||0";
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
            return that + "[" + param(0) + "]||0";
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
            return that + "[" + param(0) + "]||false";
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
            return that + "[" + param(0) + "]||0";
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
            return that + "[" + param(0) + "]||0";
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
            return that + "[" + param(0) + "]||''";
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
         * Set the item at the specified index.
         * </p>
         * 
         * @param index A array index;
         * @param value A value to set.
         * @return A value to set.
         */
        public String set(int index, int value) {
            return that + "[" + param(0) + "]=" + param(1);
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
        public String set(int index, long value) {
            return that + "[" + param(0) + "]=" + param(1);
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
        public String set(int index, float value) {
            return that + "[" + param(0) + "]=" + param(1);
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
        public String set(int index, double value) {
            return that + "[" + param(0) + "]=" + param(1);
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
        public String set(int index, boolean value) {
            return that + "[" + param(0) + "]=" + param(1);
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
        public String set(int index, char value) {
            return that + "[" + param(0) + "]=" + param(1);
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
        public String set(int index, byte value) {
            return that + "[" + param(0) + "]=" + param(1);
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
        public String set(int index, short value) {
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
         * Returns a new array comprised of this array joined with other array(s) and/or value(s).
         * </p>
         * 
         * @param values Arrays and/or values to concatenate to the resulting array.
         * @return
         */
        public String concat(NativeArray<T> values) {
            return that + ".concat(" + param(0) + ")";
        }

        /**
         * <p>
         * Returns a new array comprised of this array joined with other array(s) and/or value(s).
         * </p>
         * 
         * @param values Arrays and/or values to concatenate to the resulting array.
         * @return
         */
        public String concat(T[] values) {
            return that + ".concat(" + param(0) + ")";
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
         * The pop method removes the last element from an array and returns that value to the
         * caller.
         * </p>
         * 
         * @return A removed item.
         */
        public String pop() {
            return that + ".pop()";
        }

        /**
         * <p>
         * The peek method get the last element from an array and returns that value to the caller.
         * </p>
         * 
         * @return The last item.
         */
        public String last() {
            return that + "[" + that + ".length-1]";
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
         * Adds one or more elements to the end of an array and returns the new length of the array.
         * </p>
         * 
         * @param item The elements to add to the end of the array.
         * @return The new length property of the object upon which the method was called.
         */
        public String push(NativeArray<T> items) {
            return "Array.prototype.push.apply(" + that + "," + param(0) + ")";
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
         * Reverses an array in place. The first array element becomes the last and the last becomes
         * the first.
         * </p>
         * 
         * @return Chainable API.
         */
        public String reverse() {
            return that + ".reverse()";
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
         * @return
         */
        public String sort() {
            return that + ".sort()";
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

        /**
         * <p>
         * Removes the first element from an array and returns that element. This method changes the
         * length of the array.
         * </p>
         * 
         * @return A removed item.
         */
        public String shift() {
            return that + ".shift()";
        }

        /**
         * <p>
         * Adds one or more elements to the front of an array and returns the new length of the
         * array.
         * </p>
         * 
         * @return The new length property of the object upon which the method was called.
         */
        public String unshift(T item) {
            return that + ".unshift(" + param(0) + ")";
        }

        /**
         * <p>
         * Clear all contents of an array.
         * </p>
         */
        public String clear() {
            return that + ".length=0";
        }
    }
}
