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
 * @version 2012/12/11 16:23:56
 */
public final class Width extends CSSLength {

    /**
     * @param css
     */
    Width(CSS css) {
        super(css);
    }

    /**
     * The browser will calculate and select a width for the specified element.
     */
    public void auto() {
        value = "auto";
    }

    /**
     * The intrinsic preferred width.
     */
    public void max_content() {
        value = "max-content";
    }

    /**
     * The intrinsic minimum width.
     */
    public void min_content() {
        value = "min-content";
    }

    /**
     * <p>
     * The larger of:
     * </p>
     * <ul>
     * <li>the intrinsic minimum width</li>
     * <li>the smaller of the intrinsic preferred width and the available width</li>
     * </ul>
     */
    public void fit_content() {
        value = "fit-content";
    }

    /**
     * The containing block width minus horizontal margin, border and padding
     */
    public void available() {
        value = "available";
    }
}
