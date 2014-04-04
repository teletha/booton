/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.application;

/**
 * @version 2013/06/17 15:41:12
 */
public final class PageUnload {

    /** The unloading page. */
    public final Page page;

    /**
     * @param page
     */
    public PageUnload(Page page) {
        this.page = page;
    }
}
