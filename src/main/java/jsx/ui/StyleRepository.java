/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import static js.lang.Global.*;

import java.util.HashSet;
import java.util.Set;

import js.dom.CSSStyleSheet;
import jsx.style.StyleRule;

/**
 * @version 2015/10/01 18:53:44
 */
class StyleRepository {

    /** The base stylesheet. */
    private static final CSSStyleSheet base = document.styleSheets().item(1);

    /** The style manager. */
    private static final Set<Style> styles = new HashSet();

    /**
     * <p>
     * Define the specified {@link Style}.
     * </p>
     * 
     * @param style A target style to define.
     */
    static void define(Style style) {
        if (style != null && styles.add(style)) {
            WidgetLog.DefineStyle.start();
            define(StyleRule.create("$", style));
            WidgetLog.DefineStyle.stop();
        }
    }

    /**
     * <p>
     * Define the specified {@link StyleRule}.
     * </p>
     * 
     * @param rule A target style rule to define.
     */
    private static void define(StyleRule rule) {
        base.insertRule(rule.toString(), base.cssRules.length());

        for (int i = 0; i < rule.children.length(); i++) {
            define(rule.children.get(i));
        }
    }

}
