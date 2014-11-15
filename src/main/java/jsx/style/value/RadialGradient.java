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

import static jsx.style.value.Vendor.*;

/**
 * @version 2014/10/28 20:37:35
 */
public class RadialGradient extends LinearGradient<RadialGradient> {

    /** The center position. */
    private Position position;

    /**
     * <p>
     * A <position>, interpreted in the same way as background-position or transform-origin. If
     * omitted, the default is center.
     * </p>
     * 
     * @param position A center position.
     * @return Chainable API.
     */
    public RadialGradient position(Position position) {
        this.position = position;

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String valueFor(Vendor vendor) {
        StringBuilder builder = new StringBuilder();
        if (repeatable) {
            builder.append("repeating-");
        }
        builder.append("radial-gradient(");

        if (position != null) {
            if (vendor == Standard) {
                builder.append("at ");
            }
            builder.append(position).append(",");
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
}
