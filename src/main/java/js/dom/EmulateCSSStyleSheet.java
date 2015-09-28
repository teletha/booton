/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import java.util.ArrayList;
import java.util.List;

import js.lang.NativeCSSRule;

/**
 * @version 2015/09/29 1:54:10
 */
class EmulateCSSStyleSheet extends CSSStyleSheet {

    /** The rule list. */
    private final List<NativeCSSRule> rules = new ArrayList();

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
    @Override
    public void insertRule(String rule, int index) {
        NativeCSSRule cssRule = new NativeCSSRule();
        cssRule.setCSSText(rule);

        rules.add(index, cssRule);
    }

    /**
     * <p>
     * Removes a style rule from the current style sheet object.
     * </p>
     * 
     * @param index A position of the rule.
     */
    @Override
    public void deleteRule(int index) {
        rules.remove(index);
    }
}
