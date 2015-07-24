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

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import js.dom.EventTarget;
import js.dom.UIAction;
import js.dom.UIEvent;
import js.lang.Global;
import js.lang.NativeFunction;
import kiss.Events;
import kiss.Observer;

/**
 * @version 2015/05/28 17:07:05
 */
class ContextualizedEventListeners {

    /** The associated value. */
    private Object value;

    private List<EventListener> listeners;

    /**
     * @param listeners2
     */
    public ContextualizedEventListeners(Object context, List<EventListener> listeners) {
        this.listeners = listeners;
        this.value = context;
    }

    /**
     * @param dom
     */
    void assign(EventTarget element) {
        for (int i = 0, length = listeners.size(); i < length; i++) {
            EventListener<?, ?> listener = listeners.get(i);

            // TODO FIXME
            if (listener.action.name.equals("keydown")) {
                element = Global.window;
            }

            element.addEventListener(listener.action.name, new NativeFunction<UIEvent>(event -> {
                if (listener.action == UIAction.ClickRight) {
                    event.preventDefault();
                }

                for (Observer observer : listener.observers) {
                    observer.accept(value == null ? event : value);
                }
            }));
        }
    }

    /**
     * @version 2015/05/28 17:11:19
     */
    static class EventListener<S, V> {

        /** The action type. */
        final UIAction action;

        /** The exposed event. */
        final Events<V> event;

        /** The actual listeners. */
        final CopyOnWriteArrayList<Observer> observers = new CopyOnWriteArrayList();

        /**
         * @param type
         */
        public EventListener(UIAction action) {
            Events<V> event = new Events<>(observer -> {
                observers.add(observer);

                return () -> {
                    observers.remove(observer);
                };
            });

            this.action = action;
            this.event = event;
        }
    }
}
