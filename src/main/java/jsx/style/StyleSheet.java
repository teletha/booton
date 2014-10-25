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
 * @version 2014/10/22 15:49:58
 */
public class StyleSheet {

    /** The list of styles. */
    final List<Style> styles = new ArrayList();

    /** The list of rules. */
    final List<StyleRule> rules = new ArrayList();

    /**
     * <p>
     * Add the specified {@link Style} to this {@link StyleSheet}.
     * </p>
     * 
     * @param style A {@link Style} to add.
     */
    public void add(Style style) {
        if (!styles.contains(style)) {
            styles.add(style);
            rules.add(createRuleFrom(style));
        }
    }

    /**
     * <p>
     * Remove the specified {@link Style} from this {@link StyleSheet}.
     * </p>
     * 
     * @param style A {@link Style} to remove.
     */
    public void remove(Style style) {
        int index = styles.indexOf(style);

        if (index != -1) {
            styles.remove(index);
            rules.remove(index);
        }
    }

    /**
     * @param style
     * @return
     */
    private StyleRule createRuleFrom(Style style) {
        StyleRule rule = new StyleRule();

        StyleRule previous = PropertyDefinition.declarable;

        PropertyDefinition.declarable = rule;
        style.declare();
        PropertyDefinition.declarable = previous;

        return rule;
    }
}
