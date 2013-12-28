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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

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
    private Map<UIAction, Listener> natives;

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
        unregister();

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
        unregister(type);

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
    public T off(UIAction[] types, Consumer<Event> listener) {
        if (types != null) {
            for (UIAction type : types) {
                off(type, listener);
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
    public T off(UIAction type, Consumer<Event> listener) {
        unregister(type, listener);

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
    public T on(UIAction[] types, Consumer<Event> listener) {
        if (types != null) {
            for (UIAction type : types) {
                on(type, listener);
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
    public T on(UIAction type, Consumer<Event> listener) {
        register(type, listener);

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

            Listener listener = natives.get(action);

            if (listener == null) {
                listener = new Listener(action);
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
        if (type instanceof UIAction) {
            Listener listener = natives.remove(type);

            if (listener != null) {
                removeEventListener(((UIAction) type).name, listener.dom);
            }

            if (natives.isEmpty()) {
                natives = null;
            }
        }
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
     * <p>
     * Native event listener.
     * </p>
     * 
     * @version 2013/12/28 10:38:36
     */
    private class Listener implements Consumer<Event> {

        /** The event type. */
        private final UIAction type;

        /** The cache for native event listener. */
        private final NativeFunction dom = new NativeFunction(this).bind(this);

        /**
         * @param type
         */
        private Listener(UIAction type) {
            this.type = type;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void accept(Event event) {
            UIEvent ui = I.make(UIEvent.class);
            ui.set(event, type);

            publish(ui);
        }
    }
}
