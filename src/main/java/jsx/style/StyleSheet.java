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
            createRuleFrom("STYLE" + style.hashCode(), style);
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
     * <p>
     * Create {@link StyleRule} from the specified object. (e.g. {@link Style}, {@link RuntimeStyle}
     * )
     * </p>
     * 
     * @param object A style description.
     * @return A create new {@link StyleRule}.
     */
    void createRuleFrom(String name, Object object) {
        if (object instanceof Style) {
            Style style = (Style) object;

            // create next rule
            StyleRule rule = new StyleRule(this, name);

            // store previous rule
            StyleRule previous = PropertyDefinition.declarable;

            // swap context rule and execute it
            PropertyDefinition.declarable = rule;
            style.declare();
            PropertyDefinition.declarable = previous;

            // assign rule
            styles.add(style);
            rules.add(rule);
        }
    }
}
