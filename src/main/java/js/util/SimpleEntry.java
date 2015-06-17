/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/08/09 9:32:11
 */
@JavaAPIProvider(java.util.AbstractMap.SimpleEntry.class)
class SimpleEntry<K, V> implements Entry<K, V> {

    /** The key. */
    private final K key;

    /** The value. */
    private V value;

    /**
     * Creates an entry representing a mapping from the specified key to the specified value.
     * 
     * @param key the key represented by this entry
     * @param value the value represented by this entry
     */
    public SimpleEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Creates an entry representing the same mapping as the specified entry.
     * 
     * @param entry the entry to copy
     */
    public SimpleEntry(Entry<? extends K, ? extends V> entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    /**
     * Returns the key corresponding to this entry.
     * 
     * @return the key corresponding to this entry
     */
    public K getKey() {
        return key;
    }

    /**
     * Returns the value corresponding to this entry.
     * 
     * @return the value corresponding to this entry
     */
    public V getValue() {
        return value;
    }

    /**
     * Replaces the value corresponding to this entry with the specified value (optional operation).
     * This implementation simply throws <tt>UnsupportedOperationException</tt>, as this class
     * implements an <i>immutable</i> map entry.
     * 
     * @param value new value to be stored in this entry
     * @return (Does not return)
     * @throws UnsupportedOperationException always
     */
    public V setValue(V value) {
        V old = value;
        this.value = value;
        return old;
    }

    /**
     * Compares the specified object with this entry for equality. Returns {@code true} if the given
     * object is also a map entry and the two entries represent the same mapping. More formally, two
     * entries {@code e1} and {@code e2} represent the same mapping if
     * 
     * <pre>
     *   (e1.getKey()==null ?
     *    e2.getKey()==null :
     *    e1.getKey().equals(e2.getKey()))
     *   &amp;&amp;
     *   (e1.getValue()==null ?
     *    e2.getValue()==null :
     *    e1.getValue().equals(e2.getValue()))</pre>
     * 
     * This ensures that the {@code equals} method works properly across different implementations
     * of the {@code Map.Entry} interface.
     * 
     * @param object object to be compared for equality with this map entry
     * @return {@code true} if the specified object is equal to this map entry
     * @see #hashCode
     */
    public boolean equals(Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }

        Map.Entry entry = (Map.Entry) object;
        return Objects.equals(key, entry.getKey()) && Objects.equals(value, entry.getValue());
    }

    /**
     * Returns the hash code value for this map entry. The hash code of a map entry {@code e} is
     * defined to be:
     * 
     * <pre>
     *   (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
     *   (e.getValue()==null ? 0 : e.getValue().hashCode())</pre>
     * 
     * This ensures that {@code e1.equals(e2)} implies that {@code e1.hashCode()==e2.hashCode()} for
     * any two Entries {@code e1} and {@code e2}, as required by the general contract of
     * {@link Object#hashCode}.
     * 
     * @return the hash code value for this map entry
     * @see #equals
     */
    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
    }

    /**
     * Returns a String representation of this map entry. This implementation returns the string
     * representation of this entry's key followed by the equals character ("<tt>=</tt>") followed
     * by the string representation of this entry's value.
     * 
     * @return a String representation of this map entry
     */
    public String toString() {
        return key + "=" + value;
    }
}
