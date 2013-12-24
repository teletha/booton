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

import kiss.Disposable;

/**
 * <p>
 * The event object for the specified {@link EventType} enum.
 * </p>
 * 
 * @version 2013/12/23 21:28:15
 */
public interface Event<E extends Enum & EventType> extends Disposable {

    /**
     * <p>
     * Retrieve the associated {@link EventType} enum.
     * </p>
     * 
     * @return The associated {@link EventType}.
     */
    E getEventType();

    /**
     * <p>
     * Default implementation for {@link Disposable}.
     * </p>
     */
    default void dispose() {
    }
}
