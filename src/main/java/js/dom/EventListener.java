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

import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;

/**
 * @version 2013/07/05 1:19:49
 */
public interface EventListener extends JavascriptNative {

    /**
     * <p>
     * Handle registered event.
     * </p>
     * 
     * @param event
     * @return
     */
    @JavascriptNativeProperty
    void handleEvent(Event event);
}