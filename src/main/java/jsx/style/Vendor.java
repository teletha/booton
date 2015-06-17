/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

/**
 * @version 2013/07/23 23:12:12
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
