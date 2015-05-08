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

import java.util.function.Consumer;
import java.util.function.Function;

import js.dom.UIAction;
import jsx.style.ValueStyle;
import kiss.Events;

/**
 * @version 2015/05/06 11:58:39
 */
public class Action<V> {

    /** The event type. */
    public final UIAction type;

    /** The target location. */
    private final ValueStyle<?> locator;

    /** The event stream. */
    public final Function<Events<?>, Events<V>> event;

    /** The actual event listener. */
    private final Consumer<V> listener;

    /**
     * @param type
     * @param locator
     * @param event
     * @param listener
     */
    Action(UIAction type, ValueStyle<?> locator, Function<Events<?>, Events<V>> event, Consumer<V> listener) {
        this.type = type;
        this.locator = locator;
        this.event = event;
        this.listener = listener;
    }
}
