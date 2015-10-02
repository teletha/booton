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
import js.dom.UIEvent;

/**
 * @version 2015/09/30 17:37:09
 */
public interface Style extends Declarable, Locatable<UIEvent> {

    /**
     * <p>
     * Define the style declaration.
     * </p>
     */
    void style();

    /**
     * {@inheritDoc}
     */
    @Override
    default void declare() {
        StructureDescriptor.latestElement.classList.push(this);
    }

    /**
     * <p>
     * Combine this {@link Style} and the specified {@link Style}.
     * </p>
     * 
     * @param style A style to combine.
     * @return A combined {@link Style}.
     */
    default Style with(Style style) {
        return MultiStyle.of(this, style);
    }

    /**
     * @version 2015/10/01 18:14:54
     */
    public static class MultiStyle implements Style {

        /** The aggregation. */
        final Style[] styles;

        /** The name list. */
        final String[] names;

        /**
         * Hide constructor.
         * 
         * @param styles A style group.
         */
        private MultiStyle(Style[] styles) {
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
         * Helper method to create {@link MultiStyle}.
         * </p>
         * 
         * @param styles
         * @return
         */
        static MultiStyle of(Style... styles) {
            LinkedHashSet<Style> set = new LinkedHashSet();
            merge(set, styles);

            return new MultiStyle(set.toArray(new Style[set.size()]));
        }

        /**
         * <p>
         * Helper method to create {@link MultiStyle}.
         * </p>
         * 
         * @param set
         * @param styles
         */
        private static void merge(LinkedHashSet<Style> set, Style... styles) {
            for (Style style : styles) {
                if (style instanceof MultiStyle) {
                    merge(set, ((MultiStyle) style).styles);
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
}