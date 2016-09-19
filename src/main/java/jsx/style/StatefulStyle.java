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
import jsx.ui.flux.Location;

/**
 * @version 2015/11/26 10:45:29
 */
public class StatefulStyle<T> extends SimpleObjectProperty<T>implements Location<T>, Declarable {

    private final ValueStyle<T> style;

    /**
     * @param style
     */
    private StatefulStyle(ValueStyle<T> style) {
        this.style = style;
    }

    public static <T> StatefulStyle<T> of(ValueStyle<T> style) {
        return new StatefulStyle(style);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void declare() {
        style.style(get());
    }
}
