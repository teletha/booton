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
 * @version 2012/12/11 21:26:30
 */
public abstract class CSSLength extends CSSValue {

    /**
     * @param css
     */
    protected CSSLength(CSS css) {
        super(css);
    }

    /**
     * <p>
     * Specify size.
     * </p>
     * 
     * @param size
     * @param unit
     */
    public void size(double size, Unit unit) {
        value = compute(size, unit);
    }
}
