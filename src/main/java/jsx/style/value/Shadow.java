/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.value;


/**
 * @version 2014/10/28 18:40:17
 */
public final class Shadow {

    /** The shadow property. */
    private boolean inset = false;

    /** The shadow property. */
    private Numeric offsetX;

    /** The shadow property. */
    private Numeric offsetY;

    /** The shadow property. */
    private Numeric blur;

    /** The shadow property. */
    private Numeric spread;

    /** The color property. */
    private Color color;

    /**
     * <p>
     * The presence of the inset keyword changes the shadow to one inside the frame (as if the
     * content was depressed inside the box). Inset shadows are drawn inside the border (even
     * transparent ones), above the background, but below content.
     * </p>
     * 
     * @return
     */
    public Shadow inset() {
        inset = true;

        return this;
    }

    /**
     * <p>
     * These are two <length> values to set the shadow offset. <offset-x> specifies the horizontal
     * distance. Negative values place the shadow to the left of the element. <offset-y> specifies
     * the vertical distance. Negative values place the shadow above the element. See <length> for
     * possible units. If both values are 0, the shadow is placed behind the element (and may
     * generate a blur effect if <blur-radius> and/or <spread-radius> is set).
     * </p>
     * 
     * @param offsetX
     * @param offsetY
     * @param unit
     * @return
     */
    public Shadow offset(int offsetX, int offsetY, Unit unit) {
        return offsetX(offsetX, unit).offsetY(offsetY, unit);
    }

    /**
     * <p>
     * These are two <length> values to set the shadow offset. <offset-x> specifies the horizontal
     * distance. Negative values place the shadow to the left of the element. <offset-y> specifies
     * the vertical distance. Negative values place the shadow above the element. See <length> for
     * possible units. If both values are 0, the shadow is placed behind the element (and may
     * generate a blur effect if <blur-radius> and/or <spread-radius> is set).
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Shadow offsetX(double size, Unit unit) {
        return offsetX(new Numeric(size, unit));
    }

    /**
     * <p>
     * These are two <length> values to set the shadow offset. <offset-x> specifies the horizontal
     * distance. Negative values place the shadow to the left of the element. <offset-y> specifies
     * the vertical distance. Negative values place the shadow above the element. See <length> for
     * possible units. If both values are 0, the shadow is placed behind the element (and may
     * generate a blur effect if <blur-radius> and/or <spread-radius> is set).
     * </p>
     * 
     * @param size
     * @return
     */
    public Shadow offsetX(Numeric size) {
        offsetX = size;

        return this;
    }

    /**
     * <p>
     * These are two <length> values to set the shadow offset. <offset-x> specifies the horizontal
     * distance. Negative values place the shadow to the left of the element. <offset-y> specifies
     * the vertical distance. Negative values place the shadow above the element. See <length> for
     * possible units. If both values are 0, the shadow is placed behind the element (and may
     * generate a blur effect if <blur-radius> and/or <spread-radius> is set).
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Shadow offsetY(double size, Unit unit) {
        return offsetY(new Numeric(size, unit));
    }

    /**
     * <p>
     * These are two <length> values to set the shadow offset. <offset-x> specifies the horizontal
     * distance. Negative values place the shadow to the left of the element. <offset-y> specifies
     * the vertical distance. Negative values place the shadow above the element. See <length> for
     * possible units. If both values are 0, the shadow is placed behind the element (and may
     * generate a blur effect if <blur-radius> and/or <spread-radius> is set).
     * </p>
     * 
     * @param size
     * @return
     */
    public Shadow offsetY(Numeric size) {
        offsetY = size;

        return this;
    }

    /**
     * <p>
     * This is a third <length> value. The larger this value, the bigger the blur, so the shadow
     * becomes bigger and lighter. Negative values are not allowed. If not specified, it will be 0
     * (the shadow's edge is sharp).
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Shadow blurRadius(double size, Unit unit) {
        return blurRadius(new Numeric(size, unit));
    }

    /**
     * <p>
     * This is a third <length> value. The larger this value, the bigger the blur, so the shadow
     * becomes bigger and lighter. Negative values are not allowed. If not specified, it will be 0
     * (the shadow's edge is sharp).
     * </p>
     * 
     * @param size
     * @return
     */
    public Shadow blurRadius(Numeric size) {
        blur = size;

        return this;
    }

    /**
     * <p>
     * This is a fourth <length> value. Positive values will cause the shadow to expand and grow
     * bigger, negative values will cause the shadow to shrink. If not specified, it will be 0 (the
     * shadow will be the same size as the element).
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Shadow spreadRadius(double size, Unit unit) {
        return spreadRadius(new Numeric(size, unit));
    }

    /**
     * <p>
     * This is a fourth <length> value. Positive values will cause the shadow to expand and grow
     * bigger, negative values will cause the shadow to shrink. If not specified, it will be 0 (the
     * shadow will be the same size as the element).
     * </p>
     * 
     * @param size
     * @return
     */
    public Shadow spreadRadius(Numeric size) {
        spread = size;

        return this;
    }

    /**
     * <p>
     * See <color> values for possible keywords and notations. If not specified, the color used
     * depends on the browser - it is usually the value of the color property, but note that Safari
     * currently paints a transparent shadow in this case.
     * </p>
     * 
     * @param color
     * @return
     */
    public Shadow color(Color color) {
        this.color = color;

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (inset) builder.append("inset ");
        if (offsetX != null) builder.append(offsetX).append(" ");
        if (offsetY != null) builder.append(offsetY).append(" ");
        if (blur != null) builder.append(blur).append(" ");
        if (spread != null) builder.append(spread).append(" ");
        if (color != null) builder.append(color);

        return builder.toString().trim();
    }
}