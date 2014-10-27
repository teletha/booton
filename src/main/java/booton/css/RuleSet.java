/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import kiss.I;
import booton.Obfuscator;
import booton.util.Strings;

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

    /** The property store. */
    final List<CSSProperty> properties = new ArrayList();

    /**
     * <p>
     * Create top level rule set.
     * </p>
     */
    protected RuleSet(Class clazz) {
        this(null, "$", "." + Obfuscator.computeCSSName(clazz.getName()));
    }

    RuleSet(RuleSet parent, String template) {
        this(parent, template.replace("$", parent.template), parent.selectors.get(0));
    }

    /**
     * <p>
     * Create sub css rule.
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

        // create all properties
        try {
            for (Field field : CSS.class.getFields()) {
                Object value;
                Class type = field.getType();

                try {
                    Constructor constructor = type.getDeclaredConstructor(String.class);
                    constructor.setAccessible(true);
                    value = constructor.newInstance(Strings.hyphenate(field.getName()));
                } catch (NoSuchMethodException e) {
                    value = type.newInstance();
                }
                properties.add((CSSProperty) value);
            }
        } catch (Exception e) {
            throw I.quiet(e);
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