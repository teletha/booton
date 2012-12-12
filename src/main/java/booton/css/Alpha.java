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
 * @version 2012/12/12 14:30:33
 */
public class Alpha extends CSSProperty<Alpha> {

    /**
     * 
     */
    public Alpha() {
        super();
    }

    /**
     * @param name
     * @param context
     */
    public Alpha(String name, Alpha context) {
        super(name, context);
    }

    /**
     * @param name
     */
    public Alpha(String name) {
        super(name);
    }

    /**
     * <p>
     * Is a <number> in the range 0.0 to 1.0, both included, representing the opacity of the
     * channel, that is the value of its alpha channel. Any value outside the interval, though
     * valid, is clamped to the nearest limit in the range.
     * </p>
     * 
     * @param value
     * @return
     */
    public Alpha alpha(double value) {
        return chain(String.valueOf(value));
    }
}
