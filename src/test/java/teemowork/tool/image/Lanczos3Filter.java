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
 * @version 2013/03/25 14:05:24
 */
public class Lanczos3Filter implements ResampleFilter {

    private final static float PI_FLOAT = (float) Math.PI;

    private float sincModified(float value) {
        return ((float) Math.sin(value)) / value;
    }

    public final float apply(float value) {
        if (value == 0) {
            return 1.0f;
        }
        if (value < 0.0f) {
            value = -value;
        }

        if (value < 3.0f) {
            value *= PI_FLOAT;
            return sincModified(value) * sincModified(value / 3.0f);
        } else {
            return 0.0f;
        }
    }

    public float getSamplingRadius() {
        return 3.0f;
    }

    public String getName() {
        return "Lanczos3";
    }

}
