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

import js.dom.UIEvent;
import jsx.ui.Declarable;
import jsx.ui.VirtualElement;
import jsx.ui.flux.Location;

/**
 * @version 2015/10/05 2:11:42
 */
public interface Style extends Declarable, Location<UIEvent> {

    /**
     * <p>
     * Define the style declaration.
     * </p>
     */
    void style();

    /**
     * {@inheritDoc}
     */
    @Override
    default void declare() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void declare(VirtualElement element) {
        element.classList.push(this);
    }

    /**
     * <p>
     * Combine this {@link Style} and the specified {@link Style}.
     * </p>
     * 
     * @param style A style to combine.
     * @return A combined {@link Style}.
     */
    default Style with(Style style) {
        return MultipleStyle.of(this, style);
    }
}
