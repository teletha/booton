/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import kiss.I;

/**
 * @version 2014/08/21 13:31:25
 */
public abstract class Widget<V> {

    /** The associated model. */
    protected final V model;

    /** The current associated virtual element. */
    private VirtualNode current;

    /**
     * <p>
     * This constructor is dirty.
     * </p>
     */
    protected Widget() {
        this.model = (V) loophole;
    }

    /**
     * <p>
     * Create virtual element.
     * </p>
     * 
     * @param $〡 Domain Specific Language for virtual element.
     */
    protected abstract void virtualize(StructureDSL $〡);

    /** The model loophole. */
    private static Object loophole;

    /**
     * <p>
     * Create widget which is associated with the specified model.
     * </p>
     * 
     * @param widgetType A widget type.
     * @param model An associated model.
     * @return A new created widget.
     */
    static final <W extends Widget<V>, V> W create(Class<? extends Widget<V>> widgetType, V model) {
        Widget<V> widget;

        loophole = model;
        widget = I.make(widgetType);
        loophole = null;

        return (W) widget;
    }
}
