/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.bind;

import java.util.List;

import js.util.ArrayList;

/**
 * @version 2013/03/16 23:55:56
 */
public class Publisher {

    /** The registered subscribers. */
    private final List<Subscriber> subscribers = new ArrayList();

    /**
     * <p>
     * Register the subscriber.
     * </p>
     * 
     * @param subscriber A subscriber to register.
     */
    public final void register(Subscriber subscriber) {
        if (subscriber != null && !subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    /**
     * <p>
     * Unregister the subscriber.
     * </p>
     * 
     * @param subscriber A subscriber to unregister.
     */
    public final void unregister(Subscriber subscriber) {
        if (subscriber != null && !subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    /**
     * <p>
     * Publish event.
     * </p>
     */
    public final void publish() {
        for (Subscriber subscriber : subscribers) {
            try {
                subscriber.receive();
            } catch (Exception e) {
                throw new Error();
            }
        }
    }
}
