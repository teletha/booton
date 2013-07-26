/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.property;

import java.util.EnumMap;

import booton.css.CSSWriter;
import booton.css.value.Color;
import booton.css.value.Numeric;

/**
 * @version 2013/07/23 14:35:11
 */
public class Borders extends BorderSet {

    /** The width properties. */
    private final EnumMap<Side, Numeric> widths = new EnumMap(Side.class);

    /** The style properties. */
    private final EnumMap<Side, BorderStyle> styles = new EnumMap(Side.class);

    /** The color properties. */
    private final EnumMap<Side, Color> colors = new EnumMap(Side.class);

    /** The radius properties. */
    private final EnumMap<Side, Numeric> radius = new EnumMap(Side.class);

    /**
     * <p>
     * The border-top CSS property is a shorthand that sets the values of border-top-color,
     * border-top-style, and border-top-width. These properties describe the top border of elements.
     * </p>
     */
    public final Border top = new Single(Side.Top);

    /**
     * <p>
     * The border-bottom CSS property is a shorthand that sets the values of border-bottom-color,
     * border-bottom-style, and border-bottom-width. These properties describe the bottom border of
     * elements.
     * </p>
     */
    public final Border bottom = new Single(Side.Bottom);

    /**
     * <p>
     * The border-left CSS property is a shorthand that sets the values of border-left-color,
     * border-left-style, and border-left-width. These properties describe the left border of
     * elements.
     * </p>
     */
    public final Border left = new Single(Side.Left);

    /**
     * <p>
     * The border-right CSS property is a shorthand that sets the values of border-right-color,
     * border-right-style, and border-right-width. These properties describe the right border of
     * elements.
     * </p>
     */
    public final Border right = new Single(Side.Right);

    /**
     * <p>
     * A shorthand that sets the values of border-right and border-left.
     * </p>
     */
    public final Border horizontal = new BorderSet().add(left, right);

    /**
     * <p>
     * A shorthand that sets the values of border-top and border-bottom.
     * </p>
     */
    public final Border vertical = new BorderSet().add(top, bottom);

    /**
     * 
     */
    public Borders(String name) {
        super(name);

        add(top, right, bottom, left);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(CSSWriter writer) {
        if (match(widths) && match(styles) && match(colors)) {
            Numeric width = widths.get(Side.Top);
            BorderStyle style = styles.get(Side.Top);
            Color color = colors.get(Side.Top);

            if (width != null && style != null && color != null) {
                writer.property(name, width, style, color);
            } else {
                writer.property(name + "-width", width);
                writer.property(name + "-style", style);
                writer.property(name + "-color", color);
            }
        } else if (match(Side.Top) && match(Side.Right) && match(Side.Bottom) && match(Side.Left)) {
            for (Side side : Side.values()) {
                writer.property(name + "-" + side, widths.get(side), styles.get(side), colors.get(side));
            }
        } else {
            for (Side side : Side.values()) {
                writer.property(name + "-" + side + "-width", widths.get(side));
                writer.property(name + "-" + side + "-style", styles.get(side));
                writer.property(name + "-" + side + "-color", colors.get(side));
            }
        }

        if (match(radius)) {
            writer.property(name + "-radius", radius.get(Side.Top));
        } else {
            for (Side side : Side.values()) {
                writer.property(name + "-" + side.radius + "-radius", radius.get(side));
            }
        }
    }

    /**
     * <p>
     * Helper method to check equality between all objects.
     * </p>
     * 
     * @param map
     * @return A result.
     */
    private boolean match(EnumMap map) {
        Object object = map.get(Side.Top);
        Side[] sides = Side.values();

        for (int i = 1; i < 4; i++) {
            Object current = map.get(sides[i]);
            if (object == null) {
                if (current != null) {
                    return false;
                }
            } else if (!object.equals(current)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Helper method to check equality between all objects.
     * </p>
     * 
     * @param map
     * @return A result.
     */
    private boolean match(Side side) {
        Numeric width = widths.get(side);
        BorderStyle style = styles.get(side);
        Color color = colors.get(side);

        return (width == null && style == null && color == null) || (width != null && style != null && color != null);
    }

    /**
     * @version 2013/07/22 14:12:03
     */
    private static enum Side {
        Top("top-left"), Right("top-right"), Bottom("bottom-right"), Left("bottom-left");

        /** The radius corner name. */
        private final String radius;

        /**
         * @param radius
         */
        private Side(String radius) {
            this.radius = radius;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }

    /**
     * @version 2013/07/23 13:24:38
     */
    private class Single extends Border {

        /** The target side. */
        private final Side side;

        /**
         * @param side
         */
        public Single(Side side) {
            this.side = side;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Border radius(Numeric size) {
            switch (side) {
            case Top:
                radius.put(Side.Top, size);
                radius.put(Side.Right, size);
                break;

            case Right:
                radius.put(Side.Right, size);
                radius.put(Side.Bottom, size);
                break;

            case Bottom:
                radius.put(Side.Bottom, size);
                radius.put(Side.Left, size);
                break;

            case Left:
                radius.put(Side.Left, size);
                radius.put(Side.Top, size);
                break;
            }

            Borders.this.chain();

            return chain();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Numeric width() {
            Numeric value = widths.get(side);

            return value == null ? Numeric.Zero : value;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Border width(Numeric size) {
            widths.put(side, size);

            Borders.this.chain();

            return chain();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Color color() {
            return colors.get(side);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Border color(Color color) {
            colors.put(side, color);

            Borders.this.chain();

            return chain();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public BorderStyle style() {
            return styles.get(side);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected Border style(BorderStyle style) {
            styles.put(side, style);

            Borders.this.chain();

            return chain();
        }
    }
}