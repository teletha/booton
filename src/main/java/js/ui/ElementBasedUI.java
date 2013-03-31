/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui;

import static js.lang.Global.*;
import js.dom.Element;

/**
 * @version 2013/03/31 21:47:21
 */
public class ElementBasedUI {

    /** The root container element for this user interface. */
    public final Element root;

    /**
     * <p>
     * Create UI with div element.
     * </p>
     */
    protected ElementBasedUI() {
        this("span");
    }

    /**
     * <p>
     * Create UI with specified root element.
     * </p>
     * 
     * @param name
     */
    protected ElementBasedUI(String name) {
        this.root = document.createElement(name);
    }
}
