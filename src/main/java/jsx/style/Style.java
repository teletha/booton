/*
 * Copyright (C) 2015 Nameless Production Committee
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
import jsx.ui.Locatable;

/**
 * @version 2015/09/19 14:37:52
 */
public interface Style extends Declarable, Locatable<UIEvent> {

    /**
     * <p>
     * Define the style declaration.
     * </p>
     */
    void style();

    /**
     * <p>
     * Compute style class name.
     * </p>
     * 
     * @return A style class name.
     * @deprecated This method is internal API. Use {@link StyleName#of(Style)} instead.
     */
    @Deprecated
    public default String className() {
        return "STYLE" + hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void declare() {
        StyleRepository.register(this);
    }
}
