/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import java.util.Arrays;

import jsx.style.value.Color;
import jsx.style.value.Numeric;

/**
 * @version 2015/09/09 14:52:21
 */
public class Borders extends Border {

    /**
     * <p>
     * The border-top CSS property is a shorthand that sets the values of border-top-color,
     * border-top-style, and border-top-width. These properties describe the top border of elements.
     * </p>
     */
    public final Border top = new Each("top");

    /**
     * <p>
     * The border-bottom CSS property is a shorthand that sets the values of border-bottom-color,
     * border-bottom-style, and border-bottom-width. These properties describe the bottom border of
     * elements.
     * </p>
     */
    public final Border bottom = new Each("bottom");

    /**
     * <p>
     * The border-left CSS property is a shorthand that sets the values of border-left-color,
     * border-left-style, and border-left-width. These properties describe the left border of
     * elements.
     * </p>
     */
    public final Border left = new Each("left");

    /**
     * <p>
     * The border-right CSS property is a shorthand that sets the values of border-right-color,
     * border-right-style, and border-right-width. These properties describe the right border of
     * elements.
     * </p>
     */
    public final Border right = new Each("right");

    /**
     * <p>
     * A shorthand that sets the values of border-top and border-bottom.
     * </p>
     */
    public final Border vertical = new Each("top", "bottom");

    /**
     * <p>
     * A shorthand that sets the values of border-right and border-left.
     * </p>
     */
    public final Border horizontal = new Each("right", "left");

    /**
     * 
     */
    public Borders() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Border radius(Numeric size) {
        return value("border-radius", size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Border width(Numeric size) {
        return value("border", Arrays.asList(size), " ", 2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Border color(Color color) {
        return value("border", Arrays.asList(color), " ", 2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Border style(String style) {
        return value("border", Arrays.asList(style), " ", 2);
    }

    /**
     * @version 2015/09/09 14:52:16
     */
    private static class Each extends Border {

        /** The target side. */
        private final String[] sides;

        /**
         * 
         * 
         */
        public Each(String... sides) {
            this.sides = sides;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Border radius(Numeric size) {
            for (String side : sides) {
                switch (side.length()) {
                case 3: // top
                    value("border-top-right-radius", size);
                    break;

                case 5: // right
                    value("border-bottom-right-radius", size);
                    break;

                case 6: // bottom
                    value("border-bottom-left-radius", size);
                    break;

                case 4: // left
                    value("border-top-left-radius", size);
                    break;
                }
            }
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Border width(Numeric size) {
            for (String side : sides) {
                value("border-" + side, Arrays.asList(size), " ", 2);
            }
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Border color(Color color) {
            for (String side : sides) {
                value("border-" + side, Arrays.asList(color), " ", 2);
            }
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected Border style(String style) {
            for (String side : sides) {
                value("border-" + side, Arrays.asList(style), " ", 2);
            }
            return this;
        }
    }
}
