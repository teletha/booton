/*
 * Copyright (C) 2014 Nameless Production Committee
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
 * An array-like object containing an ordered collection of CSSRule objects.
 * </p>
 * 
 * @version 2014/10/15 11:28:36
 */
public class NativeCSSRuleList {

    /** The rule holder. */
    final List<NativeCSSRule> rules = new ArrayList();

    /**
     * <p>
     * The number of CSSRules in the list. The range of valid child rule indices is 0 to length-1
     * inclusive.
     * </p>
     * 
     * @return A number of rules.
     */
    public int length() {
        return rules.size();
    }

    /**
     * <p>
     * Used to retrieve a CSS rule by ordinal index. The order in this collection represents the
     * order of the rules in the CSS style sheet. If index is greater than or equal to the number of
     * rules in the list, this returns null.
     * </p>
     * 
     * @param index An index into the collection.
     * @return The style rule at the index position in the CSSRuleList, or null if that is not a
     *         valid index.
     */
    public NativeCSSRule item(int index) {
        return rules.get(index);
    }

    /**
     * @version 2014/10/15 11:34:17
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeCSSRuleList> {

        /**
         * <p>
         * The number of CSSRules in the list. The range of valid child rule indices is 0 to
         * length-1 inclusive.
         * </p>
         * 
         * @return A number of rules.
         */
        public String length() {
            return that + ".length";
        }

        /**
         * <p>
         * Used to retrieve a CSS rule by ordinal index. The order in this collection represents the
         * order of the rules in the CSS style sheet. If index is greater than or equal to the
         * number of rules in the list, this returns null.
         * </p>
         * 
         * @param index An index into the collection.
         * @return The style rule at the index position in the CSSRuleList, or null if that is not a
         *         valid index.
         */
        public String item(int index) {
            return that + ".item(" + param(0) + ")";
        }
    }
}
