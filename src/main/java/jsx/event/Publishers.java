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

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @version 2013/12/11 11:57:35
 */
class Publishers {

    /**
     * The holder of {@link Publisher}.
     */
    static final Map<Publishable, Publisher> manager = new WeakHashMap();

    /**
     * <p>
     * Find the associated {@link Publisher} for the specified {@link Publishable}.
     * </p>
     * 
     * @param publishable A target.
     * @return An associated {@link Publisher}.
     */
    static Publisher get(Publishable publishable, boolean require) {
        Publisher publisher = manager.get(publishable);

        if (publisher == null && require) {
            publisher = new Publisher();
            manager.put(publishable, publisher);
        }
        return publisher;
    }
}
