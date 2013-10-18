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

import jsx.bwt.UIEvent;

/**
 * @version 2013/07/05 1:19:49
 */
public interface EventListener {

    /**
     * <p>
     * Handle registered event.
     * </p>
     * 
     * @param event
     * @return
     */
    void handleEvent(UIEvent event);
}