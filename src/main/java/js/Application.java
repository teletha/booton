/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js;

import js.application.Header;

/**
 * @version 2012/12/11 14:19:29
 */
public abstract class Application {

    /**
     * <p>
     * Configure initial page.
     * </p>
     * 
     * @return
     */
    protected abstract Class<? extends Page> initialPage();

    /**
     * <p>
     * Entry point for this application.
     * </p>
     */
    protected abstract void jsmain();

    /**
     * <p>
     * Configure header part.
     * </p>
     * 
     * @param header
     */
    protected void configure(Header header) {
    }
}
