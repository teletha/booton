/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 2016/09/15 12:53:24
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
        List<Style> list = new ArrayList();
        merge(list, styles);

        return new MultipleStyle(list.toArray(new Style[list.size()]));
    }

    /**
     * <p>
     * Helper method to create {@link MultipleStyle}.
     * </p>
     * 
     * @param list
     * @param styles
     */
    private static void merge(List<Style> list, Style... styles) {
        for (Style style : styles) {
            if (style instanceof MultipleStyle) {
                merge(list, ((MultipleStyle) style).styles);
            } else if (!list.contains(style)) {
                list.add(style);
            }
        }
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
        for (Style style : styles) {
            style.style();
        }
    }
}
