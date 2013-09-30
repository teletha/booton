/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt.widget;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import kiss.Disposable;

/**
 * @version 2013/06/29 1:33:54
 */
public abstract class Widget implements Disposable {

    /** The manageable child widgets. */
    private final List<Widget> children = new CopyOnWriteArrayList();

    /**
     * <p>
     * Initialization phase.
     * </p>
     */
    protected Widget() {
    }

    /**
     * <p>
     * Appedn child {@link Widget}.
     * </p>
     * 
     * @param child
     * @return
     */
    public Widget append(Widget child) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void dispose() {
        for (Widget child : children) {
            child.dispose();
        }
    }
}
