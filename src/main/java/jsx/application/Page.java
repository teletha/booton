/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.application;

import js.dom.DocumentFragment;
import kiss.Extensible;

/**
 * @version 2013/09/26 23:25:47
 */
public abstract class Page implements Extensible {

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
    public abstract void load(DocumentFragment root);
}
