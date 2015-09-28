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
import kiss.Events;
import kiss.I;
import kiss.Manageable;
import kiss.Observer;
import kiss.model.ClassUtil;

/**
 * @version 2015/09/27 11:52:23
 */
@Manageable(lifestyle = VirtualWidgetHierarchy.class)
public abstract class Widget implements Declarable {

    static {
        I.load(Widget.class, true);
    }

    /** The update scheduler. */
    static Set<Widget> updater = new HashSet();

    /** The model loophole to CHEAT. */
    static Object[] loophole;

    /** The identifier of this {@link Widget}. */
    int id = loophole == null ? hashCode() : Objects.hash(loophole);

    /** The root widget. */
    protected Widget root;

    /** The event context holder. */
    private NativeArray<Locator> locators;

    /** The virtual root element. */
    private VirtualElement virtual;

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
        update();
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
     * <p>
     * Register the {@link Events} listener for the specified action type.
     * </p>
     * 
     * @param actionTypes A list of action types.
     * @return A location descriptor.
     */
    protected final Locator when(UIAction... actionTypes) {
        Locator context = new Locator(actionTypes);

        if (locators == null) {
            locators = new NativeArray();
        }
        locators.push(context);

        // API definition
        return context;
    }

    /**
     * @param style
     */
    void registerEventListener(Style style, EventTarget target, Object object) {
        if (locators != null) {
            for (int i = 0, length = locators.length(); i < length; i++) {
                Locator locator = locators.get(i);

                if (locator.locatable == style.locator()) {
                    locator.register(target, object);
                }
            }
        }
    }

    /**
     * <p>
     * Try to re-render UI in the future.
     * </p>
     */
    protected final <V> Observer<V> update(Observer<V> action) {
        return v -> {
            action.accept(v);
            root.update();
        };
    }

    /**
     * <p>
     * Try to re-render UI in the future.
     * </p>
     */
    protected final void update() {
        updater.add(this);

        if (updater.size() == 1) {
            requestAnimationFrame(() -> {
                for (Widget widget : updater) {
                    // create new virtual element
                    VirtualElement next = StructureDescriptor.createWidget(0, widget);

                    // create patch to manipulate DOM and apply it
                    WidgetLog.Diff.start();
                    PatchDiff.apply(widget.virtual, next);
                    WidgetLog.Diff.stop();

                    Profile.show();

                    // update to new virtual element
                    widget.virtual = next;
                }
                updater.clear();
                System.out.println("Run rendering on RAF timing.");
            });
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void declare() {
        StructureDescriptor.createWidget(id, this);
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
     * @version 2015/09/27 11:02:28
     */
    public static class Locator {

        /** The action types. */
        private final UIAction[] actions;

        /** The actual location. */
        private Locatable locatable;

        /** The flag whether listener requires {@link UIEvent} or the context specific object. */
        private boolean useUIEvent;

        /** The holder of actual event listeners. */
        private NativeArray<Observer> observers;

        /**
         * <p>
         * Setup {@link Events} context.
         * </p>
         * 
         * @param actions
         */
        private Locator(UIAction... actions) {
            this.actions = actions;
        }

        /**
         * <p>
         * Locate the specified point in {@link Widget}.
         * </p>
         * 
         * @param locatable A locator object with the bound context type.
         * @return A user intent {@link Events}.
         */
        public <T> Events<T> at(Locatable<T> locatable) {
            return at(locatable, ClassUtil.getParameter(locatable.getClass(), Locatable.class)[0]);
        }

        /**
         * <p>
         * Locate the specified point in {@link Widget}.
         * </p>
         * 
         * @param locatable A locator object.
         * @param type A context type.
         * @return A user intent {@link Events}.
         */
        public <T> Events<T> at(Locatable locatable, Class<T> type) {
            this.locatable = locatable;
            this.useUIEvent = type == UIEvent.class || type == Object.class;

            return new Events<T>(observer -> {
                if (observers == null) {
                    observers = new NativeArray();
                }
                observers.push(observer);

                return () -> {
                    observers.remove(observers.indexOf(observer));

                    if (observers.length() == 0) {
                        observers = null;
                    }
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
            for (UIAction action : actions) {
                target.addEventListener(action.name, new NativeFunction<UIEvent>(event -> {
                    if (action == UIAction.ClickRight) {
                        event.preventDefault();
                    }

                    for (int i = 0, length = observers.length(); i < length; i++) {
                        observers.get(i).accept(useUIEvent ? event : context);
                    }
                }));
            }
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
