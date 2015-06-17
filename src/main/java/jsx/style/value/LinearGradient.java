/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.value;

import static jsx.style.Vendor.*;
import static jsx.style.value.Unit.*;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import jsx.style.CSSValue;
import jsx.style.Vendor;

/**
 * @version 2014/10/28 20:36:39
 */
public class LinearGradient<T extends LinearGradient> extends CSSValue {

    /** The angle of direction for the gradient. */
    protected Numeric angle;

    /** The color steps. */
    protected List<Step> steps = new ArrayList();

    /** The flag for repeat. */
    protected boolean repeatable = false;

    /**
     * <p>
     * An angle of direction for the gradient.
     * </p>
     * 
     * @param size An angle of direction for the gradient.
     * @param unit An angle unit of direction for the gradient.
     * @return Chainable API.
     */
    public T angle(double size, Unit unit) {
        return angle(new Numeric(size, unit));
    }

    /**
     * <p>
     * An angle of direction for the gradient.
     * </p>
     * 
     * @param angle An angle of direction for the gradient.
     * @return Chainable API.
     */
    public T angle(Numeric angle) {
        this.angle = angle;

        return (T) this;
    }

    /**
     * <p>
     * This value is comprised of a <color> value, followed by an optional stop position (either a
     * percentage or a <length> along the gradient axis). Rendering of color-stops in CSS gradients
     * follows the same rules as color-stops in SVG gradients.
     * </p>
     * 
     * @param color A color.
     * @return Chainable API.
     */
    public T color(Color... colors) {
        for (Color color : colors) {
            color(color, null);
        }
        return (T) this;
    }

    /**
     * <p>
     * This value is comprised of a <color> value, followed by an optional stop position (either a
     * percentage or a <length> along the gradient axis). Rendering of color-stops in CSS gradients
     * follows the same rules as color-stops in SVG gradients.
     * </p>
     * 
     * @param color A color.
     * @param percentage A percentage of length.
     * @return Chainable API.
     */
    public T color(Color color, int percentage) {
        return color(color, new Numeric(percentage, percent));
    }

    /**
     * <p>
     * This value is comprised of a <color> value, followed by an optional stop position (either a
     * percentage or a <length> along the gradient axis). Rendering of color-stops in CSS gradients
     * follows the same rules as color-stops in SVG gradients.
     * </p>
     * 
     * @param color A color.
     * @param length A length.
     * @return Chainable API.
     */
    public T color(Color color, Numeric length) {
        steps.add(new Step(color, length));

        return (T) this;
    }

    /**
     * <p>
     * Make this gradient image repeatable.
     * </p>
     * 
     * @return Chainable API.
     */
    public T repeat() {
        this.repeatable = true;

        return (T) this;
    }

    /**
     * <p>
     * Compute the start color of this {@link LinearGradient}.
     * </p>
     * 
     * @return
     */
    public Color getStartColor() {
        if (steps.size() == 0) {
            return null;
        }
        return steps.get(0).color;
    }

    /**
     * <p>
     * Compute the end color of this {@link LinearGradient}.
     * </p>
     * 
     * @return
     */
    public Color getEndColor() {
        if (steps.size() == 0) {
            return null;
        }
        return steps.get(steps.size() - 1).color;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EnumSet<Vendor> vendors() {
        return EnumSet.of(Standard, Webkit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String valueFor(Vendor vendor) {
        Numeric baseAngle = new Numeric(vendor == Standard ? 0 : 270, deg);

        StringBuilder builder = new StringBuilder();
        if (repeatable) {
            builder.append("repeating-");
        }
        builder.append("linear-gradient(");
        if (angle != null && angle.size != 0) {
            builder.append(baseAngle.add(angle).valueFor(vendor)).append(",");
        }
        for (int i = 0; i < steps.size(); i++) {
            Step step = steps.get(i);
            builder.append(step.color);

            if (step.length != null) {
                builder.append(" ").append(step.length.valueFor(vendor));
            }

            if (i + 1 < steps.size()) {
                builder.append(",");
            }
        }
        builder.append(")");

        switch (vendor) {
        case Webkit:
            return vendor + builder.toString();

        default:
            return builder.toString();
        }
    }

    /**
     * @version 2014/10/28 20:36:51
     */
    protected static class Step {

        /** The color. */
        protected final Color color;

        /** The length. */
        protected final Numeric length;

        /**
         * @param color A color.
         * @param length A length.
         */
        private Step(Color color, Numeric length) {
            this.color = color;
            this.length = length;
        }
    }
}
