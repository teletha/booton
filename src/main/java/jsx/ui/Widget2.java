/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import jsx.style.StyleDSL;

/**
 * @version 2016/04/07 17:40:28
 */
public abstract class Widget2<Styles extends StyleDSL, First, Second> extends Widget<Styles> {

    /** The first model associated with this {@link Widget}. */
    protected final First model1;

    /** The second model associated with this {@link Widget}. */
    protected final Second model2;

    /**
     * <p>
     * Visible for sub-class.
     * </p>
     */
    protected Widget2() {
        this.model1 = (First) loophole[0];
        this.model2 = (Second) loophole[1];
    }
}
