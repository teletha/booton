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
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import js.dom.UIAction;
import js.dom.UIEvent;
import js.util.HashMap;
import jsx.style.Style;
import jsx.style.ValueStyle;
import jsx.ui.ContextualizedEventListeners.EventListener;
import kiss.Events;
import kiss.Observer;

/**
 * @version 2015/05/29 15:01:32
 */
public class EventEmittable {

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

        List<EventListener> byAction = byLocation.computeIfAbsent(locator, key -> new CopyOnWriteArrayList());

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
}
