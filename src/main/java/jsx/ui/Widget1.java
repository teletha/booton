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

/**
 * @version 2014/08/21 13:31:25
 */
public abstract class Widget1<First> extends Widget {

    /** The first model associated with this {@link Widget}. */
    protected final First model1;

    /**
     * <p>
     * Visible for sub-class.
     * </p>
     */
    protected Widget1() {
        this.model1 = (First) loophole[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize2() {
    }
}
