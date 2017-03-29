/*
 * Copyright (C) 2016 Nameless Production Committee
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
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.property.SetProperty;

import js.dom.Element;
import js.dom.EventTarget;
import js.dom.UIEvent;
import js.lang.NativeArray;
import js.lang.NativeFunction;
import js.util.HashMap;
import jsx.debug.Profile;
import jsx.style.Style;
import jsx.style.StyleDSL;
import jsx.ui.flux.Interactive;
import jsx.ui.flux.Location;
import jsx.ui.flux.Locator;
import kiss.I;
import kiss.Observer;
import kiss.Signal;
import kiss.model.Model;

/**
 * @version 2016/09/27 10:10:23
 */
public abstract class Widget<Styles extends StyleDSL> implements Declarable {

    /** The root locator. */
    protected static final Style WidgetRoot = () -> {
    };

    static {
        I.load(Widget.class, true);
    }

    /** The update scheduler. */
    private static Set<Widget> updater = new HashSet();

    /** The root widget. */
    Widget root;

    /** The identifier of this {@link Widget}. */
    protected final int id;

    /** The styled location set. */
    protected final Styles $;

    /** The view updater. */
    protected final Consumer<Object> updateView = v -> {
        if (root != null) root.update();
    };

    /** The metadata for this {@link Widget}. */
    private Metadata metadata;

    /** The event context holder. */
    private NativeArray<EventContext> locators;

    /** The virtual root element. */
    private VirtualElement virtual;

    /**
     * <p>
     * Create {@link Widget} without id.
     * </p>
     */
    protected Widget() {
        this(0);
    }

    /**
     * <p>
     * Create {@link Widget} with id which is calculated by the specified models.
     * </p>
     * 
     * @param models
     */
    protected Widget(Object... models) {
        this(Objects.hash(models));
    }

