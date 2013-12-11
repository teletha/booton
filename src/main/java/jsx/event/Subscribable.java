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
 * @version 2013/12/11 12:04:45
 */
public interface Subscribable {

    /**
     * <p>
     * Start subscribing events from which the specified {@link Publishable} emits.
     * </p>
     * 
     * @param publishable A target event publisher.
     */
    public default void subscribe(Publishable publishable) {
        Publishers.get(publishable, true).register(this);
    }

    /**
     * <p>
     * Stop subscribing events from which the specified {@link Publishable} emits.
     * </p>
     * 
     * @param publishable A target event publisher.
     */
    public default void unsubscribe(Publishable publishable) {
        Publisher publisher = Publishers.get(publishable, false);

        if (publisher != null) {
            publisher.unregister(this);
        }
    }
}
