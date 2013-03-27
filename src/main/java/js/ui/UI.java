/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui;

import static js.lang.Global.*;
import js.util.jQuery;

/**
 * @version 2012/12/11 14:39:54
 */
public abstract class UI {

    /** The root container element for this user interface. */
    public final jQuery root;

    /**
     * <p>
     * Create UI with div element.
     * </p>
     */
    protected UI() {
        this("div");
    }

    /**
     * <p>
     * Create UI with specified root element.
     * </p>
     * 
     * @param name
     */
    protected UI(String name) {
        this.root = $("<" + name + ">");
    }
}
