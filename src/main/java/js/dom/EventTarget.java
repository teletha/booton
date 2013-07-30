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

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import jsx.bwt.Listen;
import jsx.bwt.UIAction;
import jsx.bwt.UIEvent;
import booton.translator.JavascriptNative;

/**
 * @version 2013/07/30 23:27:52
 */
public class EventTarget<T extends EventTarget<T>> implements JavascriptNative {

    /** The event listener holder. */
    private Map<UIAction, Listeners> events;

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
            Class clazz = subscriber.getClass();

            for (Method method : clazz.getDeclaredMethods()) {
                Listen listen = method.getAnnotation(Listen.class);

                if (listen != null) {
                    EventListener listener = new Subscriber(subscriber, method, listen.abort());

                    // ===========================
                    // Execution Count Wrapper
                    // ===========================
                    int count = listen.count();

                    if (0 < count) {
                        listener = new Count(count, listener);
                    }

                    // ===========================
                    // Timing Related Wrappers
                    // ===========================
                    long time = listen.delay();

                    if (0 < time) {
                        listener = new Delay(time, listener);
                    }

                    time = listen.throttle();

                    if (0 < time) {
                        listener = new Throttle(time, listener);
                    }

                    time = listen.debounce();

                    if (0 < time) {
                        listener = new Debounce(time, listener);
                    }

                    // ===========================
                    // KeyCode Wrapper
                    // ===========================
                    UIAction type = listen.type();
                    int keyCode = type.code;

                    if (keyCode != -1) {
                        listener = new KeyBind(keyCode, listener);
                    }
                    on(type, listener);
                }
            }
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
            Class clazz = subscriber.getClass();
            String namespace = "." + clazz.getSimpleName() + subscriber.hashCode();

            for (Method method : clazz.getMethods()) {
                Listen annotation = method.getAnnotation(Listen.class);

                if (annotation != null) {
                    off(annotation.type());
                }
            }
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
                removeEventListener(type.name, listeners);

                if (events.size() == 0) {
                    stopListening();
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
                    removeEventListener(type.name, listeners);

                    if (events.size() == 0) {
                        stopListening();
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
                startListening();
            }

            Listeners listeners = events.get(type);

            if (listeners == null) {
                listeners = new Listeners();
                events.put(type, listeners);
                addEventListener(type.name, listeners);
            }
            listeners.add(subscriber);
        }

        // API defintion
        return (T) this;
    }

    /**
     * <p>
     * This method is called whenever this event target starts listening event.
     * </p>
     */
    protected void startListening() {
    }

    /**
     * <p>
     * This method is called whenever this event target stops listening event.
     * </p>
     */
    protected void stopListening() {
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
    protected native void addEventListener(String type, EventListener listener);

    /**
     * <p>
     * Removes the event listener previously registered.
     * </p>
     * 
     * @param type A string representing the event type being removed.
     * @param listener The listener to be removed.
     */
    protected native void removeEventListener(String type, EventListener listener);

    /**
     * @version 2013/07/07 13:50:26
     */
    private static class Listeners implements EventListener {

        /** The actual listener holder. */
        private CopyOnWriteArrayList<EventListener> listeners = new CopyOnWriteArrayList();

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
         * <p>
         * Unregister all event listeners.
         * </p>
         */
        private void clear() {
            listeners.clear();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(UIEvent event) {
            for (EventListener listener : listeners) {
                listener.handleEvent(event);
            }
        }
    }

    /**
     * @version 2013/04/08 10:11:19
     */
    private static class Subscriber implements EventListener {

        /** The subscriber instance. */
        private final Object subscriber;

        /** The subscriber method. */
        private final Method method;

        /** The event termination. */
        private final boolean abort;

        /**
         * @param subscriber
         * @param method
         * @param abort
         */
        private Subscriber(Object subscriber, Method method, boolean abort) {
            this.subscriber = subscriber;
            this.method = method;
            this.abort = abort;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(UIEvent event) {
            if (abort) {
                event.stopPropagation();
                event.preventDefault();
            }

            try {
                method.invoke(subscriber, event);
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }

    /**
     * <p>
     * Built-in listener wrapper.
     * </p>
     * 
     * @version 2013/04/08 10:11:19
     */
    private static class KeyBind implements EventListener {

        /** The target key code. */
        private final int keyCode;

        /** The delegation. */
        private final EventListener listener;

        /**
         * @param keyCode
         * @param listener
         */
        private KeyBind(int keyCode, EventListener listener) {
            this.keyCode = keyCode;
            this.listener = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(UIEvent event) {
            if (event.which == keyCode) {
                listener.handleEvent(event);
            }
        }
    }

    /**
     * <p>
     * Built-in listener wrapper.
     * </p>
     * 
     * @version 2013/04/08 13:42:03
     */
    private static class Count implements EventListener {

        /** The delegator. */
        private final EventListener listener;

        /** The execution limit. */
        private final int limit;

        /** The current number of execution. */
        private int current = 0;

        /**
         * @param limit
         */
        private Count(int limit, EventListener listener) {
            this.limit = limit;
            this.listener = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(UIEvent event) {
            listener.handleEvent(event);

            if (++current == limit) {
                // FIXME
                // If this exception will be thrown, it is bug of this program. So we must rethrow
                // the wrapped error in here.
                throw new Error();
            }
        }
    }

    /**
     * <p>
     * Built-in listener wrapper.
     * </p>
     * 
     * @version 2013/04/08 14:58:44
     */
    private static class Debounce implements EventListener, Runnable {

        /** The delay time. */
        private final long delay;

        /** The delegator. */
        private final EventListener listener;

        /** The lastest event. */
        private UIEvent event;

        /** The time out id. */
        private long id = -1;

        /**
         * @param listener
         */
        private Debounce(long delay, EventListener listener) {
            this.delay = delay;
            this.listener = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(UIEvent event) {
            if (id != -1) {
                clearTimeout(id);
            }
            this.event = event;
            this.id = setTimeout(this, delay);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void run() {
            id = -1;
            listener.handleEvent(event);
            event = null;
        }
    }

    /**
     * <p>
     * Built-in listener wrapper.
     * </p>
     * 
     * @version 2013/04/08 14:37:30
     */
    private static class Throttle implements EventListener {

        /** The delay time. */
        private final long delay;

        /** The delegator. */
        private final EventListener listener;

        /** The latest execution time. */
        private long latest;

        /**
         * @param listener
         */
        private Throttle(long delay, EventListener listener) {
            this.delay = delay;
            this.listener = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(UIEvent event) {
            long now = event.timeStamp;

            if (latest + delay < now) {
                latest = now;

                listener.handleEvent(event);
            }
        }
    }

    /**
     * <p>
     * Built-in listener wrapper.
     * </p>
     * 
     * @version 2013/04/08 13:57:10
     */
    private static class Delay implements EventListener, Runnable {

        /** The delay time. */
        private final long delay;

        /** The delegator. */
        private final EventListener listener;

        /** The lastest event. */
        private UIEvent event;

        /**
         * @param listener
         */
        public Delay(long delay, EventListener listener) {
            this.delay = delay;
            this.listener = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(UIEvent event) {
            this.event = event;
            setTimeout(this, delay);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void run() {
            listener.handleEvent(event);
        }
    }
}
