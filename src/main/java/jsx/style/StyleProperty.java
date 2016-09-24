/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import javafx.beans.property.SimpleObjectProperty;

import jsx.ui.Declarable;
import jsx.ui.VirtualElement;
import jsx.ui.flux.Location;

/**
 * @version 2016/09/24 11:23:47
 */
public class StyleProperty extends SimpleObjectProperty<Style> implements Declarable, Location {

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        Style style = get();
        return style != null ? style.name() : "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] names() {
        Style style = get();
        return style != null ? style.names() : new String[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void declare() {
        Style style = get();

        if (style != null) {
            style.declare();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void declare(VirtualElement element) {
        Style style = get();

        if (style != null) {
            style.declare(element);
        }
    }
}
