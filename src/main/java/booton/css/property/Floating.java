/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.property;

import booton.css.CSSProperty;

/**
 * @version 2012/12/13 18:50:02
 */
public class Floating extends CSSProperty<Floating> {

    /**
     * 
     */
    public Floating() {
        super("float");
    }

    /**
     * <p>
     * Is a keyword indicating that the element must float on the left side of its containing block.
     * </p>
     * 
     * @return Chainable API.
     */
    public Floating left() {
        return chain("left");

    }

    /**
     * <p>
     * Is a keyword indicating that the element must float on the right side of its containing
     * block.
     * </p>
     * 
     * @return Chainable API.
     */
    public Floating right() {
        return chain("right");
    }

    /**
     * <p>
     * Is a keyword indicating that the element must not float.
     * </p>
     * 
     * @return Chainable API.
     */
    public Floating none() {
        return chain("none");
    }
}
