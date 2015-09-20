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

import js.lang.NativeCSSStyleSheet;
import jsx.style.Style;
import jsx.style.StyleRule;

/**
 * @version 2015/09/20 10:15:40
 */
class StyleRepository {

    /** The actual stylesheet. */
    private static final NativeCSSStyleSheet stylesheet = document.styleSheets().item(2);

    /** The managed style list. */
    private static final Set<Style> styles = new HashSet();

    /**
     * <p>
     * Define the specified {@link Style}.
     * </p>
     * 
     * @param style
     */
    static void define(Style style) {
        if (style != null && styles.add(style)) {
            WidgetLog.StyleDefinition.start();
            define(StyleRule.create("$", style));
            WidgetLog.StyleDefinition.stop();
        }
    }

    private static void define(StyleRule rule) {
        stylesheet.insertRule(rule.toString(), 0);

        for (int i = 0; i < rule.children.length(); i++) {
            define(rule.children.get(i));
        }
    }
}
