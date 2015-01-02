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
import jsx.event.Publishable;
import kiss.Events;
import booton.translator.JavascriptNative;

/**
 * <p>
 * EventTarget is not common class in variaous platforms. (IE and Webkit doesn't have it.)
 * </p>
 * 
 * @version 2013/12/29 0:15:36
 */
public abstract class EventTarget<T extends EventTarget<T>> extends Publishable<T> implements JavascriptNative {

    /** The event listener holder. */
    private Map<UIAction, Listener> natives;

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

    public Events<UIEvent> listen(UIAction type) {
        return new Events<UIEvent>(observer -> {
            // create native event listener and delegete event to the given event observer.
            NativeFunction nativeListener = new NativeFunction<UIEvent>(observer::onNext);

            // register
            addEventListener(type.name, nativeListener);

            return () -> {
                // unregister
                removeEventListener(type.name, nativeListener);
            };
        });
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
    public native void addEventListener(String type, NativeFunction listener);

    /**
     * <p>
     * Removes the event listener previously registered.
     * </p>
     * 
     * @param type A string representing the event type being removed.
     * @param listener The listener to be removed.
     */
    public native void removeEventListener(String type, NativeFunction listener);

    /**
     * <p>
     * Dispatches an Event at the specified EventTarget, invoking the affected EventListeners in the
     * appropriate order. The normal event processing rules (including the capturing and optional
     * bubbling phase) apply to events dispatched manually with dispatchEvent().
     * </p>
     * 
     * @param event A Event object to be dispatched.
     */
    protected native void dispatchEvent(UIEvent event);

    /**
     * <p>
     * Native event listener.
     * </p>
     * 
     * @version 2013/12/28 10:38:36
     */
    private class Listener implements Consumer<UIEvent> {

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
        public void accept(UIEvent event) {
            Event wrapper = new Event();
            wrapper.action = type;
            wrapper.event = event;
            wrapper.currentTarget = event.currentTarget;
            wrapper.delegateTarget = event.delegateTarget;
            wrapper.namespace = event.namespace;
            wrapper.pageX = event.pageX;
            wrapper.pageY = event.pageY;
            wrapper.relatedTarget = event.relatedTarget;
            wrapper.target = event.target;
            wrapper.timeStamp = event.timeStamp;
            wrapper.type = event.type;
            wrapper.which = event.which;

            publish(wrapper);
        }
    }

    /**
     * @version 2013/12/28 11:20:12
     */
    private static class Event extends UIEvent {

        /** The actual event. */
        private UIEvent event;

        /**
         * {@inheritDoc}
         */
        @Override
        public void initEvent(String type, boolean bubbles, boolean cancelable) {
            event.initEvent(type, bubbles, cancelable);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isDefaultPrevented() {
            return event.isDefaultPrevented();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isImmediatePropagationStopped() {
            return event.isImmediatePropagationStopped();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isPropagationStopped() {
            return event.isPropagationStopped();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void preventDefault() {
            event.preventDefault();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void stopPropagation() {
            event.stopPropagation();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void stopImmediatePropagation() {
            event.stopImmediatePropagation();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void dispose() {
            stopPropagation();
            preventDefault();
        }
    }
}
