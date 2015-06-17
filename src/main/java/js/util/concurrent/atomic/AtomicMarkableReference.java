/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent.atomic;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/03/12 14:48:47
 */
@JavaAPIProvider(java.util.concurrent.atomic.AtomicMarkableReference.class)
class AtomicMarkableReference<V> {

    /** The value holder. */
    private volatile V value;

    /** The value mark. */
    private volatile boolean mark;

    /**
     * Creates a new {@code AtomicMarkableReference} with the given initial values.
     *
     * @param initialRef the initial reference
     * @param initialMark the initial mark
     */
    public AtomicMarkableReference(V initialRef, boolean initialMark) {
        value = initialRef;
        mark = initialMark;
    }

    /**
     * Returns the current value of the reference.
     *
     * @return the current value of the reference
     */
    public V getReference() {
        return value;
    }

    /**
     * Returns the current values of both the reference and the mark. Typical usage is
     * {@code boolean[1] holder; ref = v.get(holder); }.
     *
     * @param markHolder an array of size of at least one. On return, {@code markholder[0]} will
     *            hold the value of the mark.
     * @return the current value of the reference
     */
    public V get(boolean[] markHolder) {
        markHolder[0] = mark;
        return value;
    }

    /**
     * Unconditionally sets the value of both the reference and mark.
     *
     * @param newReference the new value for the reference
     * @param newMark the new value for the mark
     */
    public void set(V newReference, boolean newMark) {
        if (newReference != value || newMark != mark) {
            value = newReference;
            mark = newMark;
        }
    }

    /**
     * Atomically sets the value of both the reference and mark to the given update values if the
     * current reference is {@code ==} to the expected reference and the current mark is equal to
     * the expected mark.
     *
     * @param expectedReference the expected value of the reference
     * @param newReference the new value for the reference
     * @param expectedMark the expected value of the mark
     * @param newMark the new value for the mark
     * @return {@code true} if successful
     */
    public boolean compareAndSet(V expectedReference, V newReference, boolean expectedMark, boolean newMark) {
        if (expectedReference == value && expectedMark == mark) {
            if (newReference == value && newMark == mark) {
                return true;
            } else {
                value = newReference;
                mark = newMark;
            }
            return true;
        }
        return false;
    }

    /**
     * Atomically sets to the given value and returns the old value.
     * 
     * @param newValue the new value
     * @return the previous value
     */
    public final V getAndSet(V newValue) {
        V old = value;

        value = newValue;

        return old;
    }

    /**
     * Returns the current value of the mark.
     *
     * @return the current value of the mark
     */
    public boolean isMarked() {
        return mark;
    }
}
