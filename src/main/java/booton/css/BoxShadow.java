/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

/**
 * @version 2012/12/12 14:34:01
 */
public class BoxShadow extends Color<BoxShadow> {

    private boolean inset = false;

    private String offsetX;

    private String offsetY;

    private String blurRadius;

    private String spreadRadius;

    /**
     * <p>
     * If not specified (default), the shadow is assumed to be a drop shadow (as if the box were
     * raised above the content). The presence of the inset keyword changes the shadow to one inside
     * the frame (as if the content was depressed inside the box). Inset shadows are drawn inside
     * the border (even transparent ones), above the background, but below content.
     * </p>
     * 
     * @return
     */
    public BoxShadow inset() {
        inset = true;

        return chain();
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
     * @param unitX
     * @param offsetY
     * @param unitY
     */
    public BoxShadow offset(double offsetX, Unit unitX, double offsetY, Unit unitY) {
        this.offsetX = compute(offsetX, unitX);
        this.offsetY = compute(offsetY, unitY);

        return chain();
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
    public BoxShadow blurRadius(double size, Unit unit) {
        this.blurRadius = compute(size, unit);

        return chain();
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
    public BoxShadow spreadRadius(double size, Unit unit) {
        this.spreadRadius = compute(size, unit);

        return chain();
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
        if (blurRadius != null) builder.append(blurRadius).append(" ");
        if (spreadRadius != null) builder.append(spreadRadius).append(" ");
        if (color != null) builder.append(color);

        return property("box-shadow", builder.toString());
    }
}
