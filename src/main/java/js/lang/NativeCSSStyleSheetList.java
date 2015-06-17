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
import java.util.List;

import booton.translator.Translator;

/**
 * <p>
 * An array-like object containing an ordered collection of StyleSheet objects.
 * </p>
 * 
 * @version 2014/10/15 11:28:36
 */
public class NativeCSSStyleSheetList {

    /** The stylesheet holder. */
    final List<NativeCSSStyleSheet> list = new ArrayList();

    /**
     * <p>
     * The number of StyleSheet in the list. The range of valid child rule indices is 0 to length-1
     * inclusive.
     * </p>
     * 
     * @return A number of sheets.
     */
    public int length() {
        return list.size();
    }

    /**
     * <p>
     * Used to retrieve a StyleSheet by ordinal index.
     * </p>
     * 
     * @param index An index into the collection.
     * @return The style sheet at the index position in the StyleSheetList, or null if that is not a
     *         valid index.
     */
    public NativeCSSStyleSheet item(int index) {
        return list.get(index);
    }

    /**
     * @version 2014/10/15 11:34:17
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeCSSStyleSheetList> {

        /**
         * <p>
         * The number of StyleSheet in the list. The range of valid child rule indices is 0 to
         * length-1 inclusive.
         * </p>
         * 
         * @return A number of sheets.
         */
        public String length() {
            return that + ".length";
        }

        /**
         * <p>
         * Used to retrieve a StyleSheet by ordinal index.
         * </p>
         * 
         * @param index An index into the collection.
         * @return The style sheet at the index position in the StyleSheetList, or null if that is
         *         not a valid index.
         */
        public String item(int index) {
            return that + ".item(" + param(0) + ")";
        }
    }
}
