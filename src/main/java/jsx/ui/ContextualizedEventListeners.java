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

import js.dom.Element;
import js.dom.UIAction;
import js.dom.UIEvent;
import js.lang.NativeArray;
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
    void assign(Element element) {
        for (int i = 0, length = listeners.size(); i < length; i++) {
            EventListener<?> listener = listeners.get(i);

            element.addEventListener(listener.type.name, new NativeFunction<UIEvent>(event -> {
                if (listener.type == UIAction.ClickRight) {
                    event.preventDefault();
                }

                for (int j = 0, size = listener.observers.length(); j < size; j++) {
                    listener.observers.get(j).accept(value);
                }
            }));
        }
    }

    /**
     * @version 2015/05/28 17:11:19
     */
    static class EventListener<V> {

        /** The action type. */
        private final UIAction type;

        /** The actual listeners. */
        private final NativeArray<Observer> observers = new NativeArray();

        Events<V> event;

        /**
         * @param type
         */
        public EventListener(UIAction type) {
            this.type = type;

            this.event = new Events<>(observer -> {
                observers.push(observer);

                return () -> {
                    observers.remove(observers.indexOf(observer));
                };
            });
        }
    }
}
