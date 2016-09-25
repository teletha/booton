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

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
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
import js.dom.User;
import js.lang.NativeArray;
import js.lang.NativeFunction;
import js.util.HashMap;
import jsx.debug.Profile;
import jsx.style.Style;
import jsx.style.StyleDSL;
import jsx.ui.flux.Interactive;
import jsx.ui.flux.Location;
import jsx.ui.flux.Locator;
import kiss.Events;
import kiss.I;
import kiss.Manageable;
import kiss.Observer;
import kiss.model.Model;

/**
 * @version 2016/09/25 14:33:57
 */
@Manageable(lifestyle = VirtualWidgetHierarchy.class)
public class Widget<Styles extends StyleDSL> implements Declarable {

    /** The cache for widget metadata. */
    private static final Map<Class, WidgetModelManager> metas = new HashMap();

    /** The root locator. */
    protected static final Style WidgetRoot = () -> {
    };

    static {
        I.load(Widget.class, true);
    }

    /** The update scheduler. */
    static Set<Widget> updater = new HashSet();

    /** The model loophole to CHEAT. */
    static Object[] loophole;

    /** The identifier of this {@link Widget}. */
    protected final int id;

    /** The root widget. */
    protected Widget root;

    /** The styled location set. */
    protected Styles $;

    /** The metadata for this {@link Widget}. */
    WidgetModelManager modelManager;

    /** The event context holder. */
    private NativeArray<EventContext> locators;

    /** The virtual root element. */
    private VirtualElement virtual;

    /**
     * 
     */
    protected Widget() {
        this(0);
    }

    /**
     * 
     */
    protected Widget(int id) {
        this.id = id != 0 ? id : loophole == null ? hashCode() : Objects.hash(loophole);
        Type[] parameters = Model.collectParameters(getClass(), Widget.class);
        this.$ = (Styles) (parameters.length == 0 ? new StyleDSL() : I.make((Class) parameters[0]));

        /**
         * <p>
         * Enter the hierarchy of {@link VirtualStructure}.
         * </p>
         */
        Widget previous = VirtualWidgetHierarchy.hierarchy.putIfAbsent(getClass(), this);

        // if (previous != null) {
        // throw new IllegalStateException(getClass() + " is a nest in virtual structure.");
        // }
        modelManager = metas.computeIfAbsent(getClass(), p -> new WidgetModelManager(p));
    }

    /**
     * <p>
     * Lazy initializer.
     * </p>
     */
    final void initialize() {
        /**
         * <p>
         * Leave the hierarchy of {@link VirtualStructure}.
         * </p>
         */
        VirtualWidgetHierarchy.hierarchy.remove(getClass());

        try {
            for (ModelMetadata meta : modelManager.properties) {

                ReadOnlyProperty property = (ReadOnlyProperty) meta.field.get(this);

                if (property != null) {
                    property.addListener((instance, oldValue, newValue) -> {
                        update();
                    });
                }
            }

            for (Field field : modelManager.events) {
                ((Events) field.get(this)).to(v -> update());
            }
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Store all current values.
     * </p>
     */
    final void store() throws Exception {
        for (ModelMetadata meta : modelManager.properties) {
            meta.store(this);
        }
    }

    /**
     * <p>
     * Restore all persisted values.
     * </p>
     */
    final void restore() throws Exception {
        for (ModelMetadata meta : modelManager.properties) {
            meta.restore(this);
        }
    }

    /**
     * @version 2015/10/15 14:51:28
     */
    static class WidgetModelManager {

        /** The associated view class. */
        private final Class<StructureDSL> view;

        /** The models. */
        private final List<ModelMetadata> properties = new ArrayList();

        /** The events. */
        private final List<Field> events = new ArrayList();

        /**
         * <p>
         * Analyze widget.
         * </p>
         * 
         * @param clazz A target widget.
         */
        private WidgetModelManager(Class clazz) {
            this.view = searchView(clazz);
            System.out.println(view);

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(ModelValue.class)) {
                    Class type = field.getType();

                    if (ReadOnlyProperty.class.isAssignableFrom(type)) {
                        properties.add(new ModelMetadata(field.getName(), null, field));
                    } else if (Events.class.isAssignableFrom(type)) {
                        events.add(field);
                    } else {

                    }
                }
            }
        }

        /**
         * @param clazz
         * @return
         */
        private Class searchView(Class clazz) {
            for (Class sub : clazz.getDeclaredClasses()) {
                if (StructureDSL.class.isAssignableFrom(sub)) {
                    return sub;
                }
            }

            Class parent = clazz.getSuperclass();
            return parent == Object.class ? null : searchView(parent);
        }
    }

    /**
     * @version 2015/10/15 17:18:43
     */
    private static class ModelMetadata {

        /** The model name. */
        private final String name;

        /** The model type. */
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
         * @param name
         * @param type
         * @param field
         */
        private ModelMetadata(String name, Class type, Field field) {
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
    protected VirtualElement virtualize() {
        try {
            Constructor<?> con = modelManager.view.getDeclaredConstructors()[0];
            con.setAccessible(true);
            StructureDSL dsl = (StructureDSL) con.newInstance(this);
            dsl.virtualize();
            return null;
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Register the {@link Events} listener for the specified action type.
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
     * <p>
     * Try to re-render UI in the future.
     * </p>
     */
    protected final <V> Observer<V> update(Observer<V> action) {
        return v -> {
            action.accept(v);
            if (root != null) root.update();
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
     * {@inheritDoc}
     */
    @Override
    public void declare() {
        StructureDSL.createWidget(this);
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
    public static final <StyledLocations extends StyleDSL, W extends Widget1<StyledLocations, First>, First> W of(Class<W> widgetType, First model1) {
        return create(widgetType, new Object[] {model1});
    }

    /**
     * <p>
     * Create widgets which is associated with the specified models.
     * </p>
     * 
     * @param widgetType A widget type.
     * @param models An associated model.
     * @return A list of widget with the specified models.
     */
    public static final <StyledLocations extends StyleDSL, W extends Widget1<StyledLocations, First>, First> W[] of(Class<W> widgetType, First[] models) {
        W[] widgets = (W[]) Array.newInstance(widgetType, models.length);

        for (int i = 0; i < models.length; i++) {
            widgets[i] = of(widgetType, models[i]);
        }
        return widgets;
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
    public static final <StyledLocations extends StyleDSL, W extends Widget2<StyledLocations, First, Second>, First, Second> W of(Class<W> widgetType, First model1, Second model2) {
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
    public static final <StyledLocations extends StyleDSL, W extends Widget3<StyledLocations, First, Second, Third>, First, Second, Third> W of(Class<W> widgetType, First model1, Second model2, Third model3) {
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
    public static final <StyledLocations extends StyleDSL, W extends Widget4<StyledLocations, First, Second, Third, Fourth>, First, Second, Third, Fourth> W of(Class<W> widgetType, First model1, Second model2, Third model3, Fourth model4) {
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
    public static final <StyledLocations extends StyleDSL, W extends Widget5<StyledLocations, First, Second, Third, Fourth, Fifth>, First, Second, Third, Fourth, Fifth> W of(Class<W> widgetType, First model1, Second model2, Third model3, Fourth model4, Fifth model5) {
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
        widget.initialize();
        WidgetLog.Make.stop();
        loophole = null;

        return widget;
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
         * Setup {@link Events} context.
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
        public <T> Events<T> at(Location locatable, Class<T> type) {
            this.name = locatable.name();
            this.useUIEvent = type == UIEvent.class || type == Object.class;

            return new Events<T>(observer -> {
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

}
