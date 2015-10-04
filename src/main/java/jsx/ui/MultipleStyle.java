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

import java.util.LinkedHashSet;

import js.dom.CSSStyleSheet;

/**
 * @version 2015/10/05 2:12:18
 */
class MultipleStyle implements Style {

    /** The aggregation. */
    final Style[] styles;

    /** The name list. */
    final String[] names;

    /**
     * Hide constructor.
     * 
     * @param styles A style group.
     */
    private MultipleStyle(Style[] styles) {
        this.styles = styles;
        this.names = new String[styles.length + 1];

        for (int i = 0; i < names.length - 1; i++) {
            names[i] = styles[i].name();

            CSSStyleSheet.define(styles[i]);
        }
        names[names.length - 1] = name();
    }

    /**
     * <p>
     * Helper method to create {@link MultipleStyle}.
     * </p>
     * 
     * @param styles
     * @return
     */
    static MultipleStyle of(Style... styles) {
        LinkedHashSet<Style> set = new LinkedHashSet();
        merge(set, styles);

        return new MultipleStyle(set.toArray(new Style[set.size()]));
    }

    /**
     * <p>
     * Helper method to create {@link MultipleStyle}.
     * </p>
     * 
     * @param set
     * @param styles
     */
    private static void merge(LinkedHashSet<Style> set, Style... styles) {
        for (Style style : styles) {
            if (style instanceof MultipleStyle) {
                merge(set, ((MultipleStyle) style).styles);
            } else {
                set.add(style);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return "Multi" + hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] names() {
        return names;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void style() {
    }
}