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

import booton.css.value.Color;
import booton.css.value.Value;

/**
 * @version 2013/07/22 12:47:45
 */
public class Borders extends BorderDescriptorSet {

    private final EnumMap<Side, BorderStyle> styles = new EnumMap(Side.class);

    private final EnumMap<Side, Value> widths = new EnumMap(Side.class);

    private final EnumMap<Side, Color> colors = new EnumMap(Side.class);

    /**
     * <p>
     * The border-top CSS property is a shorthand that sets the values of border-top-color,
     * border-top-style, and border-top-width. These properties describe the top border of elements.
     * </p>
     */
    public final BorderDescriptor top = new Definition(Side.Top);

    /**
     * <p>
     * The border-bottom CSS property is a shorthand that sets the values of border-bottom-color,
     * border-bottom-style, and border-bottom-width. These properties describe the bottom border of
     * elements.
     * </p>
     */
    public final BorderDescriptor bottom = new Definition(Side.Bottom);

    /**
     * <p>
     * The border-left CSS property is a shorthand that sets the values of border-left-color,
     * border-left-style, and border-left-width. These properties describe the left border of
     * elements.
     * </p>
     */
    public final BorderDescriptor left = new Definition(Side.Left);

    /**
     * <p>
     * The border-right CSS property is a shorthand that sets the values of border-right-color,
     * border-right-style, and border-right-width. These properties describe the right border of
     * elements.
     * </p>
     */
    public final BorderDescriptor right = new Definition(Side.Right);

    public final BorderDescriptor horizontal = new BorderDescriptorSet().add(left, right);

    public final BorderDescriptor vertical = new BorderDescriptorSet().add(top, bottom);

    /**
     * 
     */
    public Borders() {
        add(top, right, bottom, left);
    }

    // /**
    // * @param topAndBotomSize
    // * @param topAndBotomUnit
    // * @param leftAndRightSize
    // * @param leftAndRightUnit
    // * @return
    // */
    // public Borders width(double topAndBotomSize, Unit topAndBotomUnit, double leftAndRightSize,
    // Unit leftAndRightUnit) {
    // return width(new Value(topAndBotomSize, topAndBotomUnit), new Value(leftAndRightSize,
    // leftAndRightUnit));
    // }
    //
    // /**
    // * @param topAndBotom
    // * @param leftAndRight
    // * @return
    // */
    // public Borders width(Value topAndBotom, Value leftAndRight) {
    // return width(topAndBotom, leftAndRight, topAndBotom, leftAndRight);
    // }
    //
    // /**
    // * @param topSize
    // * @param topUnit
    // * @param leftAndRightSize
    // * @param leftAndRightUnit
    // * @param bottomSize
    // * @param bottomUnit
    // * @return
    // */
    // public Borders width(double topSize, Unit topUnit, double leftAndRightSize, Unit
    // leftAndRightUnit, double bottomSize, Unit bottomUnit) {
    // return width(new Value(topSize, topUnit), new Value(leftAndRightSize, leftAndRightUnit), new
    // Value(bottomSize, bottomUnit), new Value(leftAndRightSize, leftAndRightUnit));
    // }
    //
    // /**
    // * @param top
    // * @param leftAndRight
    // * @param bottom
    // * @return
    // */
    // public Borders width(Value top, Value leftAndRight, Value bottom) {
    // return width(top, leftAndRight, bottom, leftAndRight);
    // }
    //
    // /**
    // * @param topSize
    // * @param topUnit
    // * @param rightSize
    // * @param rightUnit
    // * @param bottomSize
    // * @param bottomUnit
    // * @param leftSize
    // * @param leftUnit
    // * @return
    // */
    // public Borders width(double topSize, Unit topUnit, double rightSize, Unit rightUnit, double
    // bottomSize, Unit bottomUnit, double leftSize, Unit leftUnit) {
    // return width(new Value(topSize, topUnit), new Value(rightSize, rightUnit), new
    // Value(bottomSize, bottomUnit), new Value(leftSize, leftUnit));
    // }
    //
    // /**
    // * @param top
    // * @param right
    // * @param bottom
    // * @param left
    // * @return
    // */
    // public Borders width(Value top, Value right, Value bottom, Value left) {
    // widths.put(Side.Top, top);
    // widths.put(Side.Right, right);
    // widths.put(Side.Bottom, bottom);
    // widths.put(Side.Left, left);
    //
    // return chain();
    // }

    /**
     * @version 2013/07/22 14:12:03
     */
    private static enum Side {
        Top, Bottom, Left, Right;
    }

    /**
     * @version 2013/07/22 12:46:33
     */
    private class Definition extends BorderDescriptor<Definition> {

        /** The target side. */
        private final Side side;

        /**
         * @param side
         */
        public Definition(Side side) {
            this.side = side;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Value width() {
            return widths.get(side);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Definition width(Value size) {
            widths.put(side, size);

            chain();

            return this;
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
        public Definition color(Color color) {
            colors.put(side, color);

            chain();

            return this;
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
        protected Definition style(BorderStyle style) {
            styles.put(side, style);

            chain();

            return this;
        }
    }
}
