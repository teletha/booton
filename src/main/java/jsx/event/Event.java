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
 * @version 2013/12/23 21:28:15
 */
public interface Event {

    <E extends Enum & EventType> E getEventType();
}
