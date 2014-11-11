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
 * @version 2014/11/11 10:54:00
 */
public class StyleSheet {

    /** The list of rules. */
    public final List<StyleRule> rules = new ArrayList();

    /**
     * <p>
     * Create {@link StyleRule} from the specified object. (e.g. {@link Style}, {@link RuntimeStyle}
     * )
     * </p>
     * 
     * @param object A style description.
     * @return A create new {@link StyleRule}.
     */
    public StyleRule createRule(String template, Style style) {
        // store parent rule
        StyleRule parent = PropertyDefinition.declarable;

        // compute selector
        String selector;

        if (parent == null) {
            selector = "." + StyleName.name(style);
        } else {
            selector = template.replace("$", parent.selector);
        }

        // create child rule
        StyleRule child = new StyleRule(selector, this);

        // swap context rule and execute it
        PropertyDefinition.declarable = child;
        style.declare();
        PropertyDefinition.declarable = parent;

        // assign rule
        rules.add(child);

        return child;
    }
}
