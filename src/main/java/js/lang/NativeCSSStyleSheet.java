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

import booton.translator.Translator;

/**
 * @version 2014/10/15 11:23:57
 */
public class NativeCSSStyleSheet {

    /** The current rule list. */
    private final NativeCSSRuleList list = new NativeCSSRuleList();

    /**
     * <p>
     * The list of all CSS rules contained within the style sheet. This includes both rule sets and
     * at-rules.
     * </p>
     */
    public NativeCSSRuleList getRules() {
        return list;
    }

    /**
     * <p>
     * Inserts a new style rule into the current style sheet.
     * </p>
     * <p>
     * For rule sets this contains both the selector and the style declaration. For at-rules, this
     * specifies both the at-identifier and the rule content. If several rules are given in the
     * DOMString in parameter a DOMException with the code SYNTAX_ERR is thrown.
     * </p>
     * 
     * @param rule A rule to be inserted (selector and declaration).
     * @param index A position to be inserted.
     */
    public void insertRule(String rule, int index) {
        NativeCSSRule cssRule = new NativeCSSRule();
        cssRule.setCSSText(rule);

        list.rules.add(index, cssRule);
    }

    /**
     * <p>
     * Removes a style rule from the current style sheet object.
     * </p>
     * 
     * @param index A position of the rule.
     */
    public void deleteRule(int index) {
        list.rules.remove(index);
    }

    /**
     * @version 2014/10/15 11:44:06
     */
    @SuppressWarnings("unused")
    private static class Corder extends Translator<NativeCSSStyleSheet> {

        /**
         * <p>
         * The list of all CSS rules contained within the style sheet. This includes both rule sets
         * and at-rules.
         * </p>
         */
        public String getRules() {
            return that + ".cssRules";
        }

        /**
         * <p>
         * Inserts a new style rule into the current style sheet.
         * </p>
         * <p>
         * For rule sets this contains both the selector and the style declaration. For at-rules,
         * this specifies both the at-identifier and the rule content. If several rules are given in
         * the DOMString in parameter a DOMException with the code SYNTAX_ERR is thrown.
         * </p>
         * 
         * @param rule A rule to be inserted (selector and declaration).
         * @param index A position to be inserted.
         */
        public String insertRule(String rule, int index) {
            return that + ".insertRule(" + param(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * Removes a style rule from the current style sheet object.
         * </p>
         * 
         * @param index A position of the rule.
         */
        public String deleteRule(int index) {
            return that + ".deleteRule(" + param(0) + ")";
        }
    }
}
