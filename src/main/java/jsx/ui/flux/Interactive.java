/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.flux;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

import js.dom.Element;
import js.dom.UIEvent;
import js.lang.NativeArray;
import js.lang.NativeFunction;
import jsx.ui.User;
import kiss.Events;
import kiss.Observer;

/**
 * @version 2016/04/06 16:10:48
 */
public abstract class Interactive {

    /** The event context holder. */
    private NativeArray<EventContext> locators;

    /**
     * <p>
     * Hide Constructor.
     * </p>
     */
    protected Interactive() {
    }

    /**
     * <p>
     * Make the entry point for user action.
     * </p>
     * 
     * @param action
     * @return
     */
    protected Locator when(User... actions) {
        EventContext context = new EventContext(actions);

        if (locators == null) {
            locators = new NativeArray();
        }
        locators.push(context);

        // API definition
        return context;
    }

    /**
     * @version 2016/04/06 16:12:56
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
