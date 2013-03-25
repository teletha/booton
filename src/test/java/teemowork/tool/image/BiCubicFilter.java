/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.tool.image;

/**
 * @version 2013/03/25 14:00:55
 */
public class BiCubicFilter implements ResampleFilter {

    final protected float a;

    public BiCubicFilter() {
        a = -0.5f;
    }

    protected BiCubicFilter(float a) {
        this.a = a;
    }

    public final float apply(float value) {
        if (value == 0) return 1.0f;
        if (value < 0.0f) value = -value;
        float vv = value * value;
        if (value < 1.0f) {
            return (a + 2f) * vv * value - (a + 3f) * vv + 1f;
        }
        if (value < 2.0f) {
            return a * vv * value - 5 * a * vv + 8 * a * value - 4 * a;
        }
        return 0.0f;
    }

    public float getSamplingRadius() {
        return 2.0f;
    }

    public String getName() {
        return "BiCubic"; // also called cardinal cubic spline
    }

}
