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

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import js.dom.Element;
import js.dom.EventTarget;
import js.dom.UIAction;
import js.dom.UIEvent;
import js.lang.NativeArray;
import js.lang.NativeFunction;
import jsx.debug.Profile;
import jsx.style.ValueStyle;
import kiss.Events;
import kiss.I;
import kiss.Manageable;
import kiss.Observer;

/**
 * @version 2015/05/29 15:48:14
 */
@Manageable(lifestyle = VirtualWidgetHierarchy.class)
public abstract class Widget {

    static {
        I.load(Widget.class, true);
    }

    /** The model loophole to CHEAT. */
    static Object[] loophole;

    /** The identifier of this {@link Widget}. */
    int id = loophole == null ? hashCode() : Objects.hash(loophole);

    /** The root widget. */
    protected Widget root;

    /** The event context holder. */
    private NativeArray<EventContext> contexts;

    /**
     * <p>
     * Render UI {@link Widget} on the specified {@link Element}.
     * </p>
     * 
     * @param root A target to DOM element to render widget.
     */
    public final void renderIn(Element root) {
        Objects.nonNull(root);

        this.root = this;
        this.virtual = new VirtualElement(0, "div", null);
        this.virtual.dom = root;
        willUpdateUI();
    }

    /**
     * <p>
     * Validate a state of this widget.
     * </p>
     * 
     * @return
     */
    protected boolean shouldUpdate() {
        return true;
    }

    /**
     * <p>
     * Create virtual elements of this {@link Widget}.
     * </p>
     */
    protected abstract void virtualize();

    /**
     * @param actionType
     * @param locator
     * @return
     */
    protected final <V> Events<V> when(UIAction actionType, ValueStyle<V> locator) {
        return when(actionType, locator, false);
    }

    /**
     * @param actionType
     * @param locator
     * @return
     */
    protected final Events<UIEvent> when(UIAction actionType, Style locator) {
        return when(actionType, locator, false);
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
        return when(actionType, locator, true);
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

    protected final void update() {
        root.willUpdateUI();
    }

    /**
     * <p>
     * Update this widget by manual.
     * </p>
     */
    protected final <V> Observer<V> update(Observer<V> action) {
        return v -> {
            root.willUpdateUI();
            action.accept(v);
        };
    }

    private static Set<Widget> updater = new HashSet();

    /**
     * <p>
     * Try to render UI in the future.
     * </p>
     */
    private void willUpdateUI() {
        updater.add(this);

        if (updater.size() == 1) {
            requestAnimationFrame(() -> {
                for (Widget widget : updater) {
                    widget.updateUI();
                }
                updater.clear();
                System.out.println("Run Rendering on RAF timing.");
            });
        }
    }

    private VirtualElement virtual;

    /**
     * <p>
     * Render UI if needed.
     * </p>
     */
    private void updateUI() {
        // create new virtual element
        VirtualElement next = StructureDescriptor.createWidget(0, this);

        // create patch to manipulate DOM and apply it
        WidgetLog.Diff.start();
        PatchDiff.apply(virtual, next);
        WidgetLog.Diff.stop();

        Profile.show();

        // update to new virtual element
        virtual = next;
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
        return create(widgetType, new Object[0]);
    }

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
        WidgetLog.Make.start();
        widget = I.make(widgetType);
        WidgetLog.Make.stop();
        loophole = null;

        return widget;
    }

    /**
     * @version 2015/08/19 21:32:14
     */
    private class EventContext<V> {

        /** The action type. */
        private final UIAction actionType;

        private final Locatable locator;

        private final Events<V> events;

        private final boolean useContext;

        /** The holder of actual event listeners. */
        private final NativeArray<Observer> observers = new NativeArray();

        /**
         * @param actionType
         * @param locator
         */
        private EventContext(UIAction actionType, Locatable<V> locator, boolean useContext) {
            this.actionType = actionType;
            this.locator = locator;
            this.useContext = useContext;
            this.events = new Events<V>(observer -> {
                observers.push(observer);

                return () -> {
                    observers.remove(observers.indexOf(observer));
                };
            });
        }

        /**
         * <p>
         * Register event listener to the specified {@link Element}.
         * </p>
         * 
         * @param target An event target.
         * @param context A context object.
         */
        private void register(EventTarget target, Object context) {
            target.addEventListener(actionType.name, new NativeFunction<UIEvent>(event -> {
                if (actionType == UIAction.ClickRight) {
                    event.preventDefault();
                }

                for (int i = 0, length = observers.length(); i < length; i++) {
                    observers.get(i).accept(useContext ? context : event);
                }
            }));
        }
    }

    // /**
    // * @version 2014/10/07 12:49:44
    // */
    // private static class Rendering implements Runnable {
    //
    // /** The associated widget. */
    // private final Widget widget;
    //
    // /** The virtual root element. */
    // private VirtualElement virtual;
    //
    // // /**
    // // * @param root A target to DOM element to render widget.
    // // */
    // // private Rendering(Widget widget, Element root) {
    // // this.widget = widget;
    // // this.virtual = new VirtualElement(0, "div", null);
    // // this.virtual.dom = root;
    // // }
    //
    // // /**
    // // * <p>
    // // * Try to render UI in the future.
    // // * </p>
    // // */
    // // private void willExecute() {
    // // update.add(this);
    // //
    // // if (update.size() == 1) {
    // // requestAnimationFrame(this);
    // // }
    // // }
    //
    // // /**
    // // * {@inheritDoc}
    // // */
    // // @Override
    // // public void run() {
    // // for (Rendering rendering : update) {
    // // rendering.execute();
    // // }
    // // update.clear();
    // // System.out.println("Run Rendering on RAF timing.");
    // // }
    //
    // // /**
    // // * <p>
    // // * Render UI if needed.
    // // * </p>
    // // */
    // // private void execute() {
    // // // create new virtual element
    // // VirtualElement next = StructureDescriptor.createWidget(0, widget);
    // //
    // // // create patch to manipulate DOM and apply it
    // // WidgetLog.Diff.start();
    // // PatchDiff.apply(virtual, next);
    // // WidgetLog.Diff.stop();
    // //
    // // Profile.show();
    // //
    // // // update to new virtual element
    // // virtual = next;
    // // }
    // }
}
