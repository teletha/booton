/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.style;

import js.dom.Element;
import jsx.style.Style;

/**
 * @version 2014/12/13 15:08:55
 */
public class DynamicStyle implements RuntimeStyle, Style {

    /** The base style. */
    private final RuntimeStyle base;

    /** The runtime declared style. */
    private final Style dynamic;

    /**
     * @param base
     * @param dynamic
     */
    private DynamicStyle(RuntimeStyle base, Style dynamic) {
        this.base = base;
        this.dynamic = dynamic;
    }

    /**
     * @param base
     * @param dynamic
     */
    public DynamicStyle(Style base, Style dynamic) {
        this.base = new CompiledStyle(base);
        this.dynamic = dynamic;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void apply(Element dom) {
        base.apply(dom);
        dom.style(dynamic);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void declare() {
    }
}
