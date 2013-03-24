/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

import js.util.Color;

/**
 * @version 2013/03/24 13:09:14
 */
public class GradientValue {

    /** The start color. */
    public final Color start;

    /** The end color. */
    public final Color end;

    /**
     * @param start
     * @param end
     */
    public GradientValue(Color start, Color end) {
        this.start = start;
        this.end = end;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "linear-gradient(" + start + "," + end + ")";
    }
}
