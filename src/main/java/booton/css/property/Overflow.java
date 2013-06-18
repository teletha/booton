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
 * @version 2012/12/26 21:46:01
 */
public class Overflow extends CSSProperty<Overflow> {

    /**
     * @param name
     */
    public Overflow(String name) {
        super(name);
    }

    /**
     * <p>
     * Default value. Content is not clipped, it may be rendered outside the content box.
     * </p>
     * 
     * @return
     */
    public Overflow visible() {
        return chain("visible");
    }

    /**
     * <p>
     * The content is clipped and no scrollbars are provided.
     * </p>
     * 
     * @return
     */
    public Overflow hidden() {
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
    public Overflow scroll() {
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
    public Overflow auto() {
        return chain("auto");
    }
}
