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

import static js.lang.Global.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;

import js.dom.Element;
import js.dom.EventTarget;
import js.dom.UIAction;
import js.dom.UIEvent;
import js.lang.NativeArray;
import jsx.debug.Profile;
import jsx.style.Style;
import jsx.style.ValueStyle;
import jsx.ui.piece.Input;
import kiss.Events;
import kiss.I;
import kiss.Manageable;

/**
 * @version 2015/05/29 15:48:14
 */
@Manageable(lifestyle = VirtualWidgetHierarchy.class)
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

    protected boolean shouldUpdate() {
        return true;
    }

    /**
     * <p>
     * Create virtual elements of this {@link Widget}.
     * </p>
     */
    protected abstract void virtualize2();

    /**
     * <p>
     * This is internal API.
     * </p>
     * <p>
     * Create the virtual elements of this {@link Widget} and return the root {@link VirtualElement}
     * if present .
     * </p>
     */
    protected VirtualElement virtualize() {
        VirtualElement element = new VirtualElement(0, "div", null);

        Declarables.latestElement = element;
        Declarables.widget(this);

        return element;
    }

    private NativeArray<EventContext> contexts;

    /**
     * @param actionType
     * @param locator
     * @return
     */
    protected final <V> Events<V> when(UIAction actionType, ValueStyle<V> locator) {
        return when(actionType, locator, true);
    }

    /**
     * @param actionType
     * @param locator
     * @return
     */
    protected final Events<UIEvent> when(UIAction actionType, Style locator) {
        return when(actionType, locator, true);
    }

    /**
     * <p>
     * </p>
     * 
     * @param actionType
     * @param locator
     * @param contextType
     * @return
     */
    protected final <V> Events<V> when(UIAction actionType, Style locator, Class<V> contextType) {
        return when(actionType, locator, contextType);
    }

    /**
     * <p>
     * Register the event listener.
     * </p>
     * 
     * @param action
     * @param locatable
     * @param event
     * @return
     */
    private <V> Events<V> when(UIAction action, Locatable locatable, boolean event) {
        EventContext context = new EventContext(action, locatable, event);

        if (contexts == null) {
            contexts = new NativeArray();
        }
        contexts.push(context);

        return context.events;
    }

    /**
     * @param style
     */
    void registerEventListener(Style style, EventTarget target, Object object) {
        if (contexts != null) {
            for (int i = 0, length = contexts.length(); i < length; i++) {
                EventContext context = contexts.get(i);

                if (context.locator == style.locator()) {
                    context.register(target, object);
                }
            }
        }
    }

    /**
     * <p>
     * Update this widget by manual.
     * </p>
     */
    protected final void update() {
        rendering.willExecute();
    }

    /**
     * <p>
     * Create widget which is associated with the specified models.
     * </p>
     * 
     * @param widgetType A widget type.
     * @return A widget with the specified models.
     */
    public static final <W extends Widget> W of(Class<W> widgetType) {
        return (W) widgets.computeIfAbsent(Objects.hash(widgetType), key -> create(widgetType, new Object[0]));
    }

    private static Map<Integer, Widget> widgets = new HashMap();

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
        return (W) widgets.computeIfAbsent(Objects.hash(widgetType, model1), key -> create(widgetType, new Object[] {model1}));
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
        WidgetLog.Make.start();
        widget = I.make(widgetType);
        WidgetLog.Make.stop();
        loophole = null;

        return widget;
    }

    /**
     * @version 2014/10/07 12:49:44
     */
    private static class Rendering implements Runnable, ListChangeListener, ChangeListener, InvalidationListener {

        /** The associated widget. */
        private final Widget widget;

        /** The virtual root element. */
        private VirtualElement virtual;

        /**
         * @param root A target to DOM element to render widget.
         */
        private Rendering(Widget widget, Element root) {
            this.widget = widget;
            this.virtual = new VirtualElement(0, "div", null);
            this.virtual.dom = root;

            Class type = widget.getClass();

            try {
                while (type != Widget.class) {
                    for (Field field : type.getDeclaredFields()) {
                        Class fieldType = field.getType();

                        if (field.getName().startsWith("model") || Input.class.isAssignableFrom(fieldType)) {
                            inspect(field.get(widget));
                        } else if (Observable.class.isAssignableFrom(fieldType)) {
                            ((Observable) field.get(widget)).addListener(this);
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
            property.addListener((ChangeListener) this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void invalidated(Observable observable) {
            willExecute();
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
            for (Rendering rendering : update) {
                rendering.execute();
            }
            update.clear();
            System.out.println("Run Rendering on RAF timing.");
        }

        /**
         * <p>
         * Render UI if needed.
         * </p>
         */
        private void execute() {
            // create new virtual element
            VirtualElement next = widget.virtualize();

            // create patch to manipulate DOM and apply it
            WidgetLog.Diff.start();
            PatchDiff.apply(virtual, next);
            WidgetLog.Diff.stop();

            Profile.show();

            // update to new virtual element
            virtual = next;
        }
    }
}
