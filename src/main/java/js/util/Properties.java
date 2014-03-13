/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/03/13 12:53:09
 */
@JavaAPIProvider(java.util.Properties.class)
class Properties extends HashMap<String, String> {

    /**
     * Returns a set of keys in this property list where the key and its corresponding value are
     * strings, including distinct keys in the default property list if a key of the same name has
     * not already been found from the main properties list. Properties whose key or value is not of
     * type <tt>String</tt> are omitted.
     * <p>
     * The returned set is not backed by the <tt>Properties</tt> object. Changes to this
     * <tt>Properties</tt> are not reflected in the set, or vice versa.
     *
     * @return a set of keys in this property list where the key and its corresponding value are
     *         strings, including the keys in the default property list.
     * @see java.util.Properties#defaults
     * @since 1.6
     */
    public Set<String> stringPropertyNames() {
        return keySet();
    }

    /**
     * Searches for the property with the specified key in this property list. If the key is not
     * found in this property list, the default property list, and its defaults, recursively, are
     * then checked. The method returns {@code null} if the property is not found.
     *
     * @param key the property key.
     * @return the value in this property list with the specified key value.
     * @see #setProperty
     * @see #defaults
     */
    public String getProperty(String key) {
        return get(key);
    }

    /**
     * Searches for the property with the specified key in this property list. If the key is not
     * found in this property list, the default property list, and its defaults, recursively, are
     * then checked. The method returns the default value argument if the property is not found.
     *
     * @param key the hashtable key.
     * @param defaultValue a default value.
     * @return the value in this property list with the specified key value.
     * @see #setProperty
     * @see #defaults
     */
    public String getProperty(String key, String defaultValue) {
        return getOrDefault(key, defaultValue);
    }

    /**
     * Reads a property list (key and element pairs) from the input byte stream. The input stream is
     * in a simple line-oriented format as specified in {@link #load(java.io.Reader) load(Reader)}
     * and is assumed to use the ISO 8859-1 character encoding; that is each byte is one Latin1
     * character. Characters not in Latin1, and certain special characters, are represented in keys
     * and elements using Unicode escapes as defined in section 3.3 of <cite>The Java&trade;
     * Language Specification</cite>.
     * <p>
     * The specified stream remains open after this method returns.
     *
     * @param inStream the input stream.
     * @exception IOException if an error occurred when reading from the input stream.
     * @throws IllegalArgumentException if the input stream contains a malformed Unicode escape
     *             sequence.
     * @since 1.2
     */
    public synchronized void load(InputStream inStream) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
