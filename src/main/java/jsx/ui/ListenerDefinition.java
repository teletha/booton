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

import js.dom.UIAction;
import js.lang.NativeArray;
import js.lang.NativeFunction;
import jsx.style.Style;
import kiss.Events;
import kiss.Observer;

/**
 * @version 2015/05/28 0:02:49
 */
public class ListenerDefinition<V> {

    /** The element locator. */
    private final Style locator;

    /** The associated value type. */
    private final Class type;

    /** The ui action type. */
    final UIAction action;

    Events<V> event;

    /** The actual event listener holder. */
    private final NativeArray<Observer> observers = new NativeArray();

    /**
     * @param locator
     * @param type
     */
    public ListenerDefinition(UIAction action, Style locator, Class type) {
        this.action = action;
        this.locator = locator;
        this.type = type;

        this.event = new Events<>(observer -> {
            observers.push(observer);

            return () -> {
                observers.remove(observers.indexOf(observer));
            };
        });
    }

    public NativeFunction createNativeListener(V associatedValue) {
        return new NativeFunction(uiEvent -> {
            for (int i = 0, length = observers.length(); i < length; i++) {
                observers.get(i).accept(associatedValue);
            }
        });
    }
}