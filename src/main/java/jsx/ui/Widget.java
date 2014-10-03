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

import static js.lang.Global.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;

import js.dom.Element;
import kiss.I;
import kiss.Manageable;

/**
 * @version 2014/08/21 13:31:25
 */
@Manageable(lifestyle = VirtualStructureHierarchy.class)
public abstract class Widget {

    /** The re-rendering queue. */
    private static final Set<Rendering> update = new HashSet();

    static {
        I.load(Widget.class, true);
    }

    /** The model loophole to CHEAT. */
    static Object[] loophole;

    /** The identifier of this {@link Widget}. */
    int id = loophole == null ? hashCode() : Objects.hash(loophole);

    /** The {@link Widget} rendering machine. */
    private Rendering rendering;

    /**
     * <p>
     * Render UI {@link Widget} on the specified {@link Element}.
     * </p>
     * 
     * @param root A target to DOM element to render widget.
     */
    public final void renderIn(Element root) {
        Objects.nonNull(root);

        rendering = new Rendering(this, root);
        rendering.willExecute();
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
    private static final <W extends Widget> W create(Class<W> widgetType, Object[] models) {
        W widget;

        loophole = models;
        widget = I.make(widgetType);
        loophole = null;

        return widget;
    }

    /**
     * @version 2014/09/29 9:31:25
     */
    private static class Rendering implements Runnable, ListChangeListener, ChangeListener {

        /** The associated widget. */
        private final Widget widget;

        /** The virtual root element. */
        private VirtualElement virtual = new VirtualElement(0, "div");

        /**
         * @param root A target to DOM element to render widget.
         */
        private Rendering(Widget widget, Element root) {
            this.widget = widget;
            this.virtual.dom = root;

            Class type = widget.getClass();

            try {
                while (type != Widget.class) {
                    for (Field field : type.getDeclaredFields()) {
                        Class fieldType = field.getType();

                        if (field.getName().startsWith("model") || Input.class.isAssignableFrom(fieldType)) {
                            inspect(field.get(widget));
                        }
                    }
                    type = type.getSuperclass();
                }
            } catch (Exception e) {
                throw I.quiet(e);
            }
        }

        /**
         * Inspect the specified model.
         * 
         * @param property
         */
        private void inspect(Object model) {
            try {
                for (Field field : model.getClass().getFields()) {
                    if (Modifier.isFinal(field.getModifiers())) {
                        Class type = field.getType();

                        if (ListProperty.class.isAssignableFrom(type)) {
                            inspect((ListProperty) field.get(model));
                        } else if (Property.class.isAssignableFrom(type)) {
                            inspect((Property) field.get(model));
                        }
                    }
                }
            } catch (Exception e) {
                throw I.quiet(e);
            }
        }

        /**
         * Inspect the specified {@link Property}.
         * 
         * @param property
         */
        private void inspect(ListProperty property) {
            property.addListener((ListChangeListener) this);
        }

        /**
         * Inspect the specified {@link Property}.
         * 
         * @param property
         */
        private void inspect(Property property) {
            property.addListener(this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            willExecute();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onChanged(Change change) {
            willExecute();
        }

        /**
         * <p>
         * Try to render UI in the future.
         * </p>
         */
        private void willExecute() {
            update.add(this);

            if (update.size() == 1) {
                requestAnimationFrame(this);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void run() {
            try {
                for (Rendering rendering : update) {
                    rendering.execute();
                }
                update.clear();
            } catch (Throwable e) {
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
            }
        }

        /**
         * <p>
         * Render UI if needed.
         * </p>
         */
        private void execute() {
            // create new virtual element
            VirtualStructure structure = new VirtualStructure();
            VirtualStructureHierarchy.hierarchy.put(widget.getClass(), widget);
            widget.virtualize(structure);
            VirtualStructureHierarchy.hierarchy.remove(widget.getClass(), widget);
            VirtualElement next = structure.getRoot();

            // create patch to manipulate DOM
            List<Patch> patches = Diff.diff(virtual, next);

            // update virtual element
            virtual = next;

            // update real element
            for (Patch patch : patches) {
                patch.apply();
            }
        }
    }
}
