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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @version 2014/10/22 15:51:03
 */
public class StyleRule extends StyleDeclarable {

    /** The list of declared rules. */
    private static final List<StyleRule> rules = new ArrayList();

    /** The parent rule. */
    final StyleRule parent;

    /** The template of this rule's selector. */
    final String template;

    /** The list of selectors. */
    final List<String> selectors = new ArrayList();

    /** The sub rules. */
    final List<StyleRule> children = new ArrayList();

    /** The rule that this rule depends on. */
    final Set<StyleRule> dependencies = new HashSet();

    /** The property holder. */
    final Map<String, String> properties = new HashMap();

    /**
     * <p>
     * Define empty rule.
     * </p>
     */
    public StyleRule() {
        this(null, "", null);
    }

    /**
     * <p>
     * Define {@link StyleRule} with the specified properties.
     * </p>
     */
    public StyleRule(Runnable definition) {
        this(null, "", null);

        StyleDeclarable declarable = PropertyDefinition.declarable;

        PropertyDefinition.declarable = this;
        definition.run();
        PropertyDefinition.declarable = declarable;
    }

    /**
     * <p>
     * Define empty rule with parent rule.
     * </p>
     * 
     * @param parent A parent rule.
     * @param template A selector template.
     */
    StyleRule(StyleRule parent, String template) {
        this(parent, template.replace("$", parent.template), parent.selectors.get(0));
    }

    /**
     * <p>
     * Define style rule.
     * </p>
     * 
     * @param template
     * @param name
     * @param parent
     */
    private StyleRule(StyleRule parent, String template, String name) {
        this.template = template;
        this.parent = parent;
        this.selectors.add(name);

        // store as child rule in parent rule
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
    void importSelectorsFrom(StyleRule set) {
        selectors.addAll(set.selectors);

        for (StyleRule dependence : dependencies) {
            dependence.importSelectorsFrom(set);
        }

        for (StyleRule child : children) {
            child.importSelectorsFrom(set);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setProperty(String name, String value) {
        properties.put(name, value);
    }

    /**
     * <p>
     * Enable this rule.
     * </p>
     */
    public void enable() {
        if (!rules.contains(this)) {
            rules.add(this);
        }
    }

    /**
     * <p>
     * Disable this rule.
     * </p>
     */
    public void disable() {
        if (rules.contains(this)) {
            rules.remove(this);
        }
    }
}