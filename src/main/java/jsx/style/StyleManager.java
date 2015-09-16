/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import static js.lang.Global.*;

import java.util.HashSet;
import java.util.Set;

import js.lang.NativeCSSStyleSheet;
import jsx.ui.WidgetLog;

/**
 * @version 2015/09/11 22:40:12
 */
public class StyleManager {

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
    public static void add(Style style) {
        if (style != null && styles.add(style)) {
            WidgetLog.StyleDefinition.start();

            if (style instanceof MultipleStyle) {
                MultipleStyle multiple = (MultipleStyle) style;

                for (int i = 0; i < multiple.styles.length(); i++) {
                    add(multiple.styles.get(i));
                }
            } else if (style instanceof ConditionalStyle) {
                add(((ConditionalStyle) style).style);
            } else {
                StyleRule rule = StyleRule.create("$", style);

                add(rule);
            }

            WidgetLog.StyleDefinition.stop();
        }
    }

    private static void add(StyleRule rule) {
        stylesheet.insertRule(rule.toString(), 0);

        for (int i = 0; i < rule.children.length(); i++) {
            add(rule.children.get(i));
        }
    }
}
