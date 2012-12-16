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
 * @version 2012/12/12 10:19:47
 */
public class CSSLengthValue<T extends CSSProperty> extends CSSProperty<T> {

    /**
     * 
     */
    public CSSLengthValue() {
        this(null);
    }

    /**
     * @param name
     */
    public CSSLengthValue(String name) {
        super(name);
    }

    /**
     * @param name
     */
    public CSSLengthValue(String name, T context) {
        super(name, context);
    }

    /**
     * <p>
     * Specify size.
     * </p>
     * 
     * @param size
     * @param unit
     */
    public T size(double size, Unit unit) {
        return chain(compute(size, unit));
    }

    /**
     * The browser will calculate and select a length for the specified element.
     */
    public T auto() {
        return chain("auto");
    }
}
