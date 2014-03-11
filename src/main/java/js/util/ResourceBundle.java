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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/03/12 3:11:10
 */
@JavaAPIProvider(java.util.ResourceBundle.class)
class ResourceBundle {

    private Map<String, String> bundle = new HashMap();

    /**
     * Determines whether the given <code>key</code> is contained in this
     * <code>ResourceBundle</code> or its parent bundles.
     *
     * @param key the resource <code>key</code>
     * @return <code>true</code> if the given <code>key</code> is contained in this
     *         <code>ResourceBundle</code> or its parent bundles; <code>false</code> otherwise.
     * @exception NullPointerException if <code>key</code> is <code>null</code>
     * @since 1.6
     */
    public boolean containsKey(String key) {
        Objects.nonNull(key);

        return bundle.containsKey(key);
    }

    /**
     * Gets a string for the given key from this resource bundle or one of its parents. Calling this
     * method is equivalent to calling <blockquote>
     * <code>(String) {@link #getObject(java.lang.String) getObject}(key)</code>. </blockquote>
     *
     * @param key the key for the desired string
     * @exception NullPointerException if <code>key</code> is <code>null</code>
     * @exception MissingResourceException if no object for the given key can be found
     * @exception ClassCastException if the object found for the given key is not a string
     * @return the string for the given key
     */
    public final String getString(String key) {
        return bundle.get(key);
    }

    /**
     * @version 2014/03/12 8:37:39
     */
    @JavaAPIProvider(java.util.ResourceBundle.Control.class)
    private static class Control {

        /**
         * The default format <code>List</code>, which contains the strings
         * <code>"java.class"</code> and <code>"java.properties"</code>, in this order. This
         * <code>List</code> is {@linkplain Collections#unmodifiableList(List) unmodifiable}.
         *
         * @see #getFormats(String)
         */
        public static final List<String> FORMAT_DEFAULT = Collections.unmodifiableList(Arrays.asList("java.class", "java.properties"));

        /**
         * The class-only format <code>List</code> containing <code>"java.class"</code>. This
         * <code>List</code> is {@linkplain Collections#unmodifiableList(List) unmodifiable}.
         *
         * @see #getFormats(String)
         */
        public static final List<String> FORMAT_CLASS = Collections.unmodifiableList(Arrays.asList("java.class"));

        /**
         * The properties-only format <code>List</code> containing <code>"java.properties"</code>.
         * This <code>List</code> is {@linkplain Collections#unmodifiableList(List) unmodifiable}.
         *
         * @see #getFormats(String)
         */
        public static final List<String> FORMAT_PROPERTIES = Collections.unmodifiableList(Arrays.asList("java.properties"));

        /**
         * Returns a <code>ResourceBundle.Control</code> in which the {@link #getFormats(String)
         * getFormats} method returns the specified <code>formats</code>. The <code>formats</code>
         * must be equal to one of {@link Control#FORMAT_PROPERTIES}, {@link Control#FORMAT_CLASS}
         * or {@link Control#FORMAT_DEFAULT}. <code>ResourceBundle.Control</code> instances returned
         * by this method are singletons and thread-safe.
         * <p>
         * Specifying {@link Control#FORMAT_DEFAULT} is equivalent to instantiating the
         * <code>ResourceBundle.Control</code> class, except that this method returns a singleton.
         *
         * @param formats the formats to be returned by the
         *            <code>ResourceBundle.Control.getFormats</code> method
         * @return a <code>ResourceBundle.Control</code> supporting the specified
         *         <code>formats</code>
         * @exception NullPointerException if <code>formats</code> is <code>null</code>
         * @exception IllegalArgumentException if <code>formats</code> is unknown
         */
        public static final Control getControl(List<String> formats) {
            if (formats.equals(Control.FORMAT_PROPERTIES)) {
                return SingleFormatControl.PROPERTIES_ONLY;
            }
            if (formats.equals(Control.FORMAT_CLASS)) {
                return SingleFormatControl.CLASS_ONLY;
            }
            if (formats.equals(Control.FORMAT_DEFAULT)) {
                return Control.INSTANCE;
            }
            throw new IllegalArgumentException();
        }
    }
}
