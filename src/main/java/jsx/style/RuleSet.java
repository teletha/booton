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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import booton.Obfuscator;

/**
 * @version 2014/09/03 11:57:21
 */
class RuleSet {

    /** The parent rule set. */
    final RuleSet parent;

    /** The sub rule set. */
    final Set<RuleSet> children = new LinkedHashSet();

    /** The rule set that this rule set depends on. */
    final Set<RuleSet> dependencies = new HashSet();

    /** The selector template. */
    final String template;

    /** The list of selectors. */
    final List<String> selectors = new ArrayList();

    /**
     * <p>
     * Create top level rule set.
     * </p>
     */
    protected RuleSet(Class clazz) {
        this(null, "$", "." + Obfuscator.computeCSSName(clazz));
    }

    RuleSet(RuleSet parent, String template) {
        this(parent, template.replace("$", parent.template), parent.selectors.get(0));
    }

    /**
     * <p>
     * Create css rule.
     * </p>
     */
    private RuleSet(RuleSet parent, String template, String selector) {
        this.parent = parent;
        this.template = template;
        this.selectors.add(selector);

        // store as sub rule in parent rule
        if (parent != null) {
            parent.children.add(this);
        }
    }

    /**
     * <p>
     * Import selectors.
     * </p>
     * 
     * @param set
     */
    void importSelectorsFrom(RuleSet set) {
        selectors.addAll(set.selectors);

        for (RuleSet dependence : dependencies) {
            dependence.importSelectorsFrom(set);
        }

        for (RuleSet child : children) {
            child.importSelectorsFrom(set);
        }
    }
}