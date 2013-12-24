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
 * 
 * @version 2013/12/23 19:26:47
 */
public interface EventType<T extends Event> extends Predicate<T> {
}
