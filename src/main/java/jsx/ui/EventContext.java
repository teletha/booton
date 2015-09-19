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

import js.dom.Element;
import js.dom.EventTarget;
import js.dom.UIAction;
import js.dom.UIEvent;
import js.lang.NativeArray;
import js.lang.NativeFunction;
import kiss.Events;
import kiss.Observer;

/**
 * @version 2015/08/19 21:32:14
 */
class EventContext<V> {

    private final UIAction actionType;

    final Locatable locator;

    final Events<V> events;

    private final boolean useContext;

    /** The actual listeners. */
    private final NativeArray<Observer> observers = new NativeArray();

    /**
     * @param actionType
     * @param locator
     */
    EventContext(UIAction actionType, Locatable<V> locator, boolean useContext) {
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
     * @param target
     */
    void register(EventTarget target, Object object) {
        target.addEventListener(actionType.name, new NativeFunction<UIEvent>(event -> {
            if (actionType == UIAction.ClickRight) {
                event.preventDefault();
            }

            for (int i = 0, length = observers.length(); i < length; i++) {
                observers.get(i).accept(useContext ? object : event);
            }
        }));
    }
}