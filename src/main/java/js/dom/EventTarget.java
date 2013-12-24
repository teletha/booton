/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import static js.lang.Global.*;

import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import js.lang.NativeFunction;
import jsx.bwt.UIEvent;
import jsx.event.Publishable;
import kiss.I;
import booton.translator.JavascriptNative;

/**
 * <p>
 * EventTarget is not common class in variaous platforms. (IE and Webkit doesn't have it.)
 * </p>
 * 
 * @version 2013/08/22 15:56:25
 */
public class EventTarget<T extends EventTarget<T>> extends Publishable implements JavascriptNative {

    /** The event listener holder. */
    private Map<UIAction, Listeners> events;

    /** The event listener holder. */
    private Map<UIAction, NativeListener> natives;

    /**
     * <p>
     * Attach all event handlers which are defined in the given subscriber to the selected elements.
     * </p>
     * 
     * @param subscriber A subscriber that holds user action event listeners.
     * @return A chainable API.
     */
    public T bind(Object subscriber) {
        if (subscriber != null) {
            register(subscriber);
        }

        // API defintion
        return (T) this;
    }

    /**
     * <p>
     * Dettach all event handlers which are defined in the given subscriber from the selected
     * elements.
     * </p>
     * 
     * @param subscriber A subscriber that holds user action event listeners.
     * @return A chainable API.
     */
    public T unbind(Object subscriber) {
        if (subscriber != null) {
            unregister(subscriber);
        }

        // API defintion
        return (T) this;
    }

    /**
     * <p>
     * Dettach all event handlers from this element.
     * </p>
     * 
     * @return A chainable API.
     */
    public T off() {
        if (events != null) {
            for (UIAction type : events.keySet()) {
                off(type);
            }
        }

        // API defintion
        return (T) this;
    }

    /**
     * <p>
     * Dettach all specified-type event handlers from this element.
     * </p>
     * 
     * @return A chainable API.
     */
    public T off(UIAction type) {
        if (events != null) {
            Listeners listeners = events.get(type);

            if (listeners != null) {
                events.remove(type);
                removeEventListener(type.name, listeners.nativeListener);

                if (events.size() == 0) {
                    events = null;
                }
            }
        }

        // API defintion
        return (T) this;
    }

    /**
     * <p>
     * Dettach all event handlers which are defined in the given subscriber to the selected
     * elements.
     * </p>
     * 
     * @param subscriber A subscriber that holds user action event listeners.
     * @return A chainable API.
     */
    public T off(UIAction[] types, EventListener subscriber) {
        if (events != null) {
            for (UIAction type : types) {
                off(type, subscriber);
            }
        }

        // API defintion
        return (T) this;
    }

    /**
     * <p>
     * Dettach all event handlers which are defined in the given subscriber to the selected
     * elements.
     * </p>
     * 
     * @param subscriber A subscriber that holds user action event listeners.
     * @return A chainable API.
     */
    public T off(UIAction type, EventListener subscriber) {
        if (events != null && type != null && subscriber != null) {
            Listeners listeners = events.get(type);

            if (listeners != null) {
                int size = listeners.remove(subscriber);

                if (size == 0) {
                    events.remove(type);
                    removeEventListener(type.name, listeners.nativeListener);

                    if (events.size() == 0) {
                        events = null;
                    }
                }
            }
        }

        // API defintion
        return (T) this;
    }

    /**
     * <p>
     * Attach all event handlers which are defined in the given subscriber to the selected elements.
     * </p>
     * 
     * @param subscriber A subscriber that holds user action event listeners.
     * @return A chainable API.
     */
    public T on(UIAction[] types, EventListener subscriber) {
        if (types != null && subscriber != null) {
            for (UIAction type : types) {
                on(type, subscriber);
            }
        }

        // API defintion
        return (T) this;
    }

    /**
     * <p>
     * Attach all event handlers which are defined in the given subscriber to the selected elements.
     * </p>
     * 
     * @param subscriber A subscriber that holds user action event listeners.
     * @return A chainable API.
     */
    public T on(UIAction type, EventListener subscriber) {
        if (type != null && subscriber != null) {
            if (events == null) {
                events = new HashMap();
            }

            Listeners listeners = events.get(type);

            if (listeners == null) {
                listeners = new Listeners();
                events.put(type, listeners);
                addEventListener(type.name, listeners.nativeListener);
            }
            listeners.add(subscriber);
        }

        // API defintion
        return (T) this;
    }

    public void trigger(UIAction type) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void startListening(Object type) {
        if (type instanceof UIAction) {
            UIAction action = (UIAction) type;

            if (natives == null) {
                natives = new HashMap();
            }

            NativeListener listener = natives.get(action);

            if (listener == null) {
                listener = new NativeListener(action);
                natives.put(action, listener);
            }
            addEventListener(action.name, listener.dom);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void stopListening(Object type) {
    }

    /**
     * <p>
     * Registers the specified listener on the EventTarget it's called on.
     * </p>
     * 
     * @param type A string representing the event type to listen for.
     * @param listener The object that receives a notification when an event of the specified type
     *            occurs.
     */
    protected native void addEventListener(String type, NativeFunction listener);

    /**
     * <p>
     * Removes the event listener previously registered.
     * </p>
     * 
     * @param type A string representing the event type being removed.
     * @param listener The listener to be removed.
     */
    protected native void removeEventListener(String type, NativeFunction listener);

    /**
     * <p>
     * Dispatches an Event at the specified EventTarget, invoking the affected EventListeners in the
     * appropriate order. The normal event processing rules (including the capturing and optional
     * bubbling phase) apply to events dispatched manually with dispatchEvent().
     * </p>
     * 
     * @param event A Event object to be dispatched.
     */
    protected native void dispatchEvent(Event event);

    /**
     * @version 2013/10/20 22:43:45
     */
    private class NativeListener implements EventListener {

        /** The event type. */
        private final UIAction type;

        /** The cache for native event listener. */
        private final NativeFunction dom = new NativeFunction(this).bind(this);

        /**
         * @param type
         */
        private NativeListener(UIAction type) {
            this.type = type;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(Event event) {
            UIEvent ui = I.make(UIEvent.class);
            ui.set(event, type);

            publish(ui);
        }
    }

    /**
     * @version 2013/07/07 13:50:26
     */
    private static class Listeners implements EventListener {

        /** The actual listener holder. */
        private final CopyOnWriteArrayList<EventListener> listeners = new CopyOnWriteArrayList();

        /** The cache for native event listener. */
        private final NativeFunction nativeListener = new NativeFunction(this).bind(this);

        /**
         * <p>
         * Register event listener.
         * </p>
         * 
         * @param listener
         */
        private void add(EventListener listener) {
            listeners.addIfAbsent(listener);
        }

        /**
         * <p>
         * Unregister event listener.
         * </p>
         * 
         * @param listener
         * @return
         */
        private int remove(EventListener listener) {
            listeners.remove(listener);

            return listeners.size();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(Event event) {
            try {
                for (EventListener listener : listeners) {
                    listener.handleEvent(event);
                }
            } catch (Throwable e) {
                UncaughtExceptionHandler handler = Thread.getDefaultUncaughtExceptionHandler();

                if (handler != null) {
                    handler.uncaughtException(null, e);
                }
            }
        }
    }
}
