/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import jsx.style.StyleDescriptor;

/**
 * @version 2016/04/07 17:40:24
 */
public abstract class Widget3<Styles extends StyleDescriptor, First, Second, Third> extends Widget<Styles> {

    /** The first model associated with this {@link Widget}. */
    protected final First model1;

    /** The second model associated with this {@link Widget}. */
    protected final Second model2;

    /** The third model associated with this {@link Widget}. */
    protected final Third model3;

    /**
     * <p>
     * Visible for sub-class.
     * </p>
     */
    protected Widget3() {
        this.model1 = (First) loophole[0];
        this.model2 = (Second) loophole[1];
        this.model3 = (Third) loophole[2];
    }
}
