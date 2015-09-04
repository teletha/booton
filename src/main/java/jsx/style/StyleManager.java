/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 2015/09/04 23:37:15
 */
class StyleManager {

    /** The managed style list. */
    private static final List<Style> styles = new ArrayList();

    /**
     * <p>
     * Define the specified {@link Style}.
     * </p>
     * 
     * @param style
     */
    static void add(Style style) {
        if (style != null && !styles.contains(style)) {

        }
    }

    /**
     * <p>
     * Remove the specified {@link Style}.
     * </p>
     * 
     * @param style
     */
    static void remove(Style style) {
        if (style != null) {

        }
    }
}
