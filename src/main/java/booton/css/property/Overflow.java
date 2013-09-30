/*
 * Copyright (C) 2013 Nameless Production Committee
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
 * @version 2013/07/24 13:43:52
 */
public class Overflow<T extends Overflow> extends CSSProperty<T> {

    /**
     * <p>
     * Create property.
     * </p>
     * 
     * @param name A property name.
     */
    protected Overflow(String name) {
        super(name);
    }

    /**
     * <p>
     * Create property.
     * </p>
     * 
     * @param name A property name.
     * @param context A context object for chainable API.
     */
    protected Overflow(String name, T context) {
        super(name, context);
    }

    /**
     * <p>
     * Default value. Content is not clipped, it may be rendered outside the content box.
     * </p>
     * 
     * @return
     */
    public T visible() {
        return chain("visible");
    }

    /**
     * <p>
     * The content is clipped and no scrollbars are provided.
     * </p>
     * 
     * @return
     */
    public T hidden() {
        return chain("hidden");
    }

    /**
     * <p>
     * The content is clipped and desktop browsers use scrollbars, whether or not any content is
     * clipped. This avoids any problem with scrollbars appearing and disappearing in a dynamic
     * environment. Printers may print overflowing content.
     * </p>
     * 
     * @return
     */
    public T scroll() {
        return chain("scroll");
    }

    /**
     * <p>
     * Depends on the user agent. Desktop browsers like Firefox provide scrollbars if content
     * overflows.
     * </p>
     * 
     * @return
     */
    public T auto() {
        return chain("auto");
    }
}
