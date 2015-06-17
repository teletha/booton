/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.event;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import kiss.Events;
import kiss.Observer;

/**
 * @version 2014/01/09 2:57:23
 */
public class EventEmitter<E> implements Observer<E> {

    /** The listener holder. */
    private final List<Listener> listeners = new CopyOnWriteArrayList();

    /** The event holder. */
    private final Deque<E> events = new ArrayDeque();

    /**
     * <p>
     * Observe EventsEmitter.
     * </p>
     * 
     * @param emitter
     * @return
     */
    public Events<E> observe() {
        return new Events<E>(observer -> {
            Listener<E> listener = event -> {
                observer.accept(event);
            };

            add(listener);

            return () -> {
                remove(listener);
            };
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(E event) {
        events.add(event);
    }

    /**
     * <p>
     * Add event listener.
     * </p>
     * 
     * @param listner
     */
    public void add(Listener<E> listner) {
        if (listner != null) {
            listeners.add(listner);
        }
    }

    /**
     * <p>
     * Remove event listener.
     * </p>
     * 
     * @param listener
     */
    public void remove(Listener<E> listener) {
        if (listener != null) {
            listeners.remove(listener);
        }
    }

    /**
     * <p>
     * Emit the specified event.
     * </p>
     * 
     * @param event
     */
    public void emit(E event) {
        for (Listener<E> listener : listeners) {
            listener.listen(event);
        }
    }

    /**
     * <p>
     * Retrieve the oldest event.
     * </p>
     * 
     * @return
     */
    public E retrieve() {
        return events.pollFirst();
    }

    /**
     * <p>
     * Retrieve the oldest event.
     * </p>
     * 
     * @return
     */
    public E retrieveLast() {
        E event = events.pollLast();
        events.clear();
        return event;
    }

    /**
     * <p>
     * Helper method to emit the specified event and retrieve the oldest event.
     * </p>
     * 
     * @param event
     * @return
     */
    public E emitAndRetrieve(E event) {
        emit(event);

        return retrieve();
    }

    /**
     * @version 2014/01/05 10:11:55
     */
    public static interface Listener<E> {

        /**
         * <p>
         * Events listener.
         * </p>
         * 
         * @param event
         */
        public void listen(E event);
    }

    /**
     * <p>
     * Check state.
     * </p>
     * 
     * @return
     */
    public boolean isSubscribed() {
        return !listeners.isEmpty();
    }

    /**
     * <p>
     * Check state.
     * </p>
     * 
     * @return
     */
    public boolean isUnsubscribed() {
        return listeners.isEmpty();
    }
}
