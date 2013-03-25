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
 * @version 2013/03/25 14:25:11
 */
public class BSplineFilter implements ResampleFilter {

    public float getSamplingRadius() {
        return 2.0f;
    }

    public final float apply(float value) {
        if (value < 0.0f) {
            value = -value;
        }
        if (value < 1.0f) {
            float tt = value * value;
            return 0.5f * tt * value - tt + (2.0f / 3.0f);
        } else if (value < 2.0f) {
            value = 2.0f - value;
            return (1.0f / 6.0f) * value * value * value;
        } else {
            return 0.0f;
        }
    }

    public String getName() {
        return "BSpline";
    }

}
