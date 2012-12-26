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

import booton.translator.web.jQuery;

/**
 * @version 2012/12/26 13:02:53
 */
public abstract class Page {

    /** The uri pattern, */
    private final String pattern;

    /**
     * @param pattern
     */
    protected Page(String pattern) {
        this.pattern = pattern;
    }

    /**
     * <p>
     * Render page contents.
     * </p>
     * 
     * @param root
     */
    protected abstract void render(jQuery root);
}
