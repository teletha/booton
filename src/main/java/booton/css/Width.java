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
 * @version 2012/12/12 10:32:31
 */
public final class Width extends Length<Width> {

    /**
     * The intrinsic preferred width.
     */
    public Width max_content() {
        return chain("max-content");
    }

    /**
     * The intrinsic minimum width.
     */
    public Width min_content() {
        return chain("min-content");
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
    public Width fit_content() {
        return chain("fit-content");
    }

    /**
     * The containing block width minus horizontal margin, border and padding
     */
    public Width available() {
        return chain("available");
    }
}
