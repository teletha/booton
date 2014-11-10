/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 2014/10/27 13:21:37
 */
public class StyleSheet {

    /** The list of styles. */
    private static final List<StyleClass> styles = new ArrayList();

    /** The list of rules. */
    public static final List<StyleRule> rules = new ArrayList();

    /**
     * <p>
     * Add the specified {@link StyleClass} to this {@link StyleSheet}.
     * </p>
     * 
     * @param style A {@link StyleClass} to add.
     */
    public static void add(StyleClass style) {
        if (!styles.contains(style)) {
            createRule("$", style);
        }
    }

    /**
     * <p>
     * Remove the specified {@link StyleClass} from this {@link StyleSheet}.
     * </p>
     * 
     * @param style A {@link StyleClass} to remove.
     */
    public static void remove(StyleClass style) {
        int index = styles.indexOf(style);

        if (index != -1) {
            styles.remove(index);
            rules.remove(index);
        }
    }

    /**
     * <p>
     * Create {@link StyleRule} from the specified object. (e.g. {@link StyleClass},
     * {@link RuntimeStyle} )
     * </p>
     * 
     * @param object A style description.
     * @return A create new {@link StyleRule}.
     */
    public static StyleRule createRule(String template, StyleClass style) {
        // store parent rule
        StyleRule parent = PropertyDefinition.declarable;

        String name;

        if (parent == null) {
            name = StyleName.name(style);
        } else {
            name = parent.name;
            template = template.replace("$", parent.template);
        }

        // create child rule
        StyleRule child = new StyleRule(template, name);

        // swap context rule and execute it
        PropertyDefinition.declarable = child;
        style.declare();
        PropertyDefinition.declarable = parent;

        // assign rule
        styles.add(style);
        rules.add(child);

        return child;
    }
}