    /**
     * <p>
     * Create {@link Widget} with the specified id.
     * </p>
     */
    protected Widget(int id) {
        this.id = id != 0 ? id : hashCode();
        Type[] parameters = Model.collectParameters(getClass(), Widget.class);
        this.$ = (Styles) (parameters.length == 0 ? new StyleDSL() : I.make((Class) parameters[0]));

        metadata = Metadata.of(this);
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
                    VirtualElement next = StructureDSL.createWidget(widget);

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
     * <p>
     * Register the {@link Signal} listener for the specified action type.
     * </p>
     * 
     * @param actions A list of action types.
     * @return A location descriptor.
     */
    protected final Locator when(User... actions) {
        EventContext context = new EventContext(actions);

        if (locators == null) {
            locators = new NativeArray();
        }
        locators.push(context);

        // API definition
        return context;
    }

    /**
     * <p>
     * Store all current values.
     * </p>
     */
    final void store() throws Exception {
        for (Metadata.Value meta : metadata.properties) {
            meta.store(this);
        }
    }

    /**
     * <p>
     * Restore all persisted values.
     * </p>
     */
    final void restore() throws Exception {
        for (Metadata.Value meta : metadata.properties) {
            meta.restore(this);
        }
    }

    /**
     * <p>
     * Render UI {@link Widget} on the specified {@link Element}.
     * </p>
     * 
     * @param rootElement A target to DOM element to render widget.
     */
    public final void renderIn(Element rootElement) {
        Objects.nonNull(rootElement);

        this.root = this;
        this.virtual = new VirtualElement(-1, "init", null);
        this.virtual.dom = rootElement;

        initializeEventListeners(rootElement);
        update();
        System.out.println("renderin " + getClass());
    }

    /**
     * <p>
     * Unrender UI {@link Widget} on the specified {@link Element}.
     * </p>
     * 
     * @param rootElement
     */
    public final void renderOut(Element rootElement) {
        disposeEventListeners(rootElement);

        // this.virtual.dom = null;
        this.virtual = null;
        this.root = null;
        System.out.println("renderout " + getClass());
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
     * 
     * @return A virtual structure of this {@link Widget}.
     */
    protected abstract void virtualize();

    /**
     * <p>
     * Initialize event listeners on this {@link Widget}.
     * </p>
     * 
     * @param target A event target.
     */
    void initializeEventListeners(EventTarget target) {
        if (locators != null) {
            for (int i = 0; i < locators.length(); i++) {
                EventContext context = locators.get(i);

                for (User action : context.actions) {
                    target.addEventListener(action.name, context.listener);
                }
            }
        }
    }

    /**
     * <p>
     * Dispose event listeners on this {@link Widget}.
     * </p>
     * 
     * @param target A event target.
     */
    void disposeEventListeners(EventTarget target) {
        if (locators != null) {
            for (int i = 0; i < locators.length(); i++) {
                EventContext context = locators.get(i);

                for (User action : context.actions) {
                    target.removeEventListener(action.name, context.listener);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void declare() {
        StructureDSL.createWidget(this);
    }

    /**
     * @version 2015/10/18 14:44:25
     */
    private static class EventContext implements Locator, Consumer<UIEvent> {

        /** The action types. */
        private final User[] actions;

        /** The re-usable native event listener. */
        private final NativeFunction<UIEvent> listener;

        /** The location name. */
        private String name;

        /** The flag whether listener requires {@link UIEvent} or the context specific object. */
        private boolean useUIEvent;

        /** The holder of actual event listeners. */
        private CopyOnWriteArrayList<Observer> observers;

        /**
         * <p>
         * Setup {@link Signal} context.
         * </p>
         * 
         * @param actions A list of event types.
         */
        private EventContext(User... actions) {
            this.actions = actions;
            this.listener = new NativeFunction(this).bind(this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <T> Signal<T> at(Location locatable, Class<T> type) {
            this.name = locatable.name();
            this.useUIEvent = type == UIEvent.class || type == Object.class;

            return new Signal<T>((observer, disposer) -> {
                if (observers == null) {
                    observers = new CopyOnWriteArrayList();
                }
                observers.add(observer);

                return () -> {
                    observers.remove(observers.indexOf(observer));

                    if (observers.size() == 0) {
                        observers = null;
                    }
                };
            });
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(UIEvent event) {
            if (observers == null) {
                return;
            }

            Element current = event.target;
            Element limit = event.currentTarget;

            if (current.has(name)) {
                fire(event, current);
                return;
            } else {
                while (current != limit) {
                    current = current.parent();

                    if (current.has(name)) {
                        fire(event, current);
                        return;
                    }
                }
            }
        }

        /**
         * <p>
         * Invoke actual event listeners.
         * </p>
         * 
         * @param event
         * @param element
         */
        private void fire(UIEvent event, Element element) {
            if (User.ClickRight.name.equals(event.type)) {
                event.preventDefault();
            }

            for (Observer observer : observers) {
                observer.accept(useUIEvent ? event : element.property(Interactive.class.getName()));
            }
        }
    }

    /**
     * @version 2016/09/27 14:27:14
     */
    private static class Metadata {

        /** The metadata cache. */
        private static final Map<Class, Metadata> cache = new HashMap();

        /** The models. */
        private final List<Value> properties = new ArrayList();

        /** The events. */
        private final List<Field> events = new ArrayList();

        /**
         * <p>
         * Analyze widget.
         * </p>
         * 
         * @param clazz A target widget class.
         */
        private Metadata(Class clazz) {
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(ModelValue.class)) {
                    Class type = field.getType();

                    if (ReadOnlyProperty.class.isAssignableFrom(type)) {
                        properties.add(new Value(field.getName(), null, field));
                    } else if (Signal.class.isAssignableFrom(type)) {
                        events.add(field);
                    } else {

                    }
                }
            }
        }

        /**
         * <p>
         * Retrieve from cache.
         * </p>
         * 
         * @param widget A target {@link Widget}.
         * @return A cached metadata.
         */
        private static Metadata of(Widget widget) {
            return cache.computeIfAbsent(widget.getClass(), Metadata::new);
        }

        /**
         * @version 2016/09/27 14:32:17
         */
        private static class Value {

            /** The value name. */
            private final String name;

            /** The value type. */
            private final Class type;

            /** The accessor. */
            private final Field field;

            /** The value extractor. */
            private final Function<Property, Object> extractor;

            /** The value injector. */
            private final BiConsumer<Property, Object> injector;

            /** The persistence area. */
            private NativeArray values = new NativeArray();

            /**
             * <p>
             * Create value metadata.
             * </p>
             * 
             * @param name A value name.
             * @param type A value type.
             * @param field A value accessor.
             */
            private Value(String name, Class type, Field field) {
                this.name = name;
                this.type = type;
                this.field = field;

                if (SetProperty.class.isAssignableFrom(type) || ListProperty.class.isAssignableFrom(type)) {
                    this.extractor = this::collect;
                    this.injector = this::replenish;
                } else {
                    this.extractor = Property::getValue;
                    this.injector = Property::setValue;
                }
            }

            /**
             * <p>
             * Helper method to collect items from the specified {@link Collection}.
             * </p>
             * 
             * @param collection An item container.
             * @return A list of all items.
             */
            private Object collect(Property<Collection> collection) {
                NativeArray array = new NativeArray();

                for (Object object : collection.getValue()) {
                    array.push(object);
                }
                return array;
            }

            /**
             * <p>
             * Helper method to add items to the specified {@link Collection}.
             * </p>
             * 
             * @param property An item container.
             * @param items A list of items.
             * @return A list of all items.
             */
            private void replenish(Property<Collection> property, Object items) {
                Collection collection = property.getValue();
                NativeArray arrays = (NativeArray) items;

                for (int i = 0; i < arrays.length(); i++) {
                    collection.add(arrays.get(i));
                }
            }

            /**
             * <p>
             * Store the current value.
             * </p>
             * 
             * @param widget A target to store.
             */
            private void store(Widget widget) throws Exception {
                values.push(extractor.apply((Property) field.get(widget)));
                System.out.println("Store " + name + "  [" + values.get(values.length() - 1) + "]");
            }

            /**
             * <p>
             * Restore the persisted value.
             * </p>
             * 
             * @param widget A target to restore.
             */
            private void restore(Widget widget) throws Exception {
                injector.accept((Property) field.get(widget), values.pop());
                System.out.println("Restore " + name + "  [" + field.get(widget) + "]");
            }
        }
    }
}
