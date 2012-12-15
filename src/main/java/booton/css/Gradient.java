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

import booton.util.RGB;

/**
 * @version 2012/12/15 0:52:37
 */
public class Gradient {

    private RGB start;

    private RGB end;

    /**
     * @param start
     * @param end
     */
    public Gradient(RGB start, RGB end) {
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
