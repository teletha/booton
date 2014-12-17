/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import js.dom.Element;

/**
 * @version 2014/12/17 13:06:39
 */
public class MultipleStyle implements Style {

    /** The base style. */
    private final Style base;

    /** The runtime declared style. */
    private final Style dynamic;

    /**
     * @param base
     * @param dynamic
     */
    public MultipleStyle(Style base, Style dynamic) {
        this.base = base;
        this.dynamic = dynamic;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void declare() {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyTo(Element dom) {
        base.applyTo(dom);
        dynamic.applyTo(dom);
    }
}
