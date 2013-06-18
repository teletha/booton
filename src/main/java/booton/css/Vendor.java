/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

/**
 * @version 2013/06/08 9:10:26
 */
public enum Vendor {

    IE("-ms-"),

    Mozilla("-moz-"),

    Webkit("-webkit-"),

    Standard("");

    /** The prefix. */
    public final String prefix;

    /**
     * @param prefix
     */
    private Vendor(String prefix) {
        this.prefix = prefix;
    }
}
