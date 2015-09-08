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

import jsx.style.value.Color;
import jsx.style.value.Numeric;

/**
 * @version 2015/09/08 13:20:50
 */
public class Borders extends BorderList {

    /**
     * <p>
     * The border-top CSS property is a shorthand that sets the values of border-top-color,
     * border-top-style, and border-top-width. These properties describe the top border of elements.
     * </p>
     */
    public final Border top = new Single(SideDirection.Top);

    /**
     * <p>
     * The border-bottom CSS property is a shorthand that sets the values of border-bottom-color,
     * border-bottom-style, and border-bottom-width. These properties describe the bottom border of
     * elements.
     * </p>
     */
    public final Border bottom = new Single(SideDirection.Bottom);

    /**
     * <p>
     * The border-left CSS property is a shorthand that sets the values of border-left-color,
     * border-left-style, and border-left-width. These properties describe the left border of
     * elements.
     * </p>
     */
    public final Border left = new Single(SideDirection.Left);

    /**
     * <p>
     * The border-right CSS property is a shorthand that sets the values of border-right-color,
     * border-right-style, and border-right-width. These properties describe the right border of
     * elements.
     * </p>
     */
    public final Border right = new Single(SideDirection.Right);

    /**
     * <p>
     * A shorthand that sets the values of border-right and border-left.
     * </p>
     */
    public final Border horizontal = new BorderList().use(left, right);

    /**
     * <p>
     * A shorthand that sets the values of border-top and border-bottom.
     * </p>
     */
    public final Border vertical = new BorderList().use(top, bottom);

    /**
     * 
     */
    public Borders() {
        use(top, right, bottom, left);
    }

    /**
     * @version 2015/09/08 13:20:54
     */
    private class Single extends Border {

        /** The target side. */
        private final SideDirection side;

        /**
         * @param side
         */
        public Single(SideDirection side) {
            this.side = side;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Border radius(Numeric size) {
            switch (side) {
            case Top:
                value("border-top-right-radius", size);
                break;

            case Right:
                value("border-bottom-right-radius", size);
                break;

            case Bottom:
                value("border-bottom-left-radius", size);
                break;

            case Left:
                value("border-top-left-radius", size);
                break;
            }
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Border width(Numeric size) {
            return value("border-" + side + "-width", size);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Border color(Color color) {
            return value("border-" + side + "-color", color);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected Border style(String style) {
            return value("border-" + side + "-style", style);
        }
    }
}
