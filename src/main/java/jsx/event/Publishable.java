/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.event;

/**
 * @version 2013/10/09 15:53:49
 */
public interface Publishable {

    /**
     * <p>
     * Publish the specified event.
     * </p>
     * 
     * @param event
     */
    public default void publish(Object event) {
        Publisher publisher = Publishers.get(this, false);

        if (publisher != null) {
            publisher.publish(event);
        }
    }

    /**
     * <p>
     * Start subscribing events from which the specified {@link Publishable} emits.
     * </p>
     * 
     * @param publishable A target event publisher.
     */
    public default void register(Object subscriber) {
        Publishers.get(this, true).register(subscriber);
    }

    /**
     * <p>
     * Stop subscribing events from which the specified {@link Publishable} emits.
     * </p>
     * 
     * @param publishable A target event publisher.
     */
    public default void unregister(Object subscriber) {
        Publisher publisher = Publishers.get(this, false);

        if (publisher != null) {
            publisher.unregister(subscriber);
        }
    }

    /**
     * <p>
     * This event is called whenever this event target starts listening event.
     * </p>
     * 
     * @version 2013/12/11 9:06:14
     */
    class Start {

        /** The event type. */
        public final Class type;

        /**
         * <p>
         * Create event with type.
         * </p>
         */
        public Start(Class type) {
            this.type = type;
        }
    }

    /**
     * <p>
     * This event is called whenever this event target stops listening event.
     * </p>
     * 
     * @version 2013/12/11 9:06:14
     */
    class Stop {

        /** The event type. */
        public final Class type;

        /**
         * <p>
         * Create event with type.
         * </p>
         */
        public Stop(Class type) {
            this.type = type;
        }
    }
}
