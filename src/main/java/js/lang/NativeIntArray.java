/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

import booton.translator.Javascript;
import booton.translator.Translator;

/**
 * @version 2014/03/29 19:56:30
 */
public class NativeIntArray {

    /** The java emulation. */
    private int[] list;

    /**
     * 
     */
    public NativeIntArray() {
        list = new int[0];
    }

    /**
     * 
     */
    public NativeIntArray(int initialSize) {
        list = new int[initialSize];
    }

    /**
     * 
     */
    public NativeIntArray(int[] initial) {
        list = initial;
    }

    /**
     * 
     */
    private NativeIntArray(List<Integer> initial) {
        this(initial.size());

        for (int i = 0; i < initial.size(); i++) {
            list[i] = initial.get(i);
        }
    }

    /**
     * <p>
     * Retrieve the item at the specified index.
     * </p>
     * 
     * @param index A array index;
     * @return A item at index.
     */
    public int get(int index) {
        return list[index];
    }

    /**
     * <p>
     * Retrieve the item at the specified index.
     * </p>
     * 
     * @param index A array index;
     * @return A item at index.
     */
    public int get(int index, int defaultValue) {
        if (index < 0 || list.length <= index) {
            return defaultValue;
        }
        return list[index];
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
    public int set(int index, int value) {
        ensureSize(index + 1);

        return list[index] = value;
    }

    /**
     * <p>
     * Ensure list size.
     * </p>
     * 
     * @param min A minmum size.
     */
    private void ensureSize(int min) {
        if (list.length < min) {
            int[] copy = new int[min];

            for (int i = 0; i < list.length; i++) {
                copy[i] = list[i];
            }
            list = copy;
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
        return list.length;
    }

    /**
     * <p>
     * Returns a new array comprised of this array joined with other array(s) and/or value(s).
     * </p>
     * 
     * @param values Arrays and/or values to concatenate to the resulting array.
     * @return
     */
    public NativeIntArray concat(int[] values) {
        int[] copy = new int[list.length + values.length];

        for (int i = 0; i < list.length; i++) {
            copy[i] = list[i];
        }

        for (int i = 0; i < values.length; i++) {
            copy[i + list.length] = values[i];
        }
        return new NativeIntArray(copy);
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
        StringJoiner joiner = new StringJoiner(separator);

        for (int i = 0; i < list.length; i++) {
            joiner.add(String.valueOf(list[i]));
        }
        return joiner.toString();
    }

    /**
     * <p>
     * Adds one or more elements to the end of an array and returns the new length of the array.
     * </p>
     * 
     * @param item The elements to add to the end of the array.
     * @return The new length property of the object upon which the method was called.
     */
    public int push(int item) {
        set(list.length, item);

        return list.length;
    }

    /**
     * <p>
     * The pop method removes the last element from an array and returns that value to the caller.
     * </p>
     * 
     * @return A removed item.
     */
    public int pop() {
        return remove(list.length - 1);
    }

    /**
     * <p>
     * Removes the first element from an array and returns that element. This method changes the
     * length of the array.
     * </p>
     * 
     * @return A removed item.
     */
    public int shift() {
        return remove(0);
    }

    /**
     * <p>
     * Adds one or more elements to the front of an array and returns the new length of the array.
     * </p>
     * 
     * @return The new length property of the object upon which the method was called.
     */
    public int unshift(int item) {
        add(0, item);

        return list.length;
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
    public int indexOf(int item) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
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
    public int lastIndexOf(int item) {
        for (int i = list.length - 1; 0 <= i; i++) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }

    /**
     * <p>
     * Changes the content of an array, adding new elements while removing old elements.
     * </p>
     */
    public void add(int index, int item) {
        add(index, new int[] {item});
    }

    /**
     * <p>
     * Changes the content of an array, adding new elements while removing old elements.
     * </p>
     */
    public void add(int index, int[] items) {
        int[] copy = new int[list.length + items.length];

        for (int i = 0; i < index; i++) {
            copy[i] = list[i];
        }

        for (int i = 0; i < items.length; i++) {
            copy[i + index] = items[i];
        }

        for (int i = index; i < list.length; i++) {
            copy[i + items.length] = list[i];
        }
        list = copy;
    }

    /**
     * <p>
     * Changes the content of an array, adding new elements while removing old elements.
     * </p>
     */
    public int remove(int index) {
        int[] copy = new int[list.length - 1];

        for (int i = 0; i < index; i++) {
            copy[i] = list[i];
        }

        for (int i = index + 1; i < list.length; i++) {
            copy[i] = list[i];
        }

        int removed = list[index];

        // replace
        list = copy;

        return removed;
    }

    /**
     * <p>
     * Changes the content of an array, adding new elements while removing old elements.
     * </p>
     */
    public void remove(int index, int length) {
        for (int i = 0; i < length; i++) {
            remove(index);
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
    public NativeIntArray slice(int begin) {
        return slice(begin, list.length);
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
    public NativeIntArray slice(int begin, int end) {
        return new NativeIntArray(Arrays.copyOfRange(list, begin, end));
    }

    /**
     * <p>
     * Create new {@link NativeArray} with copied elements.
     * </p>
     * 
     * @return
     */
    public NativeIntArray copy() {
        List copy = new ArrayList();

        for (int item : list) {
            copy.add(item);
        }

        return new NativeIntArray(copy);
    }

    /**
     * <p>
     * Reverses an array in place. The first array element becomes the last and the last becomes the
     * first.
     * </p>
     * 
     * @return Chainable API.
     */
    public NativeIntArray reverse() {
        int[] copy = new int[list.length];

        for (int i = 0; i < copy.length; i++) {
            copy[i] = list[list.length - 1 - i];
        }
        list = copy;

        return this;
    }

    /**
     * <p>
     * Convert type to Java array.
     * </p>
     * 
     * @return
     */
    public int[] toArray() {
        return list;
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
    public NativeIntArray sort(NativeFunction<? extends Comparator<Integer>> comparator) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Increment value by index.
     * </p>
     * 
     * @param index
     */
    public void increment(int index) {
        set(index, get(index) + 1);
    }

    /**
     * <p>
     * Decrement value by index.
     * </p>
     * 
     * @param index
     */
    public void decrement(int index) {
        set(index, get(index) - 1);
    }

    /**
     * @version 2013/08/31 23:26:39
     */
    @SuppressWarnings("unused")
    private static class Coder<T> extends Translator<NativeIntArray> {

        /**
         * <p>
         * Create array.
         * </p>
         * 
         * @return
         */
        public String NativeIntArray() {
            return "boot.array(\"" + Javascript.computeSimpleClassName(int.class) + "\",0,0)";
        }

        /**
         * <p>
         * Create array.
         * </p>
         */
        public String NativeIntArray(int initialSize) {
            return "boot.array(\"" + Javascript.computeSimpleClassName(int.class) + "\"," + param(0) + ",0)";
        }

        /**
         * <p>
         * Create array.
         * </p>
         * 
         * @return
         */
        public String NativeIntArray(int[] initial) {
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
        public String get(int index, int defaultValue) {
            return "(" + that + "[" + param(0) + "]||" + param(1) + ")";
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
        public String concat(int[] values) {
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
         * Adds one or more elements to the end of an array and returns the new length of the array.
         * </p>
         * 
         * @param item The elements to add to the end of the array.
         * @return The new length property of the object upon which the method was called.
         */
        public String push(int param0) {
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
        public String indexOf(int item) {
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
        public String lastIndexOf(int item) {
            return that + ".lastIndexOf(" + param(0) + ")";
        }

        /**
         * <p>
         * Changes the content of an array, adding new elements while removing old elements.
         * </p>
         */
        public String add(int index, int item) {
            return that + ".splice(" + param(0) + ",0," + param(1) + ")";
        }

        /**
         * <p>
         * Changes the content of an array, adding new elements while removing old elements.
         * </p>
         */
        public String add(int index, int[] items) {
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
        public String splice(int param0, int param1, NativeIntArray param2) {
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
            return "boot.array(" + that + ".$," + that + ".slice(0))";
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
         * Sorts the elements of an array in place and returns the array.
         * </p>
         * 
         * @param comparator Specifies a function that defines the sort order. If omitted, the array
         *            is sorted lexicographically (in dictionary order) according to the string
         *            conversion of each element.
         * @return
         */
        public String sort(NativeFunction<? extends Comparator<Integer>> comparator) {
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
        public String unshift(int item) {
            return that + ".unshift(" + param(0) + ")";
        }

        /**
         * <p>
         * Increment value by index.
         * </p>
         * 
         * @param index
         */
        public String increment(int index) {
            return "++" + that + "[" + param(0) + "]";
        }

        /**
         * <p>
         * Decrement value by index.
         * </p>
         * 
         * @param index
         */
        public String decrement(int index) {
            return "--" + that + "[" + param(0) + "]";
        }
    }
}
