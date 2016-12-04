/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import js.lang.builtin.CSS;

/**
 * @version 2015/09/29 22:52:35
 */
public enum Vendor {

    /** Internet Explorer */
    IE("-ms-"),

    /** Mozilla */
    Mozilla("-moz-"),

    /** Safari */
    Safari("-webkit-"),

    /** Webkit */
    Webkit("-webkit-"),

    /** Standard */
    Standard("");

    /** The current vendor in this environment. */
    public static final Vendor Current;

    /** The current vendor state in this environment. */
    public static final boolean isMozilla;

    /** The current vendor state in this environment. */
    public static final boolean isWebkit;

    // initialization
    static {
        if (CSS.supports("-moz-appearance", "none")) {
            Current = Mozilla;
            isMozilla = true;
            isWebkit = false;
        } else if (CSS.supports("-webkit-appearance", "none")) {
            Current = Webkit;
            isMozilla = false;
            isWebkit = true;
        } else {
            Current = IE;
            isMozilla = false;
            isWebkit = false;
        }
    }

    /** The prefix. */
    private final String prefix;

    /**
     * @param prefix
     */
    private Vendor(String prefix) {
        this.prefix = prefix;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return prefix;
    }
}
