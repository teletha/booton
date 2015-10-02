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
     * <p>
     * Compute style class name.
     * </p>
     * 
     * @return A style class name.
     */
    public default String className() {
        return "Style" + hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void declare() {
        StructureDescriptor.latestElement.classList.push(this);
    }

    public default void define() {
        StyleRepository.define(this);
    }

    default Style with(Style style) {
        return MultiStyle.of(this, style);
    }

    /**
     * @version 2015/10/01 18:14:54
     */
    public static class MultiStyle implements Style {

        /** The aggregation. */
        final Style[] styles;

        /**
         * Hide constructor.
         * 
         * @param styles A style group.
         */
        private MultiStyle(Style[] styles) {
            this.styles = styles;
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
        public void style() {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void declare() {
            for (Style style : styles) {
                style.declare();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void define() {
            for (Style style : styles) {
                style.define();
            }
        }
    }
}