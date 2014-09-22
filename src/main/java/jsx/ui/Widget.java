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
import kiss.Manageable;

/**
 * @version 2014/08/21 13:31:25
 */
@Manageable(lifestyle = VirtualStructureHierarchy.class)
public abstract class Widget<M> {

    static {
        I.load(Widget.class, true);
    }

    /** The associated model. */
    protected final M model;

    /** The current associated virtual element. */
    private VirtualNode current;

    /**
     * <p>
     * This constructor is dirty.
     * </p>
     */
    protected Widget() {
        this((M) loophole);
    }

    /**
     * <p>
     * This constructor is dirty.
     * </p>
     */
    protected Widget(M model) {
        this.model = model;
    }

    /**
     * 
     */
    protected void initialize() {

    }

    /**
     * <p>
     * Assemble the virtual structure for this {@link Widget}.
     * </p>
     * 
     * @param structure A current processing structure which has the parent container.
     */
    final void assemble(VirtualStructure structure) {
        Class clazz = getClass();

        /**
         * <p>
         * Enter the hierarchy of {@link VirtualStructure}.
         * </p>
         */
        Widget previous = VirtualStructureHierarchy.hierarchy.putIfAbsent(clazz, this);

        if (previous == null) {
            throw new IllegalStateException(clazz + " is a nest in virtual structure.");
        }

        /**
         * Assemble {@link VirtualStructure} actually.
         */
        virtualize(structure);

        /**
         * <p>
         * Leave the hierarchy of {@link VirtualStructure}.
         * </p>
         */
        VirtualStructureHierarchy.hierarchy.remove(clazz);
    }

    /**
     * <p>
     * Create virtual elements of this {@link Widget}.
     * </p>
     * 
     * @param $〡 Domain Specific Language for virtual elements.
     */
    protected abstract void virtualize(VirtualStructure $〡);

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
    static final <W extends Widget<V>, V> W cheatConstruction(Class<? extends Widget<V>> widgetType, V model) {
        Widget<V> widget;

        loophole = model;
        widget = I.make(widgetType);
        loophole = null;

        return (W) widget;
    }
}
