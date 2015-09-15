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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;

import js.dom.Element;
import js.dom.UIAction;
import js.dom.UIEvent;
import js.lang.NativeArray;
import js.lang.NativeFunction;
import jsx.debug.Profile;
import jsx.style.Style;
import jsx.style.ValueStyle;
import jsx.ui.ContextualizedEventListeners.EventListener;
import jsx.ui.piece.Input;
import kiss.Events;
import kiss.I;
import kiss.Manageable;
import kiss.Observer;

/**
 * @version 2015/05/29 15:48:14
 */
@Manageable(lifestyle = VirtualStructureHierarchy.class)
public abstract class Widget implements Declarable {

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

        // register event listener
        if (contexts != null) {
            for (int i = 0, length = contexts.length(); i < length; i++) {
                contexts.get(i).register(root);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void declare() {
        // create virtual element for this widget
        VirtualWidget virtualize = new VirtualWidget(id, this);

        // mount virtual element on virtual structure
        VirtualStructure.latest.items.push(virtualize);

        // process child nodes
        assemble(new VirtualStructure(this, virtualize));
    }

    protected boolean shouldUpdate() {
        return true;
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
     * This is internal API.
     * </p>
     * <p>
     * Create the virtual elements of this {@link Widget} and return the root {@link VirtualElement}
     * if present .
     * </p>
     */
    protected VirtualElement virtualize() {
        VirtualStructure structure = new VirtualStructure(this);

        // assemble the virtual structure
        assemble(structure);

        // API definition
        return structure.getRoot();
    }

    /**
     * <p>
     * This is internal API.
     * </p>
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
        WidgetLog.Virtualize.start();
        virtualize(structure);
        WidgetLog.Virtualize.stop();

        /**
         * <p>
         * Leave the hierarchy of {@link VirtualStructure}.
         * </p>
         */
        VirtualStructureHierarchy.hierarchy.remove(clazz);
    }

    private Map<Object, List<EventListener>> byLocation;

    /**
     * <p>
     * Retrieve the specified event stream on this {@link Widget}.
     * </p>
     * 
     * @param action A target event type to listen.
     * @return An event stream.
     */
    protected final Events<UIEvent> on(UIAction... actions) {
        Events<UIEvent> events = null;

        for (int i = 0; i < actions.length; i++) {
            if (events == null) {
                events = on(actions[i], WidgetStyle.Root, null);
            } else {
                events = events.merge(on(actions[i], WidgetStyle.Root, null));
            }
        }
        return events;
    }

    /**
     * <p>
     * Retrieve the specified event stream on the specified location.
     * </p>
     * 
     * @param action An event type to listen.
     * @param locator An event location to listen.
     * @return An event stream.
     */
    protected final <V> Events<V> on(UIAction action, ValueStyle<V> locator) {
        return on(action, locator, null);
    }

    /**
     * <p>
     * Retrieve the specified event stream on the specified location.
     * </p>
     * 
     * @param action An event type to listen.
     * @param locator An event location to listen.
     * @return An event stream.
     */
    protected final Events<UIEvent> on(UIAction action, Style locator) {
        return on(action, locator, null);
    }

    /**
     * @param action
     * @param locator
     * @param type
     * @param converter
     * @param listener
     * @return
     */
    protected final <S, V> Events<V> on(UIAction action, Object locator, Class<S> type) {
        if (byLocation == null) {
            byLocation = new HashMap();
        }

        List<EventListener> byAction = byLocation.computeIfAbsent(locator, key -> {
            List<EventListener> list = new CopyOnWriteArrayList();

            return list;
        });

        for (EventListener listener : byAction) {
            if (listener.action == action) {
                return listener.event;
            }
        }

        EventListener listener = new EventListener(action);
        byAction.add(listener);

        return listener.event;
    }

    /**
     * @param style
     */
    public List<EventListener> getEventListenersFor(Object style) {
        return byLocation == null ? null : byLocation.get(style);
    }

    /**
     * @param action
     */
    public void publish(UIEvent event) {
        List<EventListener> listeners = getEventListenersFor(WidgetStyle.Root);

        if (listeners != null) {
            for (EventListener<?, ?> listener : listeners) {
                if (listener.action == event.action) {
                    for (Observer observer : listener.observers) {
                        observer.accept(event);
                    }
                    return;
                }
            }
        }
    }

    private NativeArray<EventContext> contexts;

    protected final <V> Events<V> when(UIAction actionType, Style locator, Class<V> contextType) {
        EventContext context = new EventContext(actionType, locator, contextType);

        if (contexts == null) {
            contexts = new NativeArray();
        }
        contexts.push(context);

        return context.events;
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
     * @version 2015/08/19 21:32:14
     */
    private static class EventContext<V> {

        private final UIAction actionType;

        private final Style locator;

        private final Class<V> contextType;

        private final Events<V> events;

        /** The actual listeners. */
        private final NativeArray<Observer> observers = new NativeArray();

        /**
         * @param actionType
         * @param locator
         * @param contextType
         */
        private EventContext(UIAction actionType, Style locator, Class<V> contextType) {
            this.actionType = actionType;
            this.locator = locator;
            this.contextType = contextType;
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
         * @param element
         */
        private void register(Element element) {
            element.addEventListener(actionType.name, new NativeFunction<UIEvent>(event -> {
                if (actionType == UIAction.ClickRight) {
                    event.preventDefault();
                }

                for (int i = 0, length = observers.length(); i < length; i++) {
                    System.out.println(event.target);
                }
            }));
        }
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
            this.virtual = new VirtualElement(0, "div");
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
