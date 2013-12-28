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

import java.util.function.Predicate;

/**
 * <p>
 * Mark the implemented enum as {@link EventType}.
 * </p>
 * <p>
 * FIXME: We should declare as EventType<E extends Event>, but eclipse compiler throws stack
 * overflow error.
 * </p>
 * 
 * @version 2013/12/28 21:47:49
 */
public interface EventType<E> extends Predicate<E> {

    /**
     * <p>
     * Test the specified event object is suitable for this {@link EventType}. Default implementaion
     * always return true.
     * </p>
     */
    @Override
    public default boolean test(E event) {
        return true;
    }
}
