/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.application;

import jsx.jQuery;

/**
 * @version 2012/12/26 13:02:53
 */
public abstract class Page {

    /**
     * <p>
     * Build the page identifier for the current page state. You must be able to restore page state
     * from this page identifier.
     * </p>
     * 
     * @return
     */
    protected abstract String getPageId();

    /**
     * <p>
     * Invoke whenever this page is loaded.
     * </p>
     * 
     * @param root
     */
    public abstract void load(jQuery root);
}
