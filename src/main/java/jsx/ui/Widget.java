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

import java.util.Objects;

import kiss.I;
import kiss.Manageable;

/**
 * @version 2014/08/21 13:31:25
 */
@Manageable(lifestyle = VirtualStructureHierarchy.class)
public abstract class Widget {

    static {
        I.load(Widget.class, true);
    }

    /** The model loophole to CHEAT. */
    static Object[] loophole;

    /** The identifier of this {@link Widget}. */
    int id = loophole == null ? hashCode() : Objects.hash(loophole);

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

        if (previous != null) {
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

    /**
     * <p>
     * Create widget which is associated with the specified models.
     * </p>
     * 
     * @param widgetType A widget type.
     * @param model1 An associated model.
     * @return A widget with the specified models.
     */
    public static final <W extends Widget1<First>, First> W of(Class<W> widgetType, First model1) {
        return create(widgetType, new Object[] {model1});
    }

    /**
     * <p>
     * Create widget which is associated with the specified models.
     * </p>
     * 
     * @param widgetType A widget type.
     * @param model1 An associated model.
     * @param model2 An associated model.
     * @return A widget with the specified models.
     */
    public static final <W extends Widget2<First, Second>, First, Second> W of(Class<W> widgetType, First model1, Second model2) {
        return create(widgetType, new Object[] {model1, model2});
    }

    /**
     * <p>
     * Create widget which is associated with the specified models.
     * </p>
     * 
     * @param widgetType A widget type.
     * @param model1 An associated model.
     * @param model2 An associated model.
     * @param model3 An associated model.
     * @return A widget with the specified models.
     */
    public static final <W extends Widget3<First, Second, Third>, First, Second, Third> W of(Class<W> widgetType, First model1, Second model2, Third model3) {
        return create(widgetType, new Object[] {model1, model2, model3});
    }

    /**
     * <p>
     * Create widget which is associated with the specified models.
     * </p>
     * 
     * @param widgetType A widget type.
     * @param model1 An associated model.
     * @param model2 An associated model.
     * @param model3 An associated model.
     * @param model4 An associated model.
     * @return A widget with the specified models.
     */
    public static final <W extends Widget4<First, Second, Third, Fourth>, First, Second, Third, Fourth> W of(Class<W> widgetType, First model1, Second model2, Third model3, Fourth model4) {
        return create(widgetType, new Object[] {model1, model2, model3, model4});
    }

    /**
     * <p>
     * Create widget which is associated with the specified models.
     * </p>
     * 
     * @param widgetType A widget type.
     * @param model1 An associated model.
     * @param model2 An associated model.
     * @param model3 An associated model.
     * @param model4 An associated model.
     * @param model5 An associated model.
     * @return A widget with the specified models.
     */
    public static final <W extends Widget5<First, Second, Third, Fourth, Fifth>, First, Second, Third, Fourth, Fifth> W of(Class<W> widgetType, First model1, Second model2, Third model3, Fourth model4, Fifth model5) {
        return create(widgetType, new Object[] {model1, model2, model3, model4, model5});
    }

    /**
     * <p>
     * Create widget which is associated with the specified models.
     * </p>
     * 
     * @param widgetType A widget type.
     * @param models Associated models.
     * @return A widget with the specified models.
     */
    private static final <W> W create(Class<W> widgetType, Object[] models) {
        W widget;

        loophole = models;
        widget = I.make(widgetType);
        loophole = null;

        return widget;
    }
}
